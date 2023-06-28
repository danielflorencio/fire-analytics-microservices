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

    // @GetMapping("/getGraphicalMonthPreview")
    // @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"})
    // public ResponseEntity<User> getGraphicalMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId){
      
    //   // The 1 month graphic should actually show 2 months worth of data.
    //   // So the return type must have a sum of 61 days of data.
    //   // It's gonna be 30 days in the past, the current day, and 30 days in the future. 

    //   // First off, I need to get the total current balance of the user.
    //   Double userZeroTotalBalance = usersData.users.get(0).getTotalBalance();

    //   // Then, I need to get the data from all the user's expenses in the last thirty days. 
    //   // When I have these thirty days of data, I need to calculate the total expenditure and incomes from each day.
    //   // There I will have the first part of my endpoint's response.

    //   // After that, I'll need to use the data from the last thirty days in order to calculate the next thirty days. 
    //   // Then I'll have the complete endpoint's response.

    //   return ResponseEntity.ok().body(usersData.users.get(0));
    // }

}