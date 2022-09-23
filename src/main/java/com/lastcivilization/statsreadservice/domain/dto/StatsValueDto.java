package com.lastcivilization.statsreadservice.domain.dto;

public record StatsValueDto(
        Long id,
        int amount,
        TimeBonusDto timeBonus,
        String type,
        int total
) {

    public StatsValueDto(Long id, int amount, TimeBonusDto timeBonus, String type){
        this(id, amount, timeBonus, type, amount + (amount * (timeBonus.amount() / 100)));
    }
}
