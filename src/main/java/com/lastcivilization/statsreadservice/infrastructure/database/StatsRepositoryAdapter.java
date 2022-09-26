package com.lastcivilization.statsreadservice.infrastructure.database;

import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.lastcivilization.statsreadservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class StatsRepositoryAdapter implements StatsRepository {

    private final StatsJpaRepository statsJpaRepository;

    @Override
    public Optional<StatsModel> findById(long id) {
        Optional<StatsEntity> statsEntity = statsJpaRepository.findById(id);
        return statsEntity
                .map(MAPPER::toDomain);
    }

    @Override
    public StatsModel save(StatsModel stats) {
        StatsEntity statsEntity = MAPPER.toEntity(stats);
        StatsEntity savedStatsEntity = statsJpaRepository.save(statsEntity);
        return MAPPER.toDomain(savedStatsEntity);
    }

}
