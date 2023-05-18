package com.savely.springbootmockito.service.impl;

import com.savely.springbootmockito.exception.IncorrectDepartmentException;
import com.savely.springbootmockito.model.Employee;
import com.savely.springbootmockito.service.DepartmentService;
import com.savely.springbootmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void checkDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IncorrectDepartmentException("Номер департамента должнен быть от 1 до 5!");
        }
    }

    public List<Employee> findEmployeesByDepartment(int department) {
        checkDepartment(department);

        return employeeService.findAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }


    public int calculateSumSalariesByDepartment(int department) {
        checkDepartment(department);

        return employeeService.findAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getMaxSalaryByDepartment(int department) {
        checkDepartment(department);

        return employeeService.findAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .max().orElse(0);
    }

    public int getMinSalaryByDepartment(int department) {
        checkDepartment(department);

        return employeeService.findAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .min().orElse(0);
    }

    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        return employeeService.findAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
