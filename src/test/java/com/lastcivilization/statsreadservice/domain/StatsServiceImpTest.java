package com.lastcivilization.statsreadservice.domain;

import com.lastcivilization.statsreadservice.domain.dto.StatsDto;
import com.lastcivilization.statsreadservice.domain.port.StatsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatsServiceImpTest {

    @Mock
    private StatsRepository statsRepository;

    @InjectMocks
    private StatsServiceImp underTest;

    @Test
    void getStatsById() {
        //given
        Stats testStats = buildTestStats();
        when(statsRepository.findById(anyLong())).thenReturn(Optional.of(testStats));
        //when
        StatsDto statsDto = underTest.getStatsById(anyLong());
        //then
        assertThat(statsDto.health()).isEqualTo(100);
        assertThat(statsDto.lvl().current()).isEqualTo(1);
        assertThat(statsDto.lvl().experience()).isEqualTo(0);
        assertThat(statsDto.damage().amount()).isEqualTo(1);
        assertThat(statsDto.damage().type()).isEqualTo("DAMAGE");
        assertThat(statsDto.damage().timeBonus().amount()).isEqualTo(0);
        assertThat(statsDto.damage().timeBonus().endDate().isBefore(LocalDateTime.now())).isTrue();
        assertThat(statsDto.strength().amount()).isEqualTo(1);
        assertThat(statsDto.strength().type()).isEqualTo("STRENGTH");
        assertThat(statsDto.strength().timeBonus().amount()).isEqualTo(0);
        assertThat(statsDto.strength().timeBonus().endDate().isBefore(LocalDateTime.now())).isTrue();
        assertThat(statsDto.dexterity().amount()).isEqualTo(1);
        assertThat(statsDto.dexterity().type()).isEqualTo("DEXTERITY");
        assertThat(statsDto.dexterity().timeBonus().amount()).isEqualTo(0);
        assertThat(statsDto.dexterity().timeBonus().endDate().isBefore(LocalDateTime.now())).isTrue();
        assertThat(statsDto.defense().amount()).isEqualTo(1);
        assertThat(statsDto.defense().type()).isEqualTo("DEFENSE");
        assertThat(statsDto.defense().timeBonus().amount()).isEqualTo(0);
        assertThat(statsDto.defense().timeBonus().endDate().isBefore(LocalDateTime.now())).isTrue();
    }

    private Stats buildTestStats() {
        return Stats.Builder.aStats().build();
    }
}