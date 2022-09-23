package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.exception.StatsNotFoundException;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import com.lastcivilization.statsreadservice.domain.port.StatsService;

import static com.lastcivilization.statsreadservice.domain.Mapper.toDto;

public class StatsServiceImp implements StatsService {

    private final StatsRepository statsRepository;

    public StatsServiceImp(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @Override
    public StatsDto getStatsById(long id) {
        Stats stats = getStats(id);
        return toDto(stats);
    }

    private Stats getStats(long id) {
        return statsRepository.findById(id)
                .orElseThrow(() -> new StatsNotFoundException(id));
    }
}
