package com.example.myProject.util;
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

    public List<DayData> getDaysData(List<Expense> expenses) {
        List<Date> sortedDates = new ArrayList<>(getSortedDates(expenses));
        List<DayData> daysData = new ArrayList<>();
        for (int i = 0; i < sortedDates.size(); i++) {
            DayData newDay = new DayData(sortedDates.get(i));
            daysData.add(newDay);
        }
        for (int i = 0; i < sortedDates.size(); i++) {
            for (int n = 0; n < expenses.size(); n++) {
                if (sortedDates.get(i).equals(expenses.get(n).getDate())) {
                    if (expenses.get(n).getCategory().equalsIgnoreCase("salary")) {
                        daysData.get(i).addIncomeValue(expenses.get(n).getValue());
                    } else {
                        daysData.get(i).addExpenseValue(expenses.get(n).getValue());
                    }
                }
            }
        }
        return daysData;
    }

    public Double calculateTimePreview(List<Expense> expenses, int amountOfDays) {
        List<DayData> daysData = getDaysData(expenses);
        Double preview = 0.0;
        Double averageDailyGain = daysData.get(0).getIncomes();
        Double averageDailyLoss = daysData.get(0).getExpenses();
        for (int i = 1; i < daysData.size(); i++) {
            averageDailyGain = (averageDailyGain + daysData.get(i).getIncomes()) / 2;
            averageDailyLoss = (averageDailyLoss + daysData.get(i).getExpenses()) / 2;
        }
        for (int i = 0; i < amountOfDays; i++) {
            preview = preview + (averageDailyGain - averageDailyLoss);
        }
        return preview;
    }

    public Double calculateMonthPreview(List<Expense> expenses){      
      List<DayData> daysData = getDaysData(expenses);
      Double monthPreview = calculateTimePreview(expenses, 30);
      return monthPreview;
    }

    public Double calculateSixMonthsPreview(List<Expense> expenses){      
      List<DayData> daysData = getDaysData(expenses);
      Double sixMonthsPreview = calculateTimePreview(expenses, 182);
      return sixMonthsPreview;
    }

    public Double calculateYearPreview(List<Expense> expenses){ 
      List<DayData> daysData = getDaysData(expenses);
      Double yearPreview = calculateTimePreview(expenses, 365);
      return yearPreview;
    }
}
