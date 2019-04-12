/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab2;

import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author May
 */
@Path("/employeeservices")
public class EmployeeServices {
    
    Employee employee = new Employee();
    
    @Path("/addemployee")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Employee addEmployee(Employee employee)
    {
         return employee.addEmployee(employee);
    }
    
    @Path("/{id}")
    @DELETE
    public void deleteEmployee(@PathParam("id") String id)
    {
         employee.deleteEmployee(id);
    }
    
    @Path("/getall")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> retrieveAllEmployees()
    {
        return employee.retrieveAllEmployees();
    }
    
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Employee retrieveOneEmployee(@PathParam("id") String id)
    {
        return employee.retrieveOneEmployee(id);
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Employee retrieveOneEmployee(Employee employee)
    {
        return this.employee.updateEmployee(employee);
    }
      
    
}
