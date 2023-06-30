package com.example.myProject.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayData {
    public LocalDate date;
    public double incomes;
    public double expenses;
    public double totalBalance;

    public DayData(LocalDate date){
        this.date = date;
        this.incomes = 0;
        this.expenses = 0;
        this.totalBalance = this.incomes - this.expenses;
    }

    @Override
    public String toString() {
    return "DayData{" +
            "Date=" + this.date +
            ", day incomes='" + this.incomes + '\'' +
            ", day expenses='" + this.expenses + '\'' +
            ", day totalBalance='" + this.totalBalance + '\'' +
            '}';   
    }

    public void addExpenseValue(double expenseValue){
        this.expenses += expenseValue;
    }
    public void addIncomeValue(double incomeValue){
        this.incomes += incomeValue;
    }
}
