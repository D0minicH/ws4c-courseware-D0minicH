package ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.MountainService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    public static final String TITLE_DE = "Mountain Formular";
    public static final String TITLE_EN = "Mountain Editor";

    private final StringProperty applicationTitle = new SimpleStringProperty("Mountain Editor");
    private final ObjectProperty<Language> currentLanguage  = new SimpleObjectProperty<>();

    private MountainDetailPM currentMountain;
    private final MountainService service;

    public Switzerland(MountainService service) {
        this.service = service;

        currentMountain = MountainDetailPM.of(service.findAny());

        currentLanguage.addListener((observable, oldValue, newValue) -> {
            setApplicationTitle(newValue.equals(Language.DE) ? TITLE_DE : TITLE_EN);
            currentMountain.setLanguage(newValue);
        });

        setCurrentLanguage(Language.DE);
    }

    public void save() {
        service.save(currentMountain.toDTO());
        currentMountain.rebase();
    }

    public void revert() {
        currentMountain.revert();
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
