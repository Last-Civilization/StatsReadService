package com.lastcivilization.statsreadservice.domain.port;

import com.lastcivilization.statsreadservice.domain.view.StatsModel;

import java.util.Optional;

public interface StatsRepository {

    Optional<StatsModel> findById(long id);

    StatsModel save(StatsModel stats);
}
