package com.example.myProject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import com.example.myProject.models.GraphicalPreview;
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

    public GraphicalPreview getOneMonthGraphicalPreview(LocalDate startDate, LocalDate endDate) {

        List<ExpenseResponseDTO> lastMonthExpenses = expenseRepository.findByDateBetween(startDate, endDate).stream().map(ExpenseResponseDTO::new).toList();
        List<DayData> lastMonthIntraDayData = financialCalculator.getIntraDaysData(lastMonthExpenses);
        GraphicalPreview graphicalPreview = new GraphicalPreview(lastMonthIntraDayData);
        return graphicalPreview;
    }
}