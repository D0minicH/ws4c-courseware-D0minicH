package ch.fhnw.uieng.module02.cantonfiltered.presentationmodel;

import ch.fhnw.uieng.module02.cantonfiltered.service.serviceimpl.CantonServiceMemoryBased;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwitzerlandTest {

    @Test
    void testFiltering(){
        //given
        Switzerland switzerland = new Switzerland(new CantonServiceMemoryBased());

        //when
        switzerland.setFilterString("Aargau");

        //then
        Assertions.assertEquals(1,switzerland.getFilteredCantons().size());
    }

    @Test
    void testCantonCounter(){
        //given
        Switzerland switzerland = new Switzerland(new CantonServiceMemoryBased());

        //when
        switzerland.setFilterString("Aargau");

        //then
        Assertions.assertEquals(26,switzerland.getTotalCantonCount());
        Assertions.assertEquals(1,switzerland.getFilteredCantonCount());
    }

}