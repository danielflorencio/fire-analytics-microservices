package com.example.myProject.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}