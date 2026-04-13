package com.paul.messenger_backend.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Username or email is required")
    private String usernameOrEmail;

    @NotBlank(message = "Username or email is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
}
