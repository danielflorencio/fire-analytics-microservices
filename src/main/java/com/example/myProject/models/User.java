package com.example.myProject.models;

public class User {
    
    private String firstName;
    private String lastName;
    private Double totalBalance;
    private Expense[] expenses;

    public User(String firstName, String lastName, Double totalBalance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalBalance = totalBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Expense[] getExpenses() {
        return expenses;
    }

    public void setExpenses(Expense[] expenses) {
        this.expenses = expenses;
    }
}
