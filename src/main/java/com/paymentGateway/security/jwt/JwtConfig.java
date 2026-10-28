package com.paymentGateway.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
