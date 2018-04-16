package ch.fhnw.uieng.module05.mountainform.presentationmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainDetailPMTest {

    @Test
    void tetsInit(){
        //given

        //when
        MountainDetailPM pm = new MountainDetailPM();

        //then
        assertEquals("Bildunterschrift", pm.getCaptionLabel());
    }

    @Test
    void testSetLanguage(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.setLanguage(Language.EN);

        //then
        assertEquals("Caption", pm.getCaptionLabel());

        //when
        pm.setLanguage(Language.DE);

        //then
        assertEquals("Bildunterschrift", pm.getCaptionLabel());

    }

}