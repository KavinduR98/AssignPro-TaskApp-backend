package com.ushan.authService.service;

import com.ushan.authService.dto.LoginRequestDTO;
import com.ushan.authService.entity.User;
import com.ushan.authService.exception.InvalidCredentialsException;
import com.ushan.authService.repository.UserRepository;
import com.ushan.authService.security.JwtUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public String login(LoginRequestDTO request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return jwtUtil.generateToken(request.getUsername());
    }

    @PostConstruct
    public void seedAdminUser() {
        System.out.println("PasswordEncoder: " + encoder);
        System.out.println("JWT Util: " + jwtUtil);

        if (repo.findByUsername("admin").isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(encoder.encode("password"));
            repo.save(user);
        }
    }
}
