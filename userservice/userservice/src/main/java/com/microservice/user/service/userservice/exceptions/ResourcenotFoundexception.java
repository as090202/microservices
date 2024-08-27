package com.microservice.user.service.userservice.exceptions;

public class ResourcenotFoundexception extends RuntimeException {
    public ResourcenotFoundexception() {


        super("Resource not found in server");
    }

    public ResourcenotFoundexception(String message) {
        super();
    }
}