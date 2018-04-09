package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.presentationmodel;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final StringProperty  applicationTitle = new SimpleStringProperty("Gemeinden der Schweiz");
    private final StringProperty  filter           = new SimpleStringProperty();
    private final IntegerProperty communesCounter  = new SimpleIntegerProperty();

    private final ObservableList<CommunePM> allCommunes;
    private final CommuneService            service;

    public Switzerland(CommuneService service) {
        this.service = service;

        allCommunes = new LazyList(service);

        setupValueChangedListeners();
        setupBindings();
    }

    private void setupValueChangedListeners(){
        //todo: Reaktion auf Änderungen des filter-Strings. Wie macht man das bei Lazy-Loading?
    }

    private void setupBindings(){
        communesCounter.bind(Bindings.size(allCommunes));
    }

    public ObservableList<CommunePM> getCommunes() {
        return allCommunes;
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
