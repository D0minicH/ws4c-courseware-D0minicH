package ch.fhnw.uieng.module03.lazyloading_lazylistbased.presentationmodel;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.CommuneService;
import javafx.collections.ObservableListBase;

public class LazyList extends ObservableListBase<CommunePM> {

    private final CommuneService service;

    public LazyList(CommuneService service) {
        this.service = service;
    }

    @Override
    public CommunePM get(int index) {
        return null;
    }

    @Override
    public int size() {
        return service.getTotalCount();
    }
}
