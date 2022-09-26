package com.lastcivilization.statsreadservice.infrastructure.application.config;

import com.lastcivilization.statsreadservice.domain.StatsService;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.lastcivilization.statsreadservice.infrastructure.database")
@EnableJpaRepositories("com.lastcivilization.statsreadservice.infrastructure.database")
@ComponentScan("com.lastcivilization.statsreadservice")
class BeanConfiguration {

    @Bean
    StatsService statsService(StatsRepository statsRepository){
        return new StatsService(statsRepository);
    }
}
