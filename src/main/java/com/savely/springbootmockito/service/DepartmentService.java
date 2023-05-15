package com.savely.springbootmockito.service;

import com.savely.springbootmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> findEmployeesByDepartment(int department);

    int calculateSumSalariesByDepartment(int department);

    int getMaxSalaryByDepartment(int department);

    int getMinSalaryByDepartment(int department);

    Map<Integer, List<Employee>> getEmployeesGroupByDepartments();

}
