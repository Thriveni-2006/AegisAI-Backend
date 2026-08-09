package com.aegisai.service;

import com.aegisai.dto.LoginRequest;
import com.aegisai.dto.LoginResponse;
import com.aegisai.dto.RegisterRequest;
import com.aegisai.entity.User;
import com.aegisai.repository.UserRepository;
import com.aegisai.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {

        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return "Email already exists!";
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());

        String encodedPassword =
                passwordEncoder.encode(request.getPassword());

        user.setPassword(encodedPassword);

        if (request.getRole() == null ||
                request.getRole().isBlank()) {

            user.setRole("USER");
        } else {
            user.setRole(request.getRole());
        }

        userRepository.save(user);

        return "User Registered Successfully!";
    }

    public LoginResponse login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return new LoginResponse(
                    "Invalid Email or Password",
                    null
            );
        }

        User user = optionalUser.get();

        boolean matched =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!matched) {
            return new LoginResponse(
                    "Invalid Email or Password",
                    null
            );
        }

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(
                "Login Successful",
                token
        );
    }
}