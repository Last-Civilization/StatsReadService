package com.lastcivilization.statsreadservice.infrastructure.application.rest;

import com.lastcivilization.statsreadservice.utils.IntegrationBaseClass;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class StatsControllerTest extends IntegrationBaseClass {

    @Test
    void shouldGetStatsById() throws Exception {
        //given
        //when
        ResultActions getResult = mockMvc.perform(get("/stats/1"));
        //then
        getResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.health").value(0))
                .andExpect(jsonPath("$.lvl.current").value(0))
                .andExpect(jsonPath("$.lvl.experience").value(0))
                .andExpect(jsonPath("$.damage.amount").value(1))
                .andExpect(jsonPath("$.damage.type").value("DAMAGE"))
                .andExpect(jsonPath("$.damage.timeBonus.endDate").exists())
                .andExpect(jsonPath("$.damage.total").value(2))
                .andExpect(jsonPath("$.strength.amount").value(0))
                .andExpect(jsonPath("$.strength.type").value("STRENGTH"))
                .andExpect(jsonPath("$.strength.timeBonus.endDate").exists())
                .andExpect(jsonPath("$.dexterity.amount").value(0))
                .andExpect(jsonPath("$.dexterity.type").value("DEXTERITY"))
                .andExpect(jsonPath("$.dexterity.timeBonus.endDate").exists())
                .andExpect(jsonPath("$.defense.amount").value(0))
                .andExpect(jsonPath("$.defense.type").value("DEFENSE"))
                .andExpect(jsonPath("$.defense.timeBonus.endDate").exists());
    }

    @Test
    void shouldReturnStatsNotFoundStatusWhileGettingById() throws Exception {
        //given
        //when
        ResultActions getResult = mockMvc.perform(get("/stats/2"));
        //then
        getResult.andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnValidationExceptionStatusWhileGettingById() throws Exception {
        //given
        //when
        ResultActions getResult = mockMvc.perform(get("/stats/0"));
        //then
        getResult.andExpect(status().isBadRequest());
    }
}