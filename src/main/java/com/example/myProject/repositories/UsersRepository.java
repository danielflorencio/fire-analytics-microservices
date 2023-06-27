package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myProject.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    
}
