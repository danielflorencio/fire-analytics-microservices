package com.example.myProject.util;
import com.example.myProject.DTOs.ExpenseResponseDTO;
import com.example.myProject.models.DayData;
import com.example.myProject.models.Expense;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.List;

public class FinancialCalculator {
    
    public List<LocalDate> getSortedDates(List<ExpenseResponseDTO> expenses) {
        List<LocalDate> dates = new ArrayList<>();
        for (ExpenseResponseDTO expense : expenses) {
            if(dates.contains(expense.date()) == false){
                dates.add(expense.date());
            }
        }
        Collections.sort(dates);
        return dates;
    }

    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            dates.add(date);
            date = date.plusDays(1);
        }
        
        return dates;
    }

    public List<DayData> getDaysData(List<Expense> expenses) {
        // List<LocalDate> sortedDates = new ArrayList<>(getSortedDates(expenses));
        List<DayData> daysData = new ArrayList<>();

        // for (int i = 0; i < sortedDates.size(); i++) {
            // DayData newDay = new DayData(sortedDates.get(i));
            // daysData.add(newDay);
        // }

        for (int i = 0; i < daysData.size(); i++) {
            for (int n = 0; n < expenses.size(); n++) {
                if (daysData.get(i).equals(expenses.get(n).getDate())) {
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


    public List<DayData> getIntraDaysData(List<ExpenseResponseDTO> expenses) {

        List<LocalDate> sortedDates = getSortedDates(expenses);

        List<LocalDate> actualDatesToUse = getDatesBetween(sortedDates.get(0), sortedDates.get(sortedDates.size() - 1));

        List<DayData> daysData = new ArrayList();

        for(int i = 0; i < actualDatesToUse.size(); i ++){
            DayData newDayData = new DayData(actualDatesToUse.get(i));
            daysData.add(newDayData);
        }

        for (int i = 0; i < daysData.size(); i++) {
            for (int n = 0; n < expenses.size(); n++) {
                if (daysData.get(i).getDate().equals(expenses.get(n).date())) {
                    if (expenses.get(n).category().equalsIgnoreCase("salary")) {
                        daysData.get(i).addIncomeValue(expenses.get(n).value());
                    } else {
                        daysData.get(i).addExpenseValue(expenses.get(n).value());
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
    //   List<DayData> daysData = getDaysData(expenses);
      Double monthPreview = calculateTimePreview(expenses, 30);
      return monthPreview;
    }

    public Double calculateSixMonthsPreview(List<Expense> expenses){      
    //   List<DayData> daysData = getDaysData(expenses);
      Double sixMonthsPreview = calculateTimePreview(expenses, 182);
      return sixMonthsPreview;
    }

    public Double calculateYearPreview(List<Expense> expenses){ 
    //   List<DayData> daysData = getDaysData(expenses);
      Double yearPreview = calculateTimePreview(expenses, 365);
      return yearPreview;
    }
}
