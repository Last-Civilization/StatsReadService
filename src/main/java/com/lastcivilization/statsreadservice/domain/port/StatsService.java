package com.lastcivilization.statsreadservice.domain.port;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;

public interface StatsService {
    StatsDto getStatsById(long id);
}
