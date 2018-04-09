package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.presentationmodel;

import javafx.collections.ObservableListBase;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class LazyList extends ObservableListBase<CommunePM> {
    private final CommuneService service;

    private int       lastIndex = -1;
    private CommunePM lastPM    = null;

    private final int count;

    public LazyList(CommuneService service) {
        this.service = service;
        count = service.getCount();
    }

    @Override
    public CommunePM get(int index) {
        if (lastIndex != index) {
            sleep(10);
            lastPM = CommunePM.of(service.get(index));
            lastIndex = index;
        }

        return lastPM;
    }

    @Override
    public int size() {
        return count;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // nothing to do
        }
    }
}
