package com.example.myProject.controllers;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
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
}
