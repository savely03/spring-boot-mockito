package com.savely.springbootmockito.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private int salary;
}
