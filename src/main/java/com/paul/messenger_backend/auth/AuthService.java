package com.paul.messenger_backend.auth;

import com.paul.messenger_backend.auth.dto.AuthResponse;
import com.paul.messenger_backend.auth.dto.LoginRequest;
import com.paul.messenger_backend.auth.dto.RegisterRequest;
import com.paul.messenger_backend.model.Status;
import com.paul.messenger_backend.model.User;
import com.paul.messenger_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .userStatus(Status.OFFLINE)
                .build();

        User savedUser = userRepository.save(user);

        return new AuthResponse(
                "fake-jwt-token-for-now",
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        return new AuthResponse(
                "fake-jwt-token-for-now",
                user.getUsername(),
                user.getEmail()
        );
    }
}
