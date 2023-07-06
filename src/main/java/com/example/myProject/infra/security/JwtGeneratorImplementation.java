// package com.example.myProject.infra.security;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import com.example.myProject.models.User;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import io.jsonwebtoken.Jwts;

// @Service
// public class JwtGeneratorImplementation implements JwtGeneratorInterface{
// //   @Value("${jwt.secret}")
    
//     @Value("secret")
//     private String secret;
    
    
//     // @Value("${app.jwttoken.message}")
//     @Value("jwtTokenMessage")
//     private String message;
    
//     @Override
//     public Map<String, String> generateToken(User user) {
//         String jwtToken="";
//         jwtToken = Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
//         Map<String, String> jwtTokenGen = new HashMap<>();
//         jwtTokenGen.put("token", jwtToken);
//         jwtTokenGen.put("message", message);
//         return jwtTokenGen;
//     }
// }