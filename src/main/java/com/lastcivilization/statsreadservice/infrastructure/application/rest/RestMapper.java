package com.lastcivilization.statsreadservice.infrastructure.application.rest;

import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.infrastructure.application.rest.dto.StatsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface RestMapper {

    RestMapper MAPPER = Mappers.getMapper(RestMapper.class);

    StatsDto toDto(StatsModel statsModel);
}
