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

  @GetMapping("/getGraphicalPreview")
  @CrossOrigin(origins = {"*"})
  // Query: http://localhost:8080/graphicalPreview/getGraphicalPreview?initialDate=2023-01-01&finalDate=2023-02-26
  public ResponseEntity<GraphicalPreview> getGraphicalPreviewResponse(
    @RequestParam(value = "email", defaultValue = "default@email.com") String email, 
    @RequestParam LocalDate initialDate, 
    @RequestParam LocalDate finalDate
    )
    {

    // System.out.println("INITIAL DATE ON GETGRAPHICALPREVIEW: ");
    // System.out.println(initialDate);
    // System.out.println("FINAL DATE ON GETGRAPHICALPREVIEW: ");
    // System.out.println(finalDate);
    GraphicalPreview graphicalPreview = expenseService.getGraphicalPreview(initialDate, finalDate);

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
