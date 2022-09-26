package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.exception.StatsNotFoundException;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import com.lastcivilization.statsreadservice.domain.view.LvlModel;
import com.lastcivilization.statsreadservice.domain.view.StatsModel;
import com.lastcivilization.statsreadservice.domain.view.StatsValueModel;
import com.lastcivilization.statsreadservice.domain.view.TimeBonusModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatsServiceTest {

    @Mock
    private StatsRepository statsRepository;

    @InjectMocks
    private StatsService underTest;

    @Test
    void getStatsById() {
        //given
        StatsModel expectedStatsModel = buildTestStats();
        when(statsRepository.findById(anyLong())).thenReturn(Optional.of(expectedStatsModel));
        //when
        StatsModel statsModel = underTest.getStatsById(anyLong());
        //then
        assertThat(statsModel).isEqualTo(expectedStatsModel);
    }

    private StatsModel buildTestStats() {
        return new StatsModel(
                1L,
                new LvlModel(
                        1L,
                        0,
                        0
                ),
                new StatsValueModel(
                        1L,
                        0,
                        new TimeBonusModel(
                                0L,
                                LocalDateTime.now(),
                                0
                        ),
                        "DAMAGE"
                ),
                new StatsValueModel(
                        1L,
                        0,
                        new TimeBonusModel(
                                0L,
                                LocalDateTime.now(),
                                0
                        ),
                        "STRENGTH"
                ),
                new StatsValueModel(
                        1L,
                        0,
                        new TimeBonusModel(
                                0L,
                                LocalDateTime.now(),
                                0
                        ),
                        "DEXTERITY"
                ),
                new StatsValueModel(
                        1L,
                        0,
                        new TimeBonusModel(
                                0L,
                                LocalDateTime.now(),
                                0
                        ),
                        "DEFENSE"
                ),
                0
        );
    }

    @Test
    void shouldThrowStatsNotFoundExceptionWhileGettingStatsById() {
        //given
        when(statsRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when
        Executable getExecutable = () -> underTest.getStatsById(anyLong());
        //then
        assertThrows(StatsNotFoundException.class, getExecutable);
    }
}