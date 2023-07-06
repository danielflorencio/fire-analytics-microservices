package com.example.myProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.myProject.exceptions.UserNotFoundException;
import com.example.myProject.models.User;
import com.example.myProject.repositories.UsersRepository;

@Service
// public class AuthService implements UserDetailsService {
public interface AuthService {

    // @Autowired
    // private UsersRepository userRepository;

    public void saveUser(User user);
    public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    //     // It is clearly wrong. Moment 22:30 of the video.
    // }
    
}
