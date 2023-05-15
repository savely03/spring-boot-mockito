package com.savely.springbootmockito.handler;


import com.savely.springbootmockito.exception.EmployeeAlreadyAddedException;
import com.savely.springbootmockito.exception.EmployeeNotFoundException;
import com.savely.springbootmockito.exception.IncorrectArgumentException;
import com.savely.springbootmockito.exception.IncorrectDepartmentException;
import com.savely.springbootmockito.util.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GeneralExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public Response handleEmpAlreadyAddedEx(EmployeeAlreadyAddedException e) {
        return new Response(e.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public Response handleEmpNotFoundEx(EmployeeNotFoundException e) {
        return new Response(e.getMessage());
    }


    @ExceptionHandler(IncorrectArgumentException.class)
    public Response handleIncorrectArgEx(IncorrectArgumentException e) {
        return new Response(e.getMessage());
    }

    @ExceptionHandler(IncorrectDepartmentException.class)
    public Response handleIncorrectDepEx(IncorrectDepartmentException e) {
        return new Response(e.getMessage());
    }
}
