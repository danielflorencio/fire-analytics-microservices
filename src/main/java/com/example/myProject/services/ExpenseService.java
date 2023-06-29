package com.example.myProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.DTOs.FoodResponseDTO;
import com.example.myProject.models.Expense;
import com.example.myProject.repositories.ExpenseRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseResponseDTO> getOneMonthGraphicalPreview() {

        LocalDate currentDate = LocalDate.now();
        // Date dateToUse = new Date(currentDate.getYear(), currentDate.getMonth().minus(1).getValue(), currentDate.getDayOfMonth(), 0, 0, 0);
        Date dateToUse = new Date(currentDate.getYear(), 1, currentDate.getDayOfMonth(), 0, 0, 0);
        // List<Expense> lastMonthExpenses = expenseRepository.findByDateBefore(dateToUse);
        // List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        // List<ExpenseResponseDTO> lastMonthExpenses = expenseRepository.findAll().stream().map(ExpenseResponseDTO::new).toList();
        
        List<ExpenseResponseDTO> lastMonthExpenses = expenseRepository.findAll().stream().map(ExpenseResponseDTO::new).toList();
        System.out.println(expenseRepository.findAll().stream().map(ExpenseResponseDTO::new).toList());
        // return expenseRepository.findByDateBefore(dateToUse);
        // return expenseRepository.findByDateBefore(1);
        return lastMonthExpenses;
    }
}