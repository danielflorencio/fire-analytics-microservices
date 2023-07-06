package com.example.myProject.infra.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Dictates that this is a spring security configuration class.
@EnableWebSecurity // Habilitates this class's configurations.
public class SecurityConfigurations {
    
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        // return httpSecurity
        // .csrf()
    // }

}
