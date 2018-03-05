package ch.fhnw.uieng.module01.cantonapp_step2b.presentationmodel;

import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module01.cantonapp_step2b.service.CantonService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final StringProperty applicationTitle = new SimpleStringProperty("Kantone der Schweiz");

    private final ObservableList<CantonPM> allCantons = FXCollections.observableArrayList();
    private final CantonService service;

    public Switzerland(CantonService service) {
        this.service = service;

        allCantons.addAll(service.findAll().stream()
                                 .map(CantonPM::of)
                                 .collect(Collectors.toList()));

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

    public ObservableList<CantonPM> getAllCantons() {
        return allCantons;
    }
}
