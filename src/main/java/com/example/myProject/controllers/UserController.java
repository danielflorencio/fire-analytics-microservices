package com.example.myProject.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.exceptions.UserNotFoundException;
import com.example.myProject.infra.security.JwtGeneratorInterface;
import com.example.myProject.models.User;
import com.example.myProject.services.AuthService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private AuthService authService;

    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    public UserController(AuthService authService, JwtGeneratorInterface jwtGenerator){
        this.authService=authService;
        this.jwtGenerator=jwtGenerator;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            authService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getFirstName() == null || user.getPassword() == null) {
                throw new UserNotFoundException("User's email or Password is Empty");
            }

            User userData = authService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        
            if(userData == null){
                throw new UserNotFoundException("User's email or Password is Invalid");
            }

            return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}