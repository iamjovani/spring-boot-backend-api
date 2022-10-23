package com.springboot.springboot.configuration.security;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springboot.springboot.domain.AppUser;

@Component
public class JwtTokenUtil {
    private final String jwtSecret = "7880f1fc-0102-4258-890c-228babfa5461";
    private final String jwtIssuer = "backend.api";

    public String generateAccessToken(AppUser user)
    {
        Algorithm algorithm = Algorithm.HMAC512(jwtSecret.getBytes());

        List<String> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(role.getName());
        });

        return JWT.create()
                .withSubject(String.format("%s,%s", user.getId(), user.getUserName()))
                .withIssuer(jwtIssuer)
                .withClaim("roles", authorities)
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 100))
                .sign(algorithm);
        
    }

    public String generateRefreshToken(AppUser user){
        Algorithm algorithm = Algorithm.HMAC512(jwtSecret.getBytes());

        return JWT.create()
        .withSubject(String.format("%s,%s", user.getId(), user.getUserName()))
        .withIssuer(jwtIssuer)
        .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 100))
        .sign(algorithm);

    }

    public boolean validate(String token){
    try {
        Long expiresAt = JWT.decode(token).getExpiresAt().getTime();
        Calendar cal = Calendar.getInstance();
        if(expiresAt >= cal.getTime().getTime()){
            return true;
        }
    } catch(IllegalArgumentException e){
        System.out.println(String.format("JWT is invalid - {%s}", e.getMessage()));
    }
        return false;
    }

    public String getUserName(String token){
        String subject = JWT.decode(token).getSubject();

        return subject.split(",")[1];
    }
}
