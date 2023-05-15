package com.savely.springbootmockito.controller;

import com.savely.springbootmockito.model.Employee;
import com.savely.springbootmockito.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    List<Employee> findEmployeesByDepartment(@PathVariable("id") int department) {
        return departmentService.findEmployeesByDepartment(department);
    }

    @GetMapping("/{id}/salary/sum")
    int calculateSumSalariesByDepartment(@PathVariable("id") int department) {
        return departmentService.calculateSumSalariesByDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    int getMaxSalaryByDepartment(@PathVariable("id") int department) {
        return departmentService.getMaxSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    int getMinSalaryByDepartment(@PathVariable("id") int department) {
        return departmentService.getMinSalaryByDepartment(department);
    }

    @GetMapping("/employees")
    Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        return departmentService.getEmployeesGroupByDepartments();
    }
}
