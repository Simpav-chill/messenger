package com.paul.messenger_backend.messaging.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MessageRequest (
    @NotNull
    Long senderId,

    @NotNull
    Long receiverId,

    @NotBlank
    @Size(max = 4096)
    String text
) {}