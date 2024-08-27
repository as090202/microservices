package com.microservice.user.service.userservice.exceptions;

//import com.microservice.user.service.userservice.payload.ApiResonse;
import com.microservice.user.service.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourcenotFoundexception.class )
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourcenotFoundexception ex){
String message=ex.getMessage();
ApiResponse response=  ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
