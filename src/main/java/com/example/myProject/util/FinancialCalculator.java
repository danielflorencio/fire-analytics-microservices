package com.example.myProject.util;

// import com.example.myProject.data.ExpensesData;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FinancialCalculator {
    
    public List<Date> getSortedDates(List<Expense> expenses) {
        List<Date> dates = new ArrayList<>();
        for (Expense expense : expenses) {
            dates.add(expense.getDate());
        }
        Collections.sort(dates);
        return dates;
    }

    // public List<DayData> getDaysData() {
    //     List<Date> sortedDates = new ArrayList<>(getSortedDates(ExpensesData.expenses));
    //     List<DayData> daysData = new ArrayList<>();
    //     for (int i = 0; i < sortedDates.size(); i++) {
    //         DayData newDay = new DayData(sortedDates.get(i));
    //         daysData.add(newDay);
    //     }
    //     for (int i = 0; i < sortedDates.size(); i++) {
    //         for (int n = 0; n < ExpensesData.expenses.size(); n++) {
    //             if (sortedDates.get(i).equals(ExpensesData.expenses.get(n).getDate())) {
    //                 if (ExpensesData.expenses.get(n).getCategory().equalsIgnoreCase("salary")) {
    //                     daysData.get(i).addIncomeValue(ExpensesData.expenses.get(n).getValue());
    //                 } else {
    //                     daysData.get(i).addExpenseValue(ExpensesData.expenses.get(n).getValue());
    //                 }
    //             }
    //         }
    //     }
    //     return daysData;
    // }

    // public Double calculateTimePreview(int amountOfDays) {
    //     List<DayData> daysData = getDaysData();
    //     Double preview = 0.0;
    //     Double averageDailyGain = daysData.get(0).getIncomes();
    //     Double averageDailyLoss = daysData.get(0).getExpenses();
    //     for (int i = 1; i < daysData.size(); i++) {
    //         averageDailyGain = (averageDailyGain + daysData.get(i).getIncomes()) / 2;
    //         averageDailyLoss = (averageDailyLoss + daysData.get(i).getExpenses()) / 2;
    //     }
    //     for (int i = 0; i < amountOfDays; i++) {
    //         preview = preview + (averageDailyGain - averageDailyLoss);
    //     }
    //     return preview;
    // }
}
