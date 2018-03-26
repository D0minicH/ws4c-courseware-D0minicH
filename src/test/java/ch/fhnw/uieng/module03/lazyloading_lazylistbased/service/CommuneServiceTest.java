package ch.fhnw.uieng.module03.lazyloading_lazylistbased.service;

import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.serviceimpl.CommuneServiceFileBased;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dieter Holz
 */
class CommuneServiceTest {

    @Test
    void testTotalCount() {
        //given
        CommuneService service = new CommuneServiceFileBased();

        //when
        int count = service.getTotalCount();

        //then
        assertTrue(count > 2000);

    }

    @Test
    void testGetCommune() {
        //given
        CommuneService service = new CommuneServiceFileBased();
        int totalCount = service.getTotalCount();

        //when
        CommuneDTO dto = service.getCommune(0);

        //then
        assertEquals(1, dto.getId());


        //when
        dto = service.getCommune(totalCount-1);

        //then
        assertEquals(6810, dto.getId());
    }

}