package com.example.myProject.models;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Setter
@Getter
public class Expense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String category;
    private String title;
    private double value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense(Date date, String category, String title, double value) {
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
