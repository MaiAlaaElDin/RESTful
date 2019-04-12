/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab2.asyncclient;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author May
 */
public class AsyncClientClass {
    
    public static void main(String[] args) {

        postClient();
        getClient();

    }

    public static void getClient() {
        ClientConfig cc = new DefaultNonBlockingClientConfig();
        cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client client = NonBlockingClient.create(cc);
        String getUrl = "http://localhost:8080/RestfulLab2.1/rest/employeeservices/getall";
        AsyncWebResource awr = client.asyncResource(getUrl);
        AsyncWebResource.Builder builder = awr.accept(MediaType.APPLICATION_JSON);
        builder.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                try {
                    ClientResponse response = future.get();
                    if (response.getStatus() != 200) {
                        throw new RuntimeException("HTTP Error: " + response.getStatus());
                    }
                    List<Employee> employees = response.getEntity(new GenericType<List<Employee>>() {
                    });
                    System.out.println("GET");
                    System.out.println("Response from the Server: ");
                    employees.forEach(employee -> System.out.println(employee));
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void postClient() {
        try {
            ClientConfig cc = new DefaultNonBlockingClientConfig();
            cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
            Client client = NonBlockingClient.create(cc);
            String postUrl = "http://localhost:8080/RestfulLab2.1/rest/employeeservices/addemployee";
            AsyncWebResource awr = client.asyncResource(postUrl);
            AsyncWebResource.Builder builder = awr.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            Employee newEmployee = new Employee("Mai Alaa","Manager","1234567");
            ObjectMapper mapper = new ObjectMapper();
            String request = mapper.writeValueAsString(newEmployee);
            builder.post(new TypeListener<ClientResponse>(ClientResponse.class) {
                @Override
                public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                    try {
                        ClientResponse response = future.get();
                        if (response.getStatus() != 200) {
                            throw new RuntimeException("HTTP Error: " + response.getStatus());
                        }
                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
            },request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
}
