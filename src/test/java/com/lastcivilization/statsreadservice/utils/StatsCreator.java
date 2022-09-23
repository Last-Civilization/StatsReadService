package com.lastcivilization.statsreadservice.utils;

import com.lastcivilization.statsreadservice.domain.Stats;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StatsCreator {

    private final StatsRepository statsRepository;

    Stats createTestStats(){
        Stats stats = buildStats();
        return statsRepository.save(stats);
    }

    private Stats buildStats() {
        return Stats.Builder.aStats()
                .id(1L)
                .build();
    }
}
