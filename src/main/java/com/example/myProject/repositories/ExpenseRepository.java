package com.example.myProject.repositories;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.Query;
import com.example.myProject.models.Expense;
// @Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBefore(LocalDate date);

    // @Query("SELECT ex FROM Expense ex WHERE ex.date >= :startDate AND ex.date <= :endDate")
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}