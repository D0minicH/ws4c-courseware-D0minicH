package ch.fhnw.uieng.module01.cantonapp_step1.service;

import ch.fhnw.uieng.module01.cantonapp_step1.presentationmodel.CantonPM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CantonService {

    public ObservableList<CantonPM> getAllCantons() {
        return FXCollections.observableArrayList(
                new CantonPM("Aargau",      "AG", 19, 1.0, 1803,  "Aarau",   627_893, 23.0, 1_404,  447, 219, "deutsch"),
                new CantonPM("Zürich",      "ZH",  1, 1.0, 1351, "Zürich", 1_408_575, 25.0, 1_729,  815, 170, "deutsch"),
                new CantonPM("Basel-Stadt", "BS", 12, 0.5, 1501,  "Basel",   194_661, 34.4,    37, 5261,   3, "deutsch")
        );
    }

}
