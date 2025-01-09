package com.softway.medical.softwaymedical.service;

import com.softway.medical.softwaymedical.common.IndexSanteConstant;
import com.softway.medical.softwaymedical.exception.SanteIndexException;
import com.softway.medical.softwaymedical.service.IndexSanteService;
import com.softway.medical.softwaymedical.service.IndexSanteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SanteIndexServiceTest {

    private IndexSanteService indexSanteService;

    @BeforeEach
    void setUp()
    {
        this.indexSanteService = new IndexSanteServiceImpl();
    }

    @Test
    public void givenIndexCardioWhenDeterminPathologieThenSuccess() {
        //given
        int index = 9 ;
        //when
        List<String> result = indexSanteService.determinePathologies(index);
        //then
        assertEquals(1, result.size());
        assertEquals(IndexSanteConstant.PATHOLOGIE_CARDIO,result.get(0));

    }

    @Test
    public void givenIndexTraumatoWhenDeterminPathologieThenSuccess() {
        //given
        int index = 10 ;
        //when
        List<String> result = indexSanteService.determinePathologies(index);
        //then
        assertEquals(1, result.size());
        assertEquals(IndexSanteConstant.PATHOLOGIE_TRAUMATO,result.get(0));

    }

    @Test
    public void givenIndexTraumatoAndCardioWhenDeterminPathologieThenSuccess() {
        //given
        int index = 15 ;
        //when
        List<String> result = indexSanteService.determinePathologies(index);
        //then
        assertEquals(2, result.size());
        assertTrue(result.contains(IndexSanteConstant.PATHOLOGIE_TRAUMATO));
        assertTrue(result.contains(IndexSanteConstant.PATHOLOGIE_CARDIO));

    }

    @Test
    public void givenIndexNotFoundWhenDeterminPathologieThenThrowsSanteIndexException() {
        //given
        int index = 11 ;
        //when //then
        assertThrows(SanteIndexException.class, () -> indexSanteService.determinePathologies(index));

    }


}
