package com.hangarapi.hangarapi.exceptions;

public class IntegrityViolationException extends RuntimeException {

    public IntegrityViolationException(String message) {
        super(message);
    }
}
