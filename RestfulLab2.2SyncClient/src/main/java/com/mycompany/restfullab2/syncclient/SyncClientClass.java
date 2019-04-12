/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab2.syncclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author May
 */
public class SyncClientClass {
    
    
    public static void main(String [] args)
    {  
        postClient();
        getClient();   
    }
    
    public static void getClient() {
        Client client = Client.create();
        String getUrl = "http://localhost:8080/RestfulLab2.1/rest/employeeservices/getall";
        WebResource webResource = client.resource(getUrl);
        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("HTTP Error: " + response.getStatus());
        }
        List<Employee> employees = response.getEntity(new GenericType<List<Employee>>() { });
        System.out.println("GET");
        System.out.println("Response from the Server: ");
        employees.forEach(employee -> System.out.println(employee));
    }

    public static void postClient() {
        try {
            Client client = Client.create();
            String getUrl = "http://localhost:8080/RestfulLab2.1/rest/employeeservices/addemployee";
            WebResource webResource = client.resource(getUrl);
            WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            Employee newEmployee = new Employee("Mai","Manager","123");
            //System.out.println(newEmployee);
            ObjectMapper mapper = new ObjectMapper();
            String request = mapper.writeValueAsString(newEmployee);
            //System.out.println(request);
            ClientResponse response = builder.post(ClientResponse.class, request);
            if (response.getStatus() != 200) {
                throw new RuntimeException("HTTP Error: " + response.getStatus());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
