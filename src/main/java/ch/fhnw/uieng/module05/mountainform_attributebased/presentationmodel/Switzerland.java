package ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform_attributebased.service.MountainService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    private final StringProperty           applicationTitle = new SimpleStringProperty("Mountain Editor");
    private final ObjectProperty<Language> currentLanguage  = new SimpleObjectProperty<>();

    private MountainDetailPM currentMountain;

    public Switzerland(MountainService service) {
        currentMountain = MountainDetailPM.of(service.findAny());
        currentLanguage.addListener((observable, oldValue, newValue) -> {
            setApplicationTitle(newValue.equals(Language.DE) ? "Mountain Formular" : "Mountain Editor");
            currentMountain.setLanguage(newValue);
        });

        setCurrentLanguage(Language.DE);

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

    public MountainDetailPM getCurrentMountain() {
        return currentMountain;
    }

    public Language getCurrentLanguage() {
        return currentLanguage.get();
    }

    public ObjectProperty<Language> currentLanguageProperty() {
        return currentLanguage;
    }

    public void setCurrentLanguage(Language currentLanguage) {
        this.currentLanguage.set(currentLanguage);
    }
}
