package com.softway.medical.softwaymedical.controller;

import com.softway.medical.softwaymedical.common.IndexSanteConstant;
import com.softway.medical.softwaymedical.exception.SanteIndexException;
import com.softway.medical.softwaymedical.service.IndexSanteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.Constants;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IndexSanteController.class )
@AutoConfigureMockMvc
public class SanteIndexControllerTest {

    @MockBean
    private IndexSanteService  indexSanteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenCorrectIndexWhenCallSanteIndexApiThenReturnSuccesPathologie() throws Exception {
        //when
        when(indexSanteService.determinePathologies(anyInt())).thenReturn(Arrays.asList(IndexSanteConstant.PATHOLOGIE_CARDIO));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/diagnostic/9").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void givenBadIndexWhenCallSanteIndexApiThenReturnBadRequestError() throws Exception {
        //when
        when(indexSanteService.determinePathologies(anyInt())).thenThrow(new SanteIndexException(11));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/diagnostic/11").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
