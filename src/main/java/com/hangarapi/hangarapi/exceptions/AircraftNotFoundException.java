package com.hangarapi.hangarapi.exceptions;

public class AircraftNotFoundException extends  RuntimeException {

    public AircraftNotFoundException(String message) {
        super(message);
    }
}
