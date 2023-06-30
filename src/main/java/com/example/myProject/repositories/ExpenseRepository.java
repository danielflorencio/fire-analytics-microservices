package com.example.myProject.repositories;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myProject.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBefore(LocalDate date);
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}