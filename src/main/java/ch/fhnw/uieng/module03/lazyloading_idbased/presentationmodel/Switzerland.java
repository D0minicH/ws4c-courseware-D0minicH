package ch.fhnw.uieng.module03.lazyloading_idbased.presentationmodel;

import java.util.stream.Collectors;

import ch.fhnw.uieng.module03.lazyloading_idbased.service.CommuneDTO;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module03.lazyloading_idbased.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final StringProperty applicationTitle = new SimpleStringProperty("Gemeinden der Schweiz");
    private final StringProperty filter           = new SimpleStringProperty();
    private final IntegerProperty communesCounter = new SimpleIntegerProperty();

    private final ObservableList<Long> allCommuneIds = FXCollections.observableArrayList();
    private final CommuneService service;

    public Switzerland(CommuneService service) {
        this.service = service;

        allCommuneIds.addAll(service.getAllIds());

        setupValueChangedListeners();
        setupBindings();
    }

    public CommunePM getCommuneById(long id){
        CommuneDTO dto = service.getCommuneById(id);
        return CommunePM.of(dto);
    }

    private void setupValueChangedListeners(){
        //todo: Reaktion auf Änderungen des filter-Strings. Wie macht man das bei Lazy-Loading?
    }

    private void setupBindings(){
        communesCounter.bind(Bindings.size(allCommuneIds));
    }

    public ObservableList<Long> getCommuneIds() {
        return allCommuneIds;
    }


    // alle setter und getter

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
