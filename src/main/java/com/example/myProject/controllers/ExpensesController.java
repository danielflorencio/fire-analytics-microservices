package com.example.myProject.controllers;
import com.example.myProject.data.expensesData;
import com.example.myProject.models.Expense;
import com.example.myProject.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expenses")
public class ExpensesController {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("saveExpenses")
    public ResponseEntity<Double> saveExpenses() {
        for (Expense expense : expensesData.expenses) {
            expenseRepository.save(expense);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Status", "ok");
        return ResponseEntity.ok().headers(headers).body(1d); 
    }
}
