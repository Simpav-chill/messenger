package com.paul.messenger_backend.messaging.dto;

import com.paul.messenger_backend.model.Chat;
import com.paul.messenger_backend.model.User;
import lombok.Data;

public record MessageResponse (
    Long id,
    Long chatId,
    Long senderId,
    Long receiverId,
    String text
) {}