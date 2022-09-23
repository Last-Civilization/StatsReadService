package com.lastcivilization.statsreadservice.infrastructure.application.rest.exception;

import java.time.LocalDateTime;

record ErrorEntity(
        String message,
        LocalDateTime thrownAt
){
    ErrorEntity(String message){
        this(message, LocalDateTime.now());
    }
}
