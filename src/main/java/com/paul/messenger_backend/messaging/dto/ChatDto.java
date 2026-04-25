package com.paul.messenger_backend.messaging.dto;


public record ChatDto (
    Long id,
    Long user1Id,
    Long user2Id
) {}