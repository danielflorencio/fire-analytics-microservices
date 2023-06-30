package com.example.myProject.controllers;
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
  @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"})
  public ResponseEntity<List<DayData>> getGraphicalMonthPreview(@RequestParam(value = "email", defaultValue = "default@email.com") String email){

    // The 1 month graphic should actually show 2 months worth of data.
    // So the return type must have a sum of 61 days of data.
    // It's gonna be 30 days in the past, the current day, and 30 days in the future. 


    // I need to remember to change this later.
    // The argument for the function below should be received in the request of the endpoint.    
    // List<ExpenseResponseDTO> lastMonthExpenses = expenseService.getOneMonthGraphicalPreview(expensesData.expenses.get(0).getDate(), expensesData.expenses.get(expensesData.expenses.size() - 1).getDate());
    List<DayData> lastMonthDayData = expenseService.getOneMonthGraphicalPreview(expensesData.expenses.get(0).getDate(), expensesData.expenses.get(expensesData.expenses.size() - 1).getDate());
    // System.out.println("EXPENSE LIST");
    // // System.out.println(lastMonthExpenses.size());
    // System.out.println(lastMonthExpenses);

    List<Expense> expenses = new ArrayList<>();
 

    List<DayData> thirtyPastDays = new ArrayList<>();
    thirtyPastDays = financialCalculator.getDaysData(expenses);

    // System.out.println("DAYSDATA: ");
    // System.out.println(thirtyPastDays.size());
    // System.out.println(thirtyPastDays);

    // First off, I need to get the total current b alance of the user.
    // Double userZeroTotalBalance = usersData.users.get(0).getTotalBalance();

    // Then, I need to get the data from all the user's expenses in the last thirty days. 
    // When I have these thirty days of data, I need to calculate the total expenditure and incomes from each day.
    // There I will have the first part of my endpoint's response.

    // After that, I'll need to use the data from the last thirty days in order to calculate the next thirty days. 
    // Then I'll have the complete endpoint's response.

    return ResponseEntity.ok().body(lastMonthDayData);
  }
    
}
