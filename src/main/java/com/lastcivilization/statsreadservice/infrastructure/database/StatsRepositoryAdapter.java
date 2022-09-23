package com.lastcivilization.statsreadservice.infrastructure.database;

import com.lastcivilization.statsreadservice.domain.Stats;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.lastcivilization.statsreadservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class StatsRepositoryAdapter implements StatsRepository {

    private final StatsJpaRepository statsJpaRepository;

    @Override
    public Optional<Stats> findById(long id) {
        Optional<StatsEntity> statsEntity = statsJpaRepository.findById(id);
        return statsEntity
                .map(MAPPER::toDomain);
    }

    @Override
    public Stats save(Stats stats) {
        StatsEntity statsEntity = MAPPER.toEntity(stats);
        StatsEntity savedStatsEntity = statsJpaRepository.save(statsEntity);
        return MAPPER.toDomain(savedStatsEntity);
    }

}
