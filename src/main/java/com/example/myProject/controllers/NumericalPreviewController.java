package com.example.myProject.controllers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProject.data.expensesData;
import com.example.myProject.models.NumericalPreview;
import com.example.myProject.util.FinancialCalculator;
@RestController
@RequestMapping("numericalPreview")
public class NumericalPreviewController {

    FinancialCalculator financialCalculator = new FinancialCalculator();

    @GetMapping("/getMonthPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      
        // Get the expenses from the database.

            // expensesData

        // Get the expenses from the database.
      
        Double monthPreview = financialCalculator.calculateMonthPreview(expensesData.expenses);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Status", "ok");
        return ResponseEntity.ok().headers(headers).body(monthPreview);    
    }
    @GetMapping("/getSixMonthsPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getSixMonthsPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
        NumericalPreview sixMonthsPreview = new NumericalPreview();
        sixMonthsPreview.setPreviewValue(financialCalculator.calculateSixMonthsPreview(expensesData.expenses));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Status", "ok");
        return ResponseEntity.ok().headers(headers).body(sixMonthsPreview.getPreviewValue());    
    }

    @GetMapping("/getYearPreview")
    @CrossOrigin(origins = {"http://localhost:19000/", "http://localhost:3000/", "http://192.168.0.102:19000"}) 
    public ResponseEntity<Double> getYearPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
        NumericalPreview yearPreview = new NumericalPreview();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Status", "ok");
        return ResponseEntity.ok().headers(headers).body(yearPreview.getPreviewValue());    
    }

}