package com.example.myProject.DTOs;

import java.util.Date;

import com.example.myProject.models.Expense;

public record ExpenseResponseDTO(Long id, String title, String category, double value, Date date) {

    public ExpenseResponseDTO(Expense expense){
        this(expense.getId(), expense.getTitle(), expense.getCategory(), expense.getValue(), expense.getDate());
    }
}
