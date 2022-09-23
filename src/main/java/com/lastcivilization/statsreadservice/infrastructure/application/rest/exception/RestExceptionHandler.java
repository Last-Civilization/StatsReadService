package com.lastcivilization.statsreadservice.infrastructure.application.rest.exception;

import com.lastcivilization.statsreadservice.domain.exception.StatsNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(StatsNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    ErrorEntity handleStatsNotFoundException(StatsNotFoundException exception){
        return new ErrorEntity(exception.getMessage());
    }
}
