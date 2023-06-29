package com.example.myProject.models;
import java.time.LocalDate;

import com.example.myProject.DTOs.ExpenseRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Expense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String category;
    private String title;
    private double value;

    @ManyToOne
    @JoinColumn(name = "user_id") // Old user_id
    private User user;

    public Expense(ExpenseRequestDTO expenseRequestData) {
        this.date = expenseRequestData.date();
        this.category = expenseRequestData.category();
        this.title = expenseRequestData.title();
        this.value = expenseRequestData.value();
    }

    public Expense(LocalDate date, String category, String title, double value) {
        this.date = date;
        this.category = category;
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense [date=" + date + ", category=" + category + ", title=" + title + ", value=" + value + "]</br>";
    }
}