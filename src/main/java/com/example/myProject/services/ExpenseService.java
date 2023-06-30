package com.example.myProject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import com.example.myProject.repositories.ExpenseRepository;
import com.example.myProject.util.FinancialCalculator;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    FinancialCalculator financialCalculator = new FinancialCalculator();

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate){
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    public List<DayData> getOneMonthGraphicalPreview(LocalDate startDate, LocalDate endDate) {

        List<ExpenseResponseDTO> lastMonthExpenses = expenseRepository.findByDateBetween(startDate, endDate).stream().map(ExpenseResponseDTO::new).toList();

        List<DayData> lastMonthIntraDayData = financialCalculator.getIntraDaysData(lastMonthExpenses);
        System.out.println("Last Month Intra Day Data: ");
        System.out.println(lastMonthIntraDayData);
        return lastMonthIntraDayData;
    }
}