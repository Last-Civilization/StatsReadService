package com.lastcivilization.statsreadservice.utils;

import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import com.lastcivilization.statsreadservice.domain.view.LvlModel;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.domain.view.StatsValueModel;
import com.lastcivilization.statsreadservice.domain.view.TimeBonusModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
class StatsCreator {

    private final StatsRepository statsRepository;

    StatsModel createTestStats(){
        StatsModel stats = buildTestStats();
        return statsRepository.save(stats);
    }

    private StatsModel buildTestStats() {
        return new StatsModel(
                1L,
                new LvlModel(
                        null,
                        0,
                        0
                ),
                new StatsValueModel(
                        null,
                        0,
                        new TimeBonusModel(
                                null,
                                LocalDateTime.now(),
                                0
                        ),
                        "DAMAGE"
                ),
                new StatsValueModel(
                        null,
                        0,
                        new TimeBonusModel(
                                null,
                                LocalDateTime.now(),
                                0
                        ),
                        "STRENGTH"
                ),
                new StatsValueModel(
                        null,
                        0,
                        new TimeBonusModel(
                                null,
                                LocalDateTime.now(),
                                0
                        ),
                        "DEXTERITY"
                ),
                new StatsValueModel(
                        null,
                        0,
                        new TimeBonusModel(
                                null,
                                LocalDateTime.now(),
                                0
                        ),
                        "DEFENSE"
                ),
                0
        );
    }
}
