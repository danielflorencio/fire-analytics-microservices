package com.example.myProject.controllers;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

  @GetMapping("/getOneMonthGraphicalPreview")
  @CrossOrigin(origins = {"*"})
  public ResponseEntity<GraphicalPreview> getOneMonthGraphicalPreviewResponse(@RequestParam(value = "email", defaultValue = "default@email.com") String email){

    // The argument for the function below should be received in the request of the endpoint.
    // First off, I need to get the total current balance of the user.

    LocalDate endDateToFetch = LocalDate.of(2023, 3, 1);
    GraphicalPreview graphicalPreview = expenseService.getOneMonthGraphicalPreview(endDateToFetch.minusDays(30), endDateToFetch);

    return ResponseEntity.ok().body(graphicalPreview);
  }

  @GetMapping("/getGraphicalPreview")
  @CrossOrigin(origins = {"*"})
  public ResponseEntity<GraphicalPreview> getSixMonthsGraphicalPreviewResponse(
    @RequestParam(value = "email", defaultValue = "default@email.com") String email, 
    @RequestParam LocalDate initialDate, 
    @RequestParam LocalDate finalDate
    )
    {
      

    // LocalDate newInitialDate = LocalDate.parse(initialDate);
    // LocalDate newFinalDate = LocalDate.parse(finalDate);

    // System.out.println(finalDate);

    GraphicalPreview graphicalPreview = expenseService.getGraphicalPreview(initialDate, finalDate);
    
    // return ResponseEntity.ok().body(graphicalPreview);
    // System.out.println("INITIAL DATE: ");
    // System.out.println(new);
    // System.out.println("FINAL DATE: ");
    // System.out.println(finalDate);

    return ResponseEntity.ok().body(graphicalPreview);
  }
  
  @GetMapping("/getSixMonthsGraphicalPreview")
  @CrossOrigin(origins = {"*"})
  public ResponseEntity<GraphicalPreview> getOneYearGraphicalPreviewResponse(@RequestParam(value = "email", defaultValue = "default@email.com") String email){

    LocalDate endDateToFetch = LocalDate.of(2023, 3, 1);
    GraphicalPreview graphicalPreview = expenseService.getOneMonthGraphicalPreview(endDateToFetch.minusDays(365), endDateToFetch);

    return ResponseEntity.ok().body(graphicalPreview);
  }


}
