package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.exception.StatsNotFoundException;
import com.lastcivilization.statsreadservice.domain.port.StastRepository;
import com.lastcivilization.statsreadservice.domain.port.StatsService;

import static com.lastcivilization.statsreadservice.domain.Mapper.toDto;

class StatsServiceImp implements StatsService {

    private final StastRepository stastRepository;

    StatsServiceImp(StastRepository stastRepository) {
        this.stastRepository = stastRepository;
    }

    @Override
    public StatsDto getStatsById(long id) {
        Stats stats = getStats(id);
        return toDto(stats);
    }

    private Stats getStats(long id) {
        return stastRepository.findById(id)
                .orElseThrow(() -> new StatsNotFoundException(id));
    }
}
