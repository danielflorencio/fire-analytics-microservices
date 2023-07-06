package com.example.myProject.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProject.DTOs.AuthenticationDTO;
import com.example.myProject.exceptions.UserNotFoundException;
// import com.example.myProject.infra.security.JwtGeneratorInterface;
import com.example.myProject.models.User;
import com.example.myProject.repositories.UsersRepository;
import com.example.myProject.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationData){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationData.email(), authenticationData.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();        
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        if(this.usersRepository.findByEmail(authenticationDTO.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(authenticationDTO.password());
        System.out.println("AuthenticationDTO Login: ");
        System.out.println(authenticationDTO.email());

        User newUser = new User(authenticationDTO.email(), authenticationDTO.password());
        
        this.usersRepository.save(newUser);

        return ResponseEntity.ok().build();

    }

    // private AuthService authService;

    // private JwtGeneratorInterface jwtGenerator;

    // @Autowired
    // public UserController(AuthService authService, JwtGeneratorInterface jwtGenerator){
        // this.authService=authService;
        // this.jwtGenerator=jwtGenerator;
    // }
    
    // @PostMapping("/register")
    // public ResponseEntity<?> postUser(@RequestBody User user){
    //     try{
    //         authService.saveUser(user);
    //         return new ResponseEntity<>(user, HttpStatus.CREATED);
    //     } catch (Exception e){
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    //     }
    // }

    // @PostMapping("/login")
    // public ResponseEntity<?> loginUser(@RequestBody User user) {
    //     try {
    //         if(user.getFirstName() == null || user.getPassword() == null) {
    //             throw new UserNotFoundException("User's email or Password is Empty");
    //         }

    //         User userData = authService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        
    //         if(userData == null){
    //             throw new UserNotFoundException("User's email or Password is Invalid");
    //         }

    //         return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
    //     } catch (UserNotFoundException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    //     }
    // }
}