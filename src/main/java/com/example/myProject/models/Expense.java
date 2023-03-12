package com.example.myProject.models;
import java.util.Date;
public class Expense {
    public Date date;
    public String category;
    public String title;
    public double value;

    public Expense(Date date, String category, String title, double value) {
        this.date = date;
        this.category = category;
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense [date=" + date + ", category=" + category + ", title=" + title + ", value=" + value + "]";
    }

    public Date getDate() {
        return this.date;
    }
    public String getCategory() {
        return this.category;
    }
    public String getTitle() {
        return this.title;
    }    
    public double getValue() {
        return this.value;
    }
    
    // Setters
    public void setDate(Date date) {
        this.date = date;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
