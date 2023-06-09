package com.savely.springbootmockito.service;

import com.savely.springbootmockito.exception.IncorrectDepartmentException;
import com.savely.springbootmockito.model.Employee;
import com.savely.springbootmockito.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static com.savely.springbootmockito.constants.DepartmentServiceTestConstants.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    private final List<Employee> employees = List.of(EMPLOYEE_1_DEP_1, EMPLOYEE_2_DEP_1, EMPLOYEE_1_DEP_2, EMPLOYEE_2_DEP_2);

    @BeforeEach
    void setUp() {
        lenient().when(employeeService.findAllEmployees()).thenReturn(employees);
    }

    @Test
    void checkInvalidDepartmentTest() {
        assertThatExceptionOfType(IncorrectDepartmentException.class).isThrownBy(
                () -> out.checkDepartment(INVALID_DEP)
        );
    }

    @Test
    void findEmployeesByFirstDepartmentTest() {
        List<Employee> employees = out.findEmployeesByDepartment(FIRST_DEP);

        assertThat(employees).hasSize(2).containsOnly(EMPLOYEE_1_DEP_1, EMPLOYEE_2_DEP_1);
    }

    @Test
    void findEmployeesBySecondDepartmentTest() {
        List<Employee> employees = out.findEmployeesByDepartment(SECOND_DEP);

        assertThat(employees).hasSize(2).containsOnly(EMPLOYEE_1_DEP_2, EMPLOYEE_2_DEP_2);
    }

    @Test
    void calculateSumSalariesByFirstDepartmentTest() {
        assertThat(out.calculateSumSalariesByDepartment(FIRST_DEP)).isEqualTo(SUM_SALARIES_DEP_1);
    }

    @Test
    void calculateSumSalariesBySecondDepartmentTest() {
        assertThat(out.calculateSumSalariesByDepartment(SECOND_DEP)).isEqualTo(SUM_SALARIES_DEP_2);
    }

    @Test
    void getMaxSalaryByFirstDepartmentTest() {
        assertThat(out.getMaxSalaryByDepartment(FIRST_DEP)).isEqualTo(MAX_SALARY_DEP_1);
    }

    @Test
    void getMaxSalaryBySecondDepartmentTest() {
        assertThat(out.getMaxSalaryByDepartment(SECOND_DEP)).isEqualTo(MAX_SALARY_DEP_2);
    }

    @Test
    void getMinSalaryByFirstDepartmentTest() {
        assertThat(out.getMinSalaryByDepartment(FIRST_DEP)).isEqualTo(MIN_SALARY_DEP_1);
    }

    @Test
    void getMinSalaryBySecondDepartmentTest() {
        assertThat(out.getMinSalaryByDepartment(SECOND_DEP)).isEqualTo(MIN_SALARY_DEP_2);
    }

    @Test
    void getEmployeesGroupByDepartments() {
        Map<Integer, List<Employee>> expected = Map.of(
                FIRST_DEP, List.of(EMPLOYEE_1_DEP_1, EMPLOYEE_2_DEP_1),
                SECOND_DEP, List.of(EMPLOYEE_1_DEP_2, EMPLOYEE_2_DEP_2)
        );

        assertThat(out.getEmployeesGroupByDepartments()).hasSize(2).isEqualTo(expected);
    }

}