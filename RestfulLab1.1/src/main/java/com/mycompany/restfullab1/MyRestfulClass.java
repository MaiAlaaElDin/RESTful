/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author May
 */
@Path("/hellorestful")
public class MyRestfulClass {
    
    @GET
    public String getTestService() {
        return "Hello World! This is coming from webservice!!";
    }
    
    @GET
    @Path("/sayHello")
    public String sayHello(@QueryParam("name") String name)
    {
        return "Hello " + name;
    }
    
    @GET
    @Path("/{name}")
    public String sayGoodbye(@PathParam("name") String name)
    {
        return "Goodbye "+ name;
    }

    
}
