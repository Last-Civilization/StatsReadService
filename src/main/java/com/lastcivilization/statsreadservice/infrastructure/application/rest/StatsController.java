package com.lastcivilization.statsreadservice.infrastructure.application.rest;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.port.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stats")
class StatsController {

    private final StatsService statsService;

    @GetMapping("/{id}")
    StatsDto getStatsById(@PathVariable long id){
        return statsService.getStatsById(id);
    }
}
