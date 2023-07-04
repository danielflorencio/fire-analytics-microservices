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

  @Autowired
  private final ExpenseService expenseService;

  @Autowired
  public GraphicalPreviewController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  // Query: http://localhost:8080/graphicalPreview/getGraphicalPreview?initialDate=2023-01-01&finalDate=2023-02-26
  @GetMapping("/getGraphicalPreview")
  @CrossOrigin(origins = {"*"})
  public ResponseEntity<GraphicalPreview> getGraphicalPreviewResponse(
    @RequestParam(value = "email", defaultValue = "default@email.com") String email, 
    @RequestParam LocalDate initialDate, 
    @RequestParam LocalDate finalDate
    )
    {

    GraphicalPreview graphicalPreview = expenseService.getGraphicalPreview(initialDate, finalDate);

    return ResponseEntity.ok().body(graphicalPreview);
  }

}
