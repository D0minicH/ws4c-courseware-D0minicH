package ch.fhnw.uieng.module02.cantonfiltered_solution.presentationmodel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module02.cantonfiltered_solution.service.serviceimpl.CantonServiceMemoryBased;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dieter Holz
 */
class SwitzerlandTest {
    private Switzerland ch;

    @BeforeEach
    void setup(){
        ch = new Switzerland(new CantonServiceMemoryBased());
    }

    @Test
    void testFilterByName(){
        //given

        //when
        ch.setFilter("aargau");

        //then
        assertEquals(1, ch.getCantons().size());
        assertEquals("Aargau", ch.getCantons().get(0).getKanton());
    }

    @Test
    void testFilterByKuerzel(){
        //given

        //when
        ch.setFilter("ag");

        //then
        assertEquals(1, ch.getCantons().size());
        assertEquals("Aargau", ch.getCantons().get(0).getKanton());
    }

    @Test
    void testResetFilter(){
        //given
        ch.setFilter("some filter");

        //when
        ch.setFilter("");

        //then
        assertEquals(26, ch.getCantons().size());
    }

    @Test
    void testResetFilterToNull(){
        //given
        ch.setFilter("some filter");

        //when
        ch.setFilter(null);

        //then
        assertEquals(26, ch.getCantons().size());
    }

    @Test
    void testInitialCount(){
        //given


        //when

        //then
        assertEquals(26, ch.getFilteredCount());
        assertEquals(26, ch.getTotalCount());
    }


    @Test
    void testFilteredCount(){
        //given


        //when
        ch.setFilter("aargau");

        //then
        assertEquals(1, ch.getFilteredCount());
        assertEquals(26, ch.getTotalCount());
    }
}