package com.lastcivilization.statsreadservice.infrastructure.application.rest;

import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.domain.view.StatsValueModel;
import com.lastcivilization.statsreadservice.domain.view.TimeBonusModel;
import com.lastcivilization.statsreadservice.infrastructure.application.rest.dto.StatsDto;
import com.lastcivilization.statsreadservice.infrastructure.application.rest.dto.StatsValueDto;
import com.lastcivilization.statsreadservice.infrastructure.application.rest.dto.TimeBonusDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface RestMapper {

    RestMapper MAPPER = Mappers.getMapper(RestMapper.class);

    StatsDto toDto(StatsModel statsModel);

    default StatsValueDto toDto(StatsValueModel statsValueModel){
        return new StatsValueDto(
                statsValueModel.id(),
                statsValueModel.amount(),
                toDto(statsValueModel.timeBonus()),
                statsValueModel.type()
        );
    }

    TimeBonusDto toDto(TimeBonusModel timeBonus);
}
