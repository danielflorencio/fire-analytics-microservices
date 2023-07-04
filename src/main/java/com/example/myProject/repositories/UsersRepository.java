package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myProject.models.User;
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    
}
