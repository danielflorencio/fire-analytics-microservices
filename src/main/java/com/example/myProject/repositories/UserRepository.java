package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.myProject.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    // UserDetails findByEmail(String email); // Why does it return a UserDetails and not a User?
    // public UserDetails findByEmailAndPassword(String email, String password);
    UserDetails findByLogin(String login);
}
