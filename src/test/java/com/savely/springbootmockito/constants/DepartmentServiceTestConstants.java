package com.savely.springbootmockito.constants;

import com.savely.springbootmockito.model.Employee;

public class DepartmentServiceTestConstants {
    public final static int FIRST_DEP = 1;
    public final static int SECOND_DEP = 2;
    public final static int INVALID_DEP = 7;
    public final static Employee EMPLOYEE_1_DEP_1 = new Employee("Иван", "Иванов", 1, 100000);
    public final static Employee EMPLOYEE_2_DEP_1 = new Employee("Петр", "Петров", 1, 150000);
    public final static Employee EMPLOYEE_1_DEP_2 = new Employee("Алексей", "Алексеев", 2, 140000);
    public final static Employee EMPLOYEE_2_DEP_2 = new Employee("Михаил", "Михайлов", 2, 200000);
    public final static int SUM_SALARIES_DEP_1 = 250000;
    public final static int SUM_SALARIES_DEP_2 = 340000;
    public final static int MAX_SALARY_DEP_1 = 150000;
    public final static int MAX_SALARY_DEP_2 = 200000;
    public final static int MIN_SALARY_DEP_1 = 100000;
    public final static int MIN_SALARY_DEP_2 = 140000;
}
