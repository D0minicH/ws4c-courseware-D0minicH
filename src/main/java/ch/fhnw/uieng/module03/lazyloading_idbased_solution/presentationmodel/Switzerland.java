package ch.fhnw.uieng.module03.lazyloading_idbased_solution.presentationmodel;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import ch.fhnw.uieng.module03.lazyloading_idbased_solution.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final StringProperty applicationTitle = new SimpleStringProperty("Gemeinden der Schweiz");
    private final StringProperty filter           = new SimpleStringProperty();

    private final IntegerProperty communesCounter    = new SimpleIntegerProperty();
    private final IntegerProperty serviceCallCounter = new SimpleIntegerProperty();
    private final IntegerProperty instanceCounter    = new SimpleIntegerProperty();

    private final ObservableList<Long>           allCommuneIds  = FXCollections.observableArrayList();
    private final ObservableMap<Long, CommunePM> loadedCommunes = FXCollections.observableHashMap();

    private final CommuneService service;

    public Switzerland(CommuneService service) {
        this.service = service;

        allCommuneIds.addAll(service.findAllIds());

        setupValueChangedListeners();
        setupBindings();
    }

    private void setupValueChangedListeners(){
        //todo: Reaktion auf Änderungen des filter-Strings. Wie macht man das bei Lazy-Loading?
    }

    private void setupBindings(){
        communesCounter.bind(Bindings.size(allCommuneIds));
        instanceCounter.bind(Bindings.size(loadedCommunes));
    }

    public ObservableList<Long> getCommuneIds() {
        return allCommuneIds;
    }

    public CommunePM getCommune(long value) {
      //   sehr primitive Caching-Strategie.
        if(loadedCommunes.size() > 50){
            loadedCommunes.clear();
        }
        return loadedCommunes.computeIfAbsent(value, id -> {
            setServiceCallCounter(getServiceCallCounter() + 1);

            return CommunePM.of(service.get(id));
        });
    }

    // alle Getter und Setter

    public String getFilter() {
        return filter.get();
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter.set(filter);
    }

    public int getCommunesCounter() {
        return communesCounter.get();
    }

    public IntegerProperty communesCounterProperty() {
        return communesCounter;
    }

    public void setCommunesCounter(int communesCounter) {
        this.communesCounter.set(communesCounter);
    }

    public int getServiceCallCounter() {
        return serviceCallCounter.get();
    }

    public IntegerProperty serviceCallCounterProperty() {
        return serviceCallCounter;
    }

    public void setServiceCallCounter(int serviceCallCounter) {
        this.serviceCallCounter.set(serviceCallCounter);
    }

    public int getInstanceCounter() {
        return instanceCounter.get();
    }

    public IntegerProperty instanceCounterProperty() {
        return instanceCounter;
    }

    public void setInstanceCounter(int instanceCounter) {
        this.instanceCounter.set(instanceCounter);
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

}
