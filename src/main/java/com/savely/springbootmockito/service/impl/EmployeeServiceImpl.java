package com.savely.springbootmockito.service.impl;


import com.savely.springbootmockito.exception.EmployeeAlreadyAddedException;
import com.savely.springbootmockito.exception.EmployeeNotFoundException;
import com.savely.springbootmockito.exception.IncorrectArgumentException;
import com.savely.springbootmockito.exception.IncorrectDepartmentException;
import com.savely.springbootmockito.model.Employee;
import com.savely.springbootmockito.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashSet<>();
    }

    private void checkFirstNameAndLastName(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new IncorrectArgumentException("Переданные имя и фамилия должны содержать только буквы!");
        }
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        checkFirstNameAndLastName(firstName, lastName);

        if (department < 1 || department > 5) {
            throw new IncorrectDepartmentException("Номер департамента должнен быть от 1 до 5!");
        }

        Employee employee = new Employee(StringUtils.capitalize(firstName.toLowerCase()),
                StringUtils.capitalize(lastName.toLowerCase()), department, salary);

        if (employees.add(employee)) {
            return employee;
        }
        throw new EmployeeAlreadyAddedException("Работник уже существует!");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Работник не найден!");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Работник не найден!");
        }

        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return new ArrayList<>(employees);
    }

}
