package com.microservice.user.service.userservice.payload;

import lombok.*;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.http.HttpStatus;
@Builder
@Getter

public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;


}