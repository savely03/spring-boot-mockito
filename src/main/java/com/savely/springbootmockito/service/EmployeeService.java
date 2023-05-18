package com.savely.springbootmockito.service;


import com.savely.springbootmockito.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName, int department, int salary);

    List<Employee> findAllEmployees();

}
