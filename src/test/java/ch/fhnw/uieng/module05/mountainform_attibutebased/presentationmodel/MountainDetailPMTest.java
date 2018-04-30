package ch.fhnw.uieng.module05.mountainform_attibutebased.presentationmodel;

import ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.MountainDetailPM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class MountainDetailPMTest {

    @Test
    void testImageURL(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.getImageURL().setValue("http://someURL");

        //then
        assertTrue(pm.getCaption().isMandatory());

        //when
        pm.getImageURL().setValue("");

        //then
        assertFalse(pm.getCaption().isMandatory());

        //when
        pm.getImageURL().setValue("illegal URL");

        //then
        assertFalse(pm.getCaption().isMandatory());
    }

    @Test
    void testCantons(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.getCantons().setValue("AG");

        //then
        assertTrue(pm.getRange().isReadOnly());

        //when
        pm.getCantons().setValue("");

        //then
        assertFalse(pm.getRange().isReadOnly());
    }

    @Test
    void testDirty(){
        //given
        MountainDetailPM pm = new MountainDetailPM();
        String oldValue = pm.getName().getValue();

        //then
        assertFalse(pm.isDirty());

        //when
        pm.getName().setValue("some new value");

        //then
        assertTrue(pm.isDirty());

        //when
        pm.getName().setValue(oldValue);

        //then
        assertFalse(pm.isDirty());
    }

}