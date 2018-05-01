package ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testIsolation(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.getIsolation().setUserInput("");

        //then
        assertFalse(pm.getIsolationPoint().isMandatory());

        //when
        pm.getIsolation().setUserInput("10.0");

        //then
        assertTrue(pm.getIsolationPoint().isMandatory());
    }

    @Test
    void testProminence(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.getProminence().setUserInput("");

        //then
        assertFalse(pm.getProminencePoint().isMandatory());

        //when
        pm.getProminence().setUserInput("10.0");

        //then
        assertTrue(pm.getProminencePoint().isMandatory());
    }

    @Test
    void testHeight(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //when
        pm.getHeight().setValue(-10.0);

        //then
        assertFalse(pm.getHeight().isValid());

        //when
        pm.getHeight().setValue(10.0);

        //then
        assertTrue(pm.getHeight().isValid());

        //when
        pm.getHeight().setValue(6000.0);

        //then
        assertFalse(pm.getHeight().isValid());
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

    @Test
    void testValid(){
        //given
        MountainDetailPM pm = new MountainDetailPM();

        //then
        assertTrue(pm.isValid());

        //when
        pm.getHeight().setUserInput("no valid number");

        //then
        assertFalse(pm.isValid());

        //when
        pm.getHeight().setValue(10.0);

        //then
        assertTrue(pm.isValid());
    }



}