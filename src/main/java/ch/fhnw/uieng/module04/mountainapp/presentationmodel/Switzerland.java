package ch.fhnw.uieng.module04.mountainapp.presentationmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module04.mountainapp.presentationmodel.util.PagingList;
import ch.fhnw.uieng.module04.mountainapp.service.MountainDTO;
import ch.fhnw.uieng.module04.mountainapp.service.PagingService;

/**
 * @author Dieter Holz
 */
public class Switzerland {

    private final PagingService<MountainDTO> service;

    private final StringProperty applicationTitle = new SimpleStringProperty("Schweizer Berge");
    private final StringProperty filter           = new SimpleStringProperty();

    private final PagingList<MountainPM, MountainDTO> allMountains;

    public Switzerland(PagingService<MountainDTO> service) {
        this.service = service;

        allMountains = new PagingList<>(service, index -> new MountainPM());
    }

    public PagingList<MountainPM, ?> getMountains() {
        return allMountains;
    }

    public String getFilter() {
        return filter.get();
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter.set(filter);
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

    public void applicationStopped() {
        allMountains.stopServiceCalls();

    }
}
