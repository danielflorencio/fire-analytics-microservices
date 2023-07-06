package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.myProject.models.User;

public interface UsersRepository extends JpaRepository<User, String> {
    UserDetails findByEmail(String email); // Why does it return a UserDetails and not a User?
    public UserDetails findByEmailAndPassword(String email, String password);
}
