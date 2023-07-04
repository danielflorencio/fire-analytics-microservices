package com.example.myProject.controllers;
import com.example.myProject.data.expensesData;
import com.example.myProject.models.Expense;
import com.example.myProject.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expenses")
public class ExpensesController {
    
}