package com.example.myProject.infra.security;
import java.util.Map;
import com.example.myProject.models.User;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}