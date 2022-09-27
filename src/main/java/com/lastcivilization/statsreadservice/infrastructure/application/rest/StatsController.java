package com.lastcivilization.statsreadservice.infrastructure.application.rest;

import com.lastcivilization.statsreadservice.domain.StatsService;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.infrastructure.application.rest.dto.StatsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

import static com.lastcivilization.statsreadservice.infrastructure.application.rest.RestMapper.MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stats")
@Validated
class StatsController {

    private final StatsService statsService;

    @GetMapping("/{id}")
    StatsDto getStatsById(@PathVariable @Min(1) long id){
        StatsModel statsModel = statsService.getStatsById(id);
        return MAPPER.toDto(statsModel);
    }
}
