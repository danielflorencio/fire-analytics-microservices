package com.example.myProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyProject {
    
  public static void main(String[] args) {
    SpringApplication.run(MyProject.class, args);
  }
    
}