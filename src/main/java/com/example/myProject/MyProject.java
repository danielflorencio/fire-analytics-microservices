package com.example.myProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.data.expensesData;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    public List<Date> getSortedDates(List<Expense> expenses) {
      List<Date> dates = new ArrayList<>();  
      for (Expense expense : expenses) {
          dates.add(expense.getDate());
      }  
      Collections.sort(dates);
      return dates;
    }

    public Double calculateMonthPreview(String userId){      
      List<Date> sortedDates = new ArrayList<>(getSortedDates(expensesData.expenses));
      // System.out.println("Sorted Dates: " + sortedDates);
      // Get the data from the database. In this case, we're gonna get it from another java file.  
      List<DayData> daysData = new ArrayList<>();
      for(int i = 0; i < sortedDates.size(); i++){
        DayData newDay = new DayData(sortedDates.get(i));
        daysData.add(newDay);
      }
      // System.out.println("daysData post first FOR: " + daysData);
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
      // System.out.println("daysData post second: " + daysData);
      
      
      Double monthPreview = 0.0;
      Double averageDailyGain = daysData.get(0).getIncomes();
      Double averageDailyLoss = daysData.get(0).getExpenses();
      for(int i = 1; i < daysData.size(); i++){
        averageDailyGain = (averageDailyGain + daysData.get(i).getIncomes())/2;
        averageDailyLoss = (averageDailyLoss + daysData.get(i).getExpenses())/2;
      }
      for(int i = 0; i < 30; i ++){
        monthPreview = monthPreview + (averageDailyGain - averageDailyLoss);
      }
      return monthPreview;
    }



    // https://www.youtube.com/watch?v=X2hjlquVess how to fix the cors shit
    // @RequestMapping(value = "/getUserMonthPreview", method = RequestMethod.POST)
    // @RequestMapping("/getUserMonthPreview")
    
    @GetMapping("/getUserMonthPreview")
    @CrossOrigin(origins = "http://localhost:5173/") 
    // @ResponseBody
    public ResponseEntity<Double> getMonthPreview(@RequestParam(value = "userId", defaultValue = "0") String userId) {
      Double monthPreview = calculateMonthPreview(userId);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Status", "ok");
      // headers.add("Access-Control-Allow-Origin", "*");
      return ResponseEntity.ok().headers(headers).body(monthPreview);    
    }
}
