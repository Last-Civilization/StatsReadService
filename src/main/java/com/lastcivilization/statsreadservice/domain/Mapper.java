package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.view.LvlModel;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.domain.view.StatsValueModel;
import com.lastcivilization.statsreadservice.domain.view.TimeBonusModel;

class Mapper {

    static Stats toDomain(StatsModel statsModel){
        return Stats.Builder.aStats()
                .id(statsModel.id())
                .lvl(toDomain(statsModel.lvl()))
                .damage(toDomain(statsModel.damage()))
                .strength(toDomain(statsModel.strength()))
                .dexterity(toDomain(statsModel.dexterity()))
                .defense(toDomain(statsModel.defense()))
                .health(statsModel.health())
                .build();
    }

    private static StatsValue toDomain(StatsValueModel statsValue) {
        return StatsValue.Builder.aStatsValue()
                .id(statsValue.id())
                .amount(statsValue.amount())
                .timeBonus(toDomain(statsValue.timeBonus()))
                .type(Type.valueOf(statsValue.type()))
                .build();
    }

    private static TimeBonus toDomain(TimeBonusModel timeBonus) {
        return TimeBonus.Builder.aTimeBonus()
                .id(timeBonus.id())
                .endDate(timeBonus.endDate())
                .amount(timeBonus.amount())
                .build();
    }

    private static Lvl toDomain(LvlModel lvl) {
        return Lvl.Builder.aLvl()
                .id(lvl.id())
                .current(lvl.current())
                .experience(lvl.experience())
                .build();
    }

    static StatsModel toModel(Stats stats){
        return new StatsModel(
                stats.getId(),
                toModel(stats.getLvl()),
                toModel(stats.getDamage()),
                toModel(stats.getStrength()),
                toModel(stats.getDexterity()),
                toModel(stats.getDefense()),
                stats.getHealth()
        );
    }

    private static StatsValueModel toModel(StatsValue statsValue) {
        Type type = statsValue.getType();
        return new StatsValueModel(
                statsValue.getId(),
                statsValue.getAmount(),
                toModel(statsValue.getTimeBonus()),
                type.toString()
        );
    }

    private static TimeBonusModel toModel(TimeBonus timeBonus) {
        return new TimeBonusModel(
                timeBonus.getId(),
                timeBonus.getEndDate(),
                timeBonus.getAmount()
        );
    }

    private static LvlModel toModel(Lvl lvl) {
        return new LvlModel(
                lvl.getId(),
                lvl.getCurrent(),
                lvl.getExperience()
        );
    }
}
