package com;
import java.util.ArrayList; 
import java.util.Collections;   

public class EmployeeSorter {     

	public static ArrayList<Employee> getSortedEmployeeByAge(ArrayList<Employee> employee) {         
    Collections.sort(employee);         
    return employee;     
  } 
}