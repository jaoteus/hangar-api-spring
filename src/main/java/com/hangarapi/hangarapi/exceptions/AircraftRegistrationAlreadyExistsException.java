package com.hangarapi.hangarapi.exceptions;

public class AircraftRegistrationAlreadyExistsException extends RuntimeException {

    public AircraftRegistrationAlreadyExistsException(String message) {
        super(message);
    }
}
