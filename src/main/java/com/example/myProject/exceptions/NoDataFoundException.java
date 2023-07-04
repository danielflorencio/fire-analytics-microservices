package com.example.myProject.exceptions;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(){
        super(String.format("No data found exception."));
    }
}
