package ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel.util;

import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel.Language;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dieter Holz
 */
class AttributeTest {
    @Test
    void testIsDirty(){
        //given
        StringAttribute attribute = Attribute.of("Hello");

        //when

        //then
        assertFalse(attribute.isDirty());

        //when
        attribute.setValue("Brugg");

        //then
        assertTrue(attribute.isDirty());

        //when
        attribute.setValue("Hello");

        //then
        assertFalse(attribute.isDirty());
    }

    @Test
    void testRebase(){
        //given
        StringAttribute attribute = Attribute.of("Hello");
        attribute.setValue("Brugg");

        //when
        attribute.rebase();

        //then
        assertEquals("Brugg", attribute.getValue());
        assertEquals("Brugg", attribute.getPersistentValue());
        assertEquals("Brugg", attribute.getUserInput());
        assertFalse(attribute.isDirty());
    }

    @Test
    void testRevert(){
        //given
        StringAttribute attribute = Attribute.of("Hello");
        attribute.setValue("Brugg");

        //when
        attribute.revert();

        //then
        assertEquals("Hello", attribute.getValue());
        assertEquals("Hello", attribute.getPersistentValue());
        assertEquals("Hello", attribute.getUserInput());
        assertFalse(attribute.isDirty());
    }
    

    @Test
    void testSetUserInput(){
        //given
        StringAttribute attribute = Attribute.of("Hello");


        //when
        attribute.setUserInput("Brugg");

        //then
        assertEquals("Brugg", attribute.getValue());
        assertEquals("Hello", attribute.getPersistentValue());
        assertEquals("Brugg", attribute.getUserInput());
        assertTrue(attribute.isDirty());
    }


    @Test
    void testSetLanguage(){
        //given
        StringAttribute attribute = Attribute.of("Hello")
                                             .label(Language.DE, "Beschriftung")
                                             .label(Language.UK, "Label");


        //when
        attribute.setLanguage(Language.DE);

        //then
        assertEquals("Beschriftung", attribute.getLabel());

        //when
        attribute.setLanguage(Language.UK);

        //then
        assertEquals("Label", attribute.getLabel());
    }

    @Test
    void testInputValidation(){
        //given
        DoubleAttribute attribute = Attribute.of(0.0);


        //when
        attribute.setUserInput("3.0");

        //then
        assertEquals(3.0, attribute.getValue(), 0.001);
        assertTrue(attribute.isValid());

        //when
        attribute.setUserInput("yyy");

        //then
        assertEquals(3.0, attribute.getValue(), 0.001);
        assertFalse(attribute.isValid());
    }

}