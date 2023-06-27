package com.example.myProject.models;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Override
    public String toString() {
    return "DayData{" +
            "Date=" + this.date +
            ", day incomes='" + this.incomes + '\'' +
            ", day expenses='" + this.expenses + '\'' +
            ", day totalBalance='" + this.totalBalance + '\'' +
            '}';   
    }
}
