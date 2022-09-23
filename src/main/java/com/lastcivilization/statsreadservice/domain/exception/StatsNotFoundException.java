package com.lastcivilization.statsreadservice.domain.exception;

public class StatsNotFoundException extends RuntimeException {

    public StatsNotFoundException(long id) {
        super("Can not found stats with id: %d".formatted(id));
    }
}
