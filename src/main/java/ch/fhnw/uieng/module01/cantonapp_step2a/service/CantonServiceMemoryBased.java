package ch.fhnw.uieng.module01.cantonapp_step2a.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ch.fhnw.uieng.module01.cantonapp_step2a.presentationmodel.CantonPM;

import java.util.List;

/**
 * @author Dieter Holz
 */
public class CantonServiceMemoryBased implements CantonService {

    public List <CantonDTO> findAll() {
        return List.of(
                new CantonDTO("Aargau", "AG", "19", "1.0", "1803", "Aarau", "627893", "23.0", "1404", "447", "219", "deutsch"),
                new CantonDTO("Zürich", "ZH", "1", "1.0", "1351", "Zürich", "1408575", "25.0", "1729", "815", "170", "deutsch")
        );
    }
}
