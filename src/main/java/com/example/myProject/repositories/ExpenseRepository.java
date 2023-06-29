package com.example.myProject.repositories;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myProject.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBefore(Date date);
}