package ch.fhnw.uieng.module02.cantonfiltered.presentationmodel;

import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module02.cantonfiltered.service.CantonDTO;
import ch.fhnw.uieng.module02.cantonfiltered.service.CantonService;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 * Switzerland ist der zentrale Einstieg in den PresentationModel-Layer.
 *
 * Von hier aus sind alle darzustellenden Informationen zugreifbar.
 *
 * Von Switzerland gibt es genau eine Instanz.
 *
 * @author Dieter Holz
 */
public class Switzerland {
    // alle Attribute sind JavaFX-Properties oder ObservableList
    private final StringProperty applicationTitle = new SimpleStringProperty("Kantone der Schweiz");

    private final StringProperty filterString = new SimpleStringProperty();
    private final IntegerProperty totalCantonCount = new SimpleIntegerProperty();
    private final IntegerProperty filteredCantonCount = new SimpleIntegerProperty();

    private final ObservableList<CantonPM> allCantons = FXCollections.observableArrayList();

    private final FilteredList<CantonPM> filteredCantons = new FilteredList<>(allCantons);

    private final SortedList<CantonPM> sortedCantons = new SortedList<>(filteredCantons);

    private final CantonService service;

    public Switzerland(CantonService service) {
        this.service = service;

        // Services liefern DTOs zurück
        List<CantonDTO> dtos = service.findAll();
        setupBindings();

        allCantons.addAll(dtos.stream()
                              .map(CantonPM::of)
                              .collect(Collectors.toList()));

        filterString.addListener((observable, oldValue, newValue) -> {
            filteredCantons.setPredicate(cantonPM -> cantonPM.getKanton().equals(newValue));
        });
    }

    public ObservableList <CantonPM> getAllCantons() { return sortedCantons;}

    private void setupBindings() {
        totalCantonCount.bind(Bindings.size(allCantons));
        filteredCantonCount.bind(Bindings.size(filteredCantons));
    }

    // alle getter und setter (generiert via "Code -> Generate")
    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public ObservableList<CantonPM> getFilteredCantons() { return filteredCantons; }

    public String getFilterString() { return filterString.get(); }

    public StringProperty filterStringProperty() { return filterString; }

    public void setFilterString(String filterString) { this.filterString.set(filterString); }

    public int getTotalCantonCount() { return totalCantonCount.get(); }

    public IntegerProperty totalCantonCountProperty() { return totalCantonCount; }

    public void setTotalCantonCount(int totalCantonCount) { this.totalCantonCount.set(totalCantonCount); }

    public int getFilteredCantonCount() { return filteredCantonCount.get(); }

    public IntegerProperty filteredCantonCountProperty() { return filteredCantonCount; }

    public void setFilteredCantonCount(int filteredCantonCount) { this.filteredCantonCount.set(filteredCantonCount); }
}
