package com.example.myProject.infra.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myProject.services.AuthService;
import com.example.myProject.exceptions.UserNotFoundException;
import com.example.myProject.models.User;
import com.example.myProject.repositories.UsersRepository;
@Service
public class UserServiceImplementation implements AuthService {
  
    private UsersRepository userRepository;

    @Autowired
    public UserServiceImplementation(UsersRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(email, password);
        
        if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        
        return user;
    }
}