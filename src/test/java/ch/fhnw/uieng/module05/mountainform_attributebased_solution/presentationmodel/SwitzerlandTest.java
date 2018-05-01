package ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.MountainDetailDTO;
import ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.MountainService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dieter Holz
 */
class SwitzerlandTest {
    private TestService service;
    private Switzerland switzerland;

    @BeforeEach
    void setup() {
        service = new TestService();
        switzerland = new Switzerland(service);
    }

    @Test
    void testInit() {
        //given

        //when

        //then
        assertNotNull(switzerland.applicationTitleProperty());
        assertNotNull(switzerland.getCurrentLanguage());
        assertNotNull(switzerland.getCurrentMountain());
    }

    @Test
    void testSetLanguage() {
        //when
        switzerland.setCurrentLanguage(Language.DE);

        //then
        assertEquals(Switzerland.TITLE_DE, switzerland.getApplicationTitle());
        assertEquals("Bildunterschrift", switzerland.getCurrentMountain().getCaption().getLabel());

        //when
        switzerland.setCurrentLanguage(Language.UK);

        //then
        assertEquals(Switzerland.TITLE_EN, switzerland.getApplicationTitle());
        assertEquals("Caption", switzerland.getCurrentMountain().getCaption().getLabel());
    }

    @Test
    void testSave() {
        //given
        MountainDetailPM mountain = switzerland.getCurrentMountain();
        mountain.getName().setValue("neuer Name");

        //when
        switzerland.save();

        //then
        assertFalse(mountain.isDirty());
        assertTrue(service.saveWasCalled);
    }

    @Test
    void testRevert() {
        //given
        MountainDetailPM mountain  = switzerland.getCurrentMountain();
        String           oldName   = mountain.getName().getValue();
        Double           oldHeight = mountain.getHeight().getValue();
        mountain.getName().setValue("neuer Name");
        mountain.getHeight().setValue(10.0);

        //when
        switzerland.revert();

        //then
        assertEquals(oldName, mountain.getName().getValue());
        assertEquals(oldHeight, mountain.getHeight().getValue());
        assertFalse(switzerland.getCurrentMountain().isDirty());
    }

    public class TestService implements MountainService {

        private boolean saveWasCalled = false;

        @Override
        public MountainDetailDTO findAny() {
            return new MountainDetailDTO("100", "Matterhorn", "4478.0", "Hauptgipfel", "Wallis/Italien", "", "Walliser Alpen", "10.9", "Liskamm", "1030.0",
                                         "Col Durand", "Matterhorn von Riffelalp");
        }

        @Override
        public void save(MountainDetailDTO dto) {
            saveWasCalled = true;
        }
    }
}