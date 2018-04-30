package ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.service.MountainService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    static final String TITLE_DE = "Mountain Formular";
    static final String TITLE_EN = "Mountain Editor";

    private final StringProperty applicationTitle = new SimpleStringProperty(TITLE_DE);
    private final ObjectProperty<Language> currentLanguage  = new SimpleObjectProperty<>();

    private MountainDetailPM currentMountain;

    private MountainService service;

    public Switzerland(MountainService service) {
        this.service = service;

        currentMountain = MountainDetailPM.of(service.findAny());

        currentLanguage.addListener((observable, oldValue, newValue) -> {
            setApplicationTitle(newValue.equals(Language.DE) ? TITLE_DE : TITLE_EN);
            currentMountain.setLanguage(newValue);
        });

        setCurrentLanguage(Language.DE);
    }

    // alle getter und setter
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
