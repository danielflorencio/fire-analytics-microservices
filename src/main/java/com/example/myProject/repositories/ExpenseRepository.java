package com.example.myProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myProject.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}