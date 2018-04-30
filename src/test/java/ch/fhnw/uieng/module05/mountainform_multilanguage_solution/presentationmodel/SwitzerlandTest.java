package ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.service.serviceimpl.MountainServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Dieter Holz
 */
class SwitzerlandTest {
    private Switzerland switzerland;

    @BeforeEach
    void setup(){
        switzerland = new Switzerland(new MountainServiceImpl());
    }

    @Test
    void testInit(){
        //given

        //when

        //then
        assertNotNull(switzerland.applicationTitleProperty());
        assertNotNull(switzerland.getCurrentLanguage());
        assertNotNull(switzerland.getCurrentMountain());
    }


    @Test
    void testSetLanguage(){
        //given

        //when
        switzerland.setCurrentLanguage(Language.DE);

        //then
        assertEquals(Switzerland.TITLE_DE, switzerland.getApplicationTitle());
        assertEquals("Bildunterschrift", switzerland.getCurrentMountain().getCaptionLabel());

        //when
        switzerland.setCurrentLanguage(Language.UK);

        //then
        assertEquals(Switzerland.TITLE_EN, switzerland.getApplicationTitle());
        assertEquals("Caption", switzerland.getCurrentMountain().getCaptionLabel());
    }
}