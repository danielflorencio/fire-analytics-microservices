package com.example.myProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProject.controllers.ExpensesController;
import com.example.myProject.models.Expense;
import com.example.myProject.repositories.ExpenseRepository;

@SpringBootApplication
@RestController
public class MyProject {
    public static void main(String[] args) {
      SpringApplication.run(MyProject.class, args);
    }

}