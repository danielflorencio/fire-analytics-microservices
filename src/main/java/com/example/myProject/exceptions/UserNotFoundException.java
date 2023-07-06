package com.example.myProject.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super(String.format("User not foudn."));
    }
    public UserNotFoundException(String errorMessage){
        super(String.format(errorMessage));
    }  
}
