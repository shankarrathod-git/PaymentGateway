package com.paymentGateway.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LginRequestDTO request){

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());

        if(passwordEncoder.matches(request.getPassword(), user.getPassword())){

            return  jwtUtil.generateToken(request.getUsername());
        }
        throw new RuntimeException("Invalid Credentials");
    }
}
