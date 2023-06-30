package com.example.myProject.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.data.expensesData;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import com.example.myProject.models.GraphicalPreview;
import com.example.myProject.services.ExpenseService;
import com.example.myProject.util.FinancialCalculator;

@RestController
@RequestMapping("graphicalPreview")
public class GraphicalPreviewController {

  FinancialCalculator financialCalculator = new FinancialCalculator();

  private final ExpenseService expenseService;

  @Autowired
  public GraphicalPreviewController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @GetMapping("/getGraphicalMonthPreview")
  @CrossOrigin(origins = {"*"})
  public ResponseEntity<GraphicalPreview> getGraphicalMonthPreview(@RequestParam(value = "email", defaultValue = "default@email.com") String email){

    // The 1 month graphic should actually show 2 months worth of data.
    // So the return type must have a sum of 61 days of data.
    // It's gonna be 30 days in the past, the current day, and 30 days in the future. 

    // I need to remember to change this later.
    // The argument for the function below should be received in the request of the endpoint.
    List<DayData> lastMonthDayData = expenseService.getOneMonthGraphicalPreview(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 3, 1));

    // First off, I need to get the total current balance of the user.

    GraphicalPreview graphicalPreview = new GraphicalPreview(lastMonthDayData);

    // Then, I need to get the data from all the user's expenses in the last thirty days. 
    // When I have these thirty days of data, I need to calculate the total expenditure and incomes from each day.
    // There I will have the first part of my endpoint's response.

    // After that, I'll need to use the data from the last thirty days in order to calculate the next thirty days. 
    // Then I'll have the complete endpoint's response.

    return ResponseEntity.ok().body(graphicalPreview);
  }
    
}
