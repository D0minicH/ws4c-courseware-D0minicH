package ch.fhnw.uieng.module01.cantonapp_step1.presentationmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module01.cantonapp_step1.service.CantonService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    private final StringProperty applicationTitle = new SimpleStringProperty("Schweizer Kantone");

    public ObservableList<CantonPM> getAllCantons() {return new CantonService().getAllCantons(); }

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
