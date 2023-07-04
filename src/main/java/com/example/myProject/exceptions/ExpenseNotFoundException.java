package com.example.myProject.exceptions;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(){
        super("No Expenses founds.");
    }
}
