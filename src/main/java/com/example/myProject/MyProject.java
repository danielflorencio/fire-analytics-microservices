package com.example.myProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.data.expensesData;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
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
    @GetMapping("/preview")
    public String hello(@RequestParam(value = "userId", defaultValue = "0") double number) {
      return String.format("The response is %s!", expensesData.expenses.toString());
    }

    public List<Date> getSortedDates(List<Expense> expenses) {
      List<Date> dates = new ArrayList<>();  
      for (Expense expense : expenses) {
          dates.add(expense.getDate());
      }  
      Collections.sort(dates);
      return dates;
    }

    public List<DayData> calculateMonthPreview(String userId){      
      List<Date> sortedDates = new ArrayList<>(getSortedDates(expensesData.expenses));
      System.out.println("Sorted Dates: " + sortedDates);
      // Get the data from the database. In this case, we're gonna get it from another java file.  
      List<DayData> daysData = new ArrayList<>();
      
      for(int i = 0; i < sortedDates.size(); i++){
        
        DayData newDay = new DayData(sortedDates.get(i));
        daysData.add(newDay);
        // daysData.set(i, newDay);
        // daysData.set(i, sortedDates.get(i))
        // daysData = (List<DayData>) new DayData(sortedDates.get(i));
      }
      System.out.println("daysData post first FOR: " + daysData);
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
      System.out.println("daysData post second: " + daysData);
      return daysData;
    }


    @GetMapping("/testDaysData")
    public String testDaysData(@RequestParam(value = "userId", defaultValue = "0") double number) {
      return String.format("The response is %s!", calculateMonthPreview(null));
    }


    @GetMapping("/days-data-json")
    public ResponseEntity<List<DayData>> getDaysData(@RequestBody Map<String, Object> payload) {
        List<DayData> daysData = calculateMonthPreview("userId");
        return ResponseEntity.ok(daysData);
    }

    @GetMapping("/days-data-string")
    public String getMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      return String.format("The response is %s!", calculateMonthPreview(userId).toString());    
    }

    // public ResponseEntity<Double> getMonthPreview(@RequestBody Map<String, Object> payload) {
      // TODO: Implement the logic to calculate the month preview

      // Double monthPreview = calculateMonthPreview(payload.get("userId").toString());
      // return ResponseEntity.ok(monthPreview);
    // }  


    // userId is being received. 
    

}
