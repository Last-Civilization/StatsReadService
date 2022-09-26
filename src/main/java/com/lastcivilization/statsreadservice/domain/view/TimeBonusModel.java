package com.lastcivilization.statsreadservice.domain.view;

import java.time.LocalDateTime;

public record TimeBonusModel(
        Long id,
        LocalDateTime endDate,
        int amount
) { }
