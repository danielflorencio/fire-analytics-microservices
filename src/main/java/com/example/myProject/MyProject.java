package com.example.myProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProject.data.expensesData;

import java.util.List;

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
}
