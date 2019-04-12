/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author May
 */
@Path("/calculator")
public class MyRestfulServices {
    
    
    @GET
    @Path("/add")
    public int add(@QueryParam("num1") int num1, @QueryParam("num2") int num2)
    {
        return num1 + num2;
    }
    
    @GET
    @Path("/subtract")
    public int subtract(@QueryParam("num1") int num1, @QueryParam("num2") int num2)
    {
        return num1 - num2;
    }
    
    @GET
    @Path("/multiply")
    public int multiply(@QueryParam("num1") int num1, @QueryParam("num2") int num2)
    {
        return num1 * num2;
    }
    
    @GET
    @Path("/divide")
    public int divide(@QueryParam("num1") int num1, @QueryParam("num2") int num2)
    {
        return num1 / num2;
    }
    
}
