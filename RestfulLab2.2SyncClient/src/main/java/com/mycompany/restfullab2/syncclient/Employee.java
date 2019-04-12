/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfullab2.syncclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author May
 */
@XmlRootElement(name="employee")
public class Employee {
    
    String name;
    String position;
    String id;
      
    public static int index = 1;
    public static Map<String,Employee> map = new HashMap<String, Employee>();

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", position=" + position + ", id=" + id + '}';
    }
   
    
    
    public void addDummyData()
    {
        Employee emp1 = new Employee("Mai","Manager","123");
        Employee emp2 = new Employee("Muhammad","Manager","124");
        Employee emp3 = new Employee("Ahmed","Manager","124");
    
        map.put("1", emp1);
        map.put("2", emp2);
        map.put("3", emp3);
    }
    
    public Employee() {

    }

    public Employee(String name, String position, String id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public Employee addEmployee(Employee employee)
    {
        map.put(employee.getId(), employee);
        employee = map.get(employee.getId());
        return employee;   
    }
    
    public void deleteEmployee(String id)
    {
        map.remove(id);
    }
    
    
    public List<Employee> retrieveAllEmployees()
    {
        //addDummyData();
        List<Employee> listofemployees = new ArrayList<>(map.values());
        return listofemployees;
    }
    
    public Employee retrieveOneEmployee(String id)
    {
        return map.get(id);
    }
    
    public Employee updateEmployee(Employee employee)
    {
        return map.replace(employee.getId(), employee);
    }
    
    
}
