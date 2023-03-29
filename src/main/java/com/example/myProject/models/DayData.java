package com.example.myProject.models;

import com.example.myProject.data.expensesData;

import java.util.Date;


public class DayData {
    public Date date;
    public double incomes;
    public double expenses;
    public double totalBalance;


    
    public DayData(Date date){
        this.date = date;
        this.incomes = 0;
        this.expenses = 0;
        this.totalBalance = this.incomes - this.expenses;
    }


    public Date getDate(){
        return this.date;
    }
    public double getIncomes(){
        return this.incomes;
    }
    public double getExpenses(){
        return this.expenses;
    }
    public double getTotalBalance(){
        return this.totalBalance;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public void setIncomes(double income){
        this.incomes = income;
    }
    public void setExpenses(double expense){
        this.expenses = expense;
    }

    public void addExpenseValue(double expenseValue){
        this.expenses += expenseValue;
    }
    public void addIncomeValue(double incomeValue){
        this.incomes += incomeValue;
    }
}
