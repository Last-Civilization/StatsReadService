package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.dto.LvlDto;
import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.dto.StatsValueDto;
import com.lastcivilization.statsreadservice.domain.dto.TimeBonusDto;

class Mapper {

    static StatsDto toDto(Stats stats){
        return new StatsDto(
                stats.getId(),
                toDto(stats.getLvl()),
                toDto(stats.getDamage()),
                toDto(stats.getStrength()),
                toDto(stats.getDexterity()),
                toDto(stats.getDefense()),
                stats.getHealth()
        );
    }

    private static StatsValueDto toDto(StatsValue statsValue) {
        Type type = statsValue.getType();
        return new StatsValueDto(
                statsValue.getId(),
                statsValue.getAmount(),
                toDto(statsValue.getTimeBonus()),
                type.toString()
        );
    }

    private static TimeBonusDto toDto(TimeBonus timeBonus) {
        return new TimeBonusDto(
                timeBonus.getId(),
                timeBonus.getEndDate(),
                timeBonus.getAmount()
        );
    }

    private static LvlDto toDto(Lvl lvl) {
        return new LvlDto(
                lvl.getId(),
                lvl.getCurrent(),
                lvl.getExperience()
        );
    }
}
