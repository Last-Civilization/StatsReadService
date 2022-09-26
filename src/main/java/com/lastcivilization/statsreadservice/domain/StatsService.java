package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.exception.StatsNotFoundException;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;

import static com.lastcivilization.statsreadservice.domain.Mapper.toDomain;
import static com.lastcivilization.statsreadservice.domain.Mapper.toModel;

public class StatsService {

    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public StatsModel getStatsById(long id) {
        StatsModel statsModel = getStats(id);
        Stats stats = toDomain(statsModel);
        return toModel(stats);
    }

    private StatsModel getStats(long id) {
        return statsRepository.findById(id)
                .orElseThrow(() -> new StatsNotFoundException(id));
    }
}
