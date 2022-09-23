package com.lastcivilization.statsreadservice.infrastructure.database;

import com.lastcivilization.statsreadservice.domain.Stats;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    Stats toDomain(StatsEntity statsEntity);
}
