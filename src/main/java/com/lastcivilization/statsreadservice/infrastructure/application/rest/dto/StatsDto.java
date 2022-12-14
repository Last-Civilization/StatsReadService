package com.lastcivilization.statsreadservice.infrastructure.application.rest.dto;

public record StatsDto(
        long id,
        LvlDto lvl,
        StatsValueDto damage,
        StatsValueDto strength,
        StatsValueDto dexterity,
        StatsValueDto defense,
        int health
) {}
