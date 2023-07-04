package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myProject.models.Food;
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> { // Long is the type of the entity's primary key or unique identifier.
    
}