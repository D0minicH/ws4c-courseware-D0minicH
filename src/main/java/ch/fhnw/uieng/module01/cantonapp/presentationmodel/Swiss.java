package ch.fhnw.uieng.module01.cantonapp.presentationmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class Swiss {
    private final StringProperty applicationTitle = new SimpleStringProperty("CantonApp");

    private ObservableList <Canton> allCantons = FXCollections.observableArrayList();

    public Swiss(){
        allCantons.add(new Canton("Aargau", "AG", 653000));
        allCantons.add(new Canton("Baselstadt", "BL", 53000));
        allCantons.add(new Canton("Bern", "BE", 122000));
    }

    public ObservableList <Canton> getAllCantons() {
        return allCantons;
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
