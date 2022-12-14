package com.lastcivilization.statsreadservice.infrastructure.application.rest.dto;

public record StatsValueDto(
        long id,
        int amount,
        TimeBonusDto timeBonus,
        String type,
        int total
) {

    public StatsValueDto(Long id, int amount, TimeBonusDto timeBonus, String type){
        this(id, amount, timeBonus, type, amount + (amount * (timeBonus.amount() / 100)));
    }
}
