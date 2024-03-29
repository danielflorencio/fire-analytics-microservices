package com.example.myProject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import com.example.myProject.models.GraphicalPreview;
import com.example.myProject.repositories.ExpenseRepository;
import com.example.myProject.util.FinancialCalculator;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import com.example.myProject.data.expensesData;
import com.example.myProject.exceptions.NoDataFoundException;

@Service
public class ExpenseService {
    
    @Autowired
    private final ExpenseRepository expenseRepository;

    FinancialCalculator financialCalculator = new FinancialCalculator();

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate){

        List<Expense> expenses = expenseRepository.findByDateBetween(startDate, endDate);
        
        if(expenses.isEmpty()){
            throw new NoDataFoundException();
        }
        
        return expenses;
    }

    @PostConstruct
    public void saveExpensesOnStartup() {
        for (Expense expense : expensesData.expenses) {
            expenseRepository.save(expense);
        }
    }

    // public GraphicalPreview getOneMonthGraphicalPreview(LocalDate startDate, LocalDate endDate) {

    //     /*
    //      * Pretty Straight forward.
    //      * The first line gets the all the expenses from the last month.
    //      * The second lines call the financial calculator to organize the data from these thirty days.
    //      * The third lines creates a new GraphicalPreview object that will handle this calculation in the class's constructor.
    //      */

    //     List<ExpenseResponseDTO> lastMonthExpenses = expenseRepository.findByDateBetween(startDate, endDate).stream().map(ExpenseResponseDTO::new).toList();
    //     List<DayData> lastMonthIntraDayData = financialCalculator.getIntraDaysData(lastMonthExpenses);
    //     GraphicalPreview graphicalPreview = new GraphicalPreview(lastMonthIntraDayData);

    //     return graphicalPreview;
    // }

    public GraphicalPreview getGraphicalPreview(LocalDate startDate, LocalDate endDate){
        List<ExpenseResponseDTO> pastExpenses = expenseRepository.findByDateBetween(startDate, endDate).stream().map(ExpenseResponseDTO::new).toList();

        if(pastExpenses.isEmpty()){
            throw new NoDataFoundException();
        }
        
        // I have to create an error handler for when the app doesn't find any expenses.
        
        System.out.println("PAST EXPENSES SIZE: ");
        System.out.println(pastExpenses.size());
        List<DayData> pastIntraDaysData = financialCalculator.getIntraDaysData(pastExpenses);
 
        GraphicalPreview graphicalPreview = new GraphicalPreview(pastIntraDaysData);
        return graphicalPreview;
    }

    public GraphicalPreview getSixMonthsGraphicalPreview(LocalDate startDate, LocalDate endDate){
        GraphicalPreview graphicalPreview = new GraphicalPreview();
        return graphicalPreview;
    }

}