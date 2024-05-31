package com.hangarapi.hangarapi.exceptions;

public class HangarNotFoundException extends  RuntimeException{

    public HangarNotFoundException(String message) {
        super(message);
    }
}
