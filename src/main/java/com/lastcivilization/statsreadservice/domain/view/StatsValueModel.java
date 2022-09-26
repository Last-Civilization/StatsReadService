package com.lastcivilization.statsreadservice.domain.view;

public record StatsValueModel(
        Long id,
        int amount,
        TimeBonusModel timeBonus,
        String type
) {
}
