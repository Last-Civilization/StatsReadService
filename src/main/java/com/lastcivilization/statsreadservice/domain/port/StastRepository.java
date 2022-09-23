package com.lastcivilization.statsreadservice.domain.port;

import com.lastcivilization.statsreadservice.domain.Stats;

import java.util.Optional;

public interface StastRepository {

    Optional<Stats> findById(long id);
}
