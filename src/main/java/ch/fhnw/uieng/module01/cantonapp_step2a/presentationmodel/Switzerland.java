package ch.fhnw.uieng.module01.cantonapp_step2a.presentationmodel;

import ch.fhnw.uieng.module01.cantonapp.presentationmodel.Canton;
import ch.fhnw.uieng.module01.cantonapp_step2a.service.CantonDTO;
import ch.fhnw.uieng.module01.cantonapp_step2a.service.CantonService;
import ch.fhnw.uieng.module01.cantonapp_step2a.service.CantonServiceFileBased;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    private final StringProperty applicationTitle = new SimpleStringProperty("Schweizer Kantone");

    private final CantonService service;
    public Switzerland(CantonService service){
        this.service = service;
    }

    public ObservableList<CantonPM> getAllCantons() {
        List<CantonDTO> dtos = service.findAll();

        List<CantonPM> cantons = dtos.stream()
                .map(cantonDTO -> new CantonPM(cantonDTO))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(cantons);
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
