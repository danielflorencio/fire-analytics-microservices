package com.example.myProject;
import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.data.expensesData;
import com.example.myProject.data.usersData;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import com.example.myProject.models.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import com.example.myProject.util.FinancialCalculator;

@SpringBootApplication
@RestController
public class MyProject {
    public static void main(String[] args) {
      SpringApplication.run(MyProject.class, args);
    }
    @GetMapping("/multiply")
    public String hello(@RequestParam(value = "number", defaultValue = "0") float number) {
      return String.format("The response is %s!", number*2);
    }
    @GetMapping("/previewValues")
    public String hello(@RequestParam(value = "userId", defaultValue = "0") double number) {
      return String.format("The response is %s!", expensesData.expenses.toString());
    }

    // public List<Date> getSortedDates(List<Expense> expenses) {
    //   List<Date> dates = new ArrayList<>();  
    //   for (Expense expense : expenses) {
    //       dates.add(expense.getDate());
    //   }  
    //   Collections.sort(dates);
    //   return dates;
    // }

    public List<DayData> getDaysData(String userId){
      FinancialCalculator calculator = new FinancialCalculator();

      List<Date> sortedDates = new ArrayList<>(calculator.getSortedDates(expensesData.expenses));
      // Get the data from the database. In this case, we're gonna get it from another java file.  
      List<DayData> daysData = new ArrayList<>();
      for(int i = 0; i < sortedDates.size(); i++){
        DayData newDay = new DayData(sortedDates.get(i));
        daysData.add(newDay);
      }
      for(int i = 0; i < sortedDates.size(); i++){
        for(int n = 0; n < expensesData.expenses.size(); n++){
          if(sortedDates.get(i).equals(expensesData.expenses.get(n).getDate())){
            if(expensesData.expenses.get(n).getCategory().equals("salary") || expensesData.expenses.get(n).getCategory().equals("Salary")){
              daysData.get(i).addIncomeValue(expensesData.expenses.get(n).value);              
            } else{
              daysData.get(i).addExpenseValue(expensesData.expenses.get(n).value);
            }
          }
        }
      }
      return daysData;
    }

    public Double calculateTimePreview(int amountOfDays, List<DayData> daysData){
      Double preview = 0.0;
      Double averageDailyGain = daysData.get(0).getIncomes();
      Double averageDailyLoss = daysData.get(0).getExpenses();
      for(int i = 1; i < daysData.size(); i++){
        averageDailyGain = (averageDailyGain + daysData.get(i).getIncomes())/2;
        averageDailyLoss = (averageDailyLoss + daysData.get(i).getExpenses())/2;
      }
      for(int i = 0; i < amountOfDays; i ++){
        preview = preview + (averageDailyGain - averageDailyLoss);
      }
      return preview;
    }

    public Double calculateMonthPreview(String userId){      
      List<DayData> daysData = getDaysData(userId);
      Double monthPreview = calculateTimePreview(30, daysData);
      return monthPreview;
    }

    public Double calculateSixMonthsPreview(String userId){      
      List<DayData> daysData = getDaysData(userId);
      Double sixMonthsPreview = calculateTimePreview(182, daysData);
      return sixMonthsPreview;
    }

    public Double calculateYearPreview(String userId){ 
      List<DayData> daysData = getDaysData(userId);
      Double yearPreview = calculateTimePreview(365, daysData);
      return yearPreview;
    }

    @GetMapping("/getMonthPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      Double monthPreview = calculateMonthPreview(userId);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Status", "ok");
      return ResponseEntity.ok().headers(headers).body(monthPreview);    
    }
    @GetMapping("/getSixMonthsPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getSixMonthsPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      Double monthPreview = calculateSixMonthsPreview(userId);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Status", "ok");
      return ResponseEntity.ok().headers(headers).body(monthPreview);    
    }
    @GetMapping("/getYearPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getYearPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      Double monthPreview = calculateYearPreview(userId);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Status", "ok");
      return ResponseEntity.ok().headers(headers).body(monthPreview);    
    }

    @GetMapping("/getGraphicalMonthPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"})
    public ResponseEntity<User> getGraphicalMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId){
      
      // The 1 month graphic should actually show 2 months worth of data.
      // So the return type must have a sum of 61 days of data.
      // It's gonna be 30 days in the past, the current day, and 30 days in the future. 

      // First off, I need to get the total current balance of the user.
      Double userZeroTotalBalance = usersData.users.get(0).getTotalBalance();

      // Then, I need to get the data from all the user's expenses in the last thirty days. 
      // When I have these thirty days of data, I need to calculate the total expenditure and incomes from each day.
      // There I will have the first part of my endpoint's response.

      // After that, I'll need to use the data from the last thirty days in order to calculate the next thirty days. 
      // Then I'll have the complete endpoint's response.

      return ResponseEntity.ok().body(usersData.users.get(0));
    }




}