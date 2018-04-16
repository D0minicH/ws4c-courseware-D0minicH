package ch.fhnw.uieng.module05.mountainform.presentationmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform.service.MountainService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    private final StringProperty applicationTitle = new SimpleStringProperty("Mountain Editor");

    private MountainDetailPM currentPM;

    public Switzerland(MountainService service) {
        currentPM = MountainDetailPM.of(service.findAny());
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

    public MountainDetailPM getCurrentPM() {
        return currentPM;
    }

}
