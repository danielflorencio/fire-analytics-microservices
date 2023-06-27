package com.example.myProject.models;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
        return "Expense [date=" + date + ", category=" + category + ", title=" + title + ", value=" + value + "]</br>";
    }
}
