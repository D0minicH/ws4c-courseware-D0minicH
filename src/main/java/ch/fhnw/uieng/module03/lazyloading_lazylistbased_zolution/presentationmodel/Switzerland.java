package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.util.PagingList;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service.PagingService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final PagingService<CommuneDTO> service;

    private final StringProperty  applicationTitle = new SimpleStringProperty("Gemeinden der Schweiz");
    private final StringProperty  filter           = new SimpleStringProperty();
    private final IntegerProperty communesCounter  = new SimpleIntegerProperty();

    private final PagingList<CommunePM, CommuneDTO> allCommunes;

    public Switzerland(PagingService<CommuneDTO> service) {
        this.service = service;

        allCommunes = new PagingList<>(service, index -> new CommunePM());

        setupValueChangedListeners();
        setupBindings();
    }

    private void setupValueChangedListeners(){
        //todo: Reaktion auf Änderungen des filter-Strings. Wie macht man das bei Lazy-Loading?
    }

    private void setupBindings(){
        communesCounter.bind(Bindings.size(allCommunes));
    }

    public PagingList<CommunePM, CommuneDTO> getCommunes() {
        return allCommunes;
    }


    // alle getter und setter

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
