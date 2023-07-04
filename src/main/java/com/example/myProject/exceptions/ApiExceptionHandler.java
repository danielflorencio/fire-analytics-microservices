package com.example.myProject.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NoDataFoundException ex, WebRequest request) {
        // Create an ErrorResponse object with the appropriate error message

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Data not found");

        // ErrorResponse errorResponse = new ErrorResponse("Custom Error", ex.getMessage());
       
        // Return a ResponseEntity with the error response and an appropriate HTTP status code
        // return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
   }

}
