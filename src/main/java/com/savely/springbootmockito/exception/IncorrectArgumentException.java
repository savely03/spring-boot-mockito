package com.savely.springbootmockito.exception;

public class IncorrectArgumentException extends IllegalArgumentException {
    public IncorrectArgumentException(String message) {
        super(message);
    }
}
