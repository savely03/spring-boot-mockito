package com.savely.springbootmockito.service;

import com.savely.springbootmockito.exception.EmployeeAlreadyAddedException;
import com.savely.springbootmockito.exception.EmployeeNotFoundException;
import com.savely.springbootmockito.exception.IncorrectArgumentException;
import com.savely.springbootmockito.exception.IncorrectDepartmentException;
import com.savely.springbootmockito.model.Employee;
import com.savely.springbootmockito.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.savely.springbootmockito.constants.EmployeeServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService employeeService;
    private final Employee expected = new Employee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployeeTest() {
        Employee employee = employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        assertThat(employee).isEqualTo(expected);
    }

    @Test
    void addWhenEmployeeAlreadyAddedTest() {
        employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class).isThrownBy(
                () -> employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY)
        );
    }

    @Test
    void addEmployeeWithInvalidFirstNameAndLastNameTest() {
        assertThatExceptionOfType(IncorrectArgumentException.class).isThrownBy(
                () -> employeeService.addEmployee(INVALID_FIRSTNAME, INVALID_LASTNAME, VALID_DEPARTMENT, SALARY)
        );
    }

    @Test
    void addEmployeeWithInvalidDepartmentTest() {
        assertThatExceptionOfType(IncorrectDepartmentException.class).isThrownBy(
                () -> employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, INVALID_DEPARTMENT, SALARY)
        );
    }

    @Test
    void removeEmployeeTest() {
        employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        Employee employee = employeeService.removeEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        assertThat(employee).isEqualTo(expected);
    }

    @Test
    void removeWhenEmployeeDoesNotExistTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(
                () -> employeeService.removeEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY)
        );
    }

    @Test
    void findEmployeeTest() {
        employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        Employee employee = employeeService.findEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        assertThat(employee).isEqualTo(expected);
    }

    @Test
    void findWhenEmployeeDoesNotExist() {
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(
                () -> employeeService.findEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY)
        );
    }

    @Test
    void findAllEmployees() {
        employeeService.addEmployee(VALID_FIRSTNAME, VALID_LASTNAME, VALID_DEPARTMENT, SALARY);

        assertThat(employeeService.findAllEmployees()).hasSize(1).containsOnly(expected);
    }
}