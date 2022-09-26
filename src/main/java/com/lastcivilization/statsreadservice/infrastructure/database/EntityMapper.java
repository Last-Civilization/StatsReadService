package com.lastcivilization.statsreadservice.infrastructure.database;

import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    StatsModel toDomain(StatsEntity statsEntity);
    StatsEntity toEntity(StatsModel stats);
}
