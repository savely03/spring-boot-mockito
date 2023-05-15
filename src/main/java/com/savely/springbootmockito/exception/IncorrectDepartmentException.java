package com.savely.springbootmockito.exception;

public class IncorrectDepartmentException extends RuntimeException {
    public IncorrectDepartmentException(String message) {
        super(message);
    }
}
