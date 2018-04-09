package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.presentationmodel;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableListBase;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class LazyList extends ObservableListBase<CommunePM> {

    private final CommuneService service;

    private final Map<Integer, CommunePM> cache = new HashMap<>();

    private final int count;

    public LazyList(CommuneService service) {
        this.service = service;
        count = service.getCount();
    }

    @Override
    public CommunePM get(int index) {
        if(cache.size() > 50){
            cache.clear();
        }
        return cache.computeIfAbsent(index, integer -> {
            new ServiceCaller(index).start();
            return new CommunePM();
        });
    }

    @Override
    public int size() {
        return count;
    }

    /**
     * Asynchronous service call to avoid UI freezing.
     */
    private class ServiceCaller extends Service<CommuneDTO> {
        private final int index;

        ServiceCaller(int index) {
            this.index = index;
            setOnSucceeded(event -> {
                CommunePM pm = cache.computeIfAbsent(index, integer -> new CommunePM());
                pm.apply(getValue());
            });
        }

        @Override
        protected Task<CommuneDTO> createTask() {
            return new Task<CommuneDTO>() {
                @Override
                protected CommuneDTO call() throws Exception {
                    //Simulation eines langsamen Services
                    Thread.sleep(30);
                    return service.get(index);
                }
            };
        }
    }
}
