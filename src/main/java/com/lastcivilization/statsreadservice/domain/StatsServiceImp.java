package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.port.StastRepository;
import com.lastcivilization.statsreadservice.domain.port.StatsService;

class StatsServiceImp implements StatsService {

    private final StastRepository stastRepository;

    StatsServiceImp(StastRepository stastRepository) {
        this.stastRepository = stastRepository;
    }

    @Override
    public StatsDto getStatsById(long id) {
        return null;
    }
}
