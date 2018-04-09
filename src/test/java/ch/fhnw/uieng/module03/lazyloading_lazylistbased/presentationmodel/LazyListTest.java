package ch.fhnw.uieng.module03.lazyloading_lazylistbased.presentationmodel;

import org.junit.jupiter.api.Test;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.CommuneService;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.serviceimpl.CommuneServiceFileBased;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dieter Holz
 */
class LazyListTest {

    @Test
    void testSize(){
        //given
        CommuneService service = new CommuneServiceFileBased();

        LazyList ll = new LazyList(service);

        //when
        int s = ll.size();

        //then
        assertEquals(service.getTotalCount(), s);
    }

    @Test
    void testGet(){
        //given
        CommuneService service = new CommuneServiceFileBased();
        LazyList ll = new LazyList(service);

        //when
        CommunePM pm = ll.get(0);

        //then
        assertEquals("Aeugst am Albis", pm.getNameOfficial());
    }
}
