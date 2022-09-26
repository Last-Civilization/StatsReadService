package com.lastcivilization.statsreadservice.infrastructure.application.rest.dto;

public record LvlDto(
        Long id,
        int current,
        int experience
) {}
