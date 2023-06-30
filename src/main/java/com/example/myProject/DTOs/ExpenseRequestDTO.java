package com.example.myProject.DTOs;
import java.time.LocalDate;
import com.example.myProject.models.Expense;

public record ExpenseRequestDTO(LocalDate date, String category, String title, double value) {
    public ExpenseRequestDTO(Expense expense){
        this(expense.getDate(), expense.getCategory(), expense.getTitle(), expense.getValue());
    }
}