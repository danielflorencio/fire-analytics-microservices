package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myProject.models.Food;

public interface FoodRepository extends JpaRepository<Food, Long> { // Long is the type of the entity's primary key or unique identifier.
    
}
