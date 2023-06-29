package com.example.myProject.DTOs;

import java.util.Date;

import com.example.myProject.models.Expense;

public record ExpenseRequestDTO(Date date, String category, String title, double value) {
    public ExpenseRequestDTO(Expense expense){
        this(expense.getDate(), expense.getCategory(), expense.getTitle(), expense.getValue());
    }
}