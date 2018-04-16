package ch.fhnw.uieng.module03.lazyloading_idbased.view;

import java.time.LocalDate;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import ch.fhnw.uieng.module03.lazyloading_idbased.presentationmodel.CommunePM;
import ch.fhnw.uieng.module03.lazyloading_idbased.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_idbased.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
class Content extends TableView<Long> implements ViewMixin {
    private final Switzerland rootPM;

    Content(Switzerland rootPM) {
        super(rootPM.getCommuneIds());
        this.rootPM = rootPM;

        init();
    }

    @Override
    public void initializeParts() {
        //todo Die Beschriftungen der ColumnHeader ins Switzerland verlagern.
        TableColumn<Long, String> cantonCodeCol = new TableColumn<>("Kantonsk\u00fcrzel");
        cantonCodeCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).cantonCodeProperty());
        cantonCodeCol.getStyleClass().add("center");

        TableColumn<Long, Number> destrictCodeCol = new TableColumn<>("Bezirksnummer");
        destrictCodeCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).destrictIDProperty());
        destrictCodeCol.getStyleClass().add("center");

        TableColumn<Long, Number> communeIdCol = new TableColumn<>("Gemeindenummer");
        communeIdCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).idProperty());
        communeIdCol.getStyleClass().add("center");

        TableColumn<Long, String> nameOfficialCol = new TableColumn<>("Gemeindename (amtlich)");
        nameOfficialCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).nameOfficialProperty());

        TableColumn<Long, String> nameShortCol = new TableColumn<>("Gemeindename (kurz");
        nameShortCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).nameShortProperty());

        TableColumn<Long, String> destrictNameCol = new TableColumn<>("Bezirksname");
        destrictNameCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).destrictNameProperty());

        TableColumn<Long, String> cantonNameCol = new TableColumn<>("Kantonsname");
        cantonNameCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).cantonNameProperty());

        TableColumn<Long, LocalDate> lastChangeCol = new TableColumn<>("Letzte Aenderung");
        lastChangeCol.setCellValueFactory(cell -> rootPM.getCommuneById(cell.getValue()).lastModificationProperty());
        lastChangeCol.getStyleClass().add("center");
        lastChangeCol.setCellFactory(cell -> new LocalDateCell());  // legt die Formatierung des Datums fest

        getColumns().addAll(cantonCodeCol, destrictCodeCol, communeIdCol, nameOfficialCol,
                nameShortCol, destrictNameCol, cantonNameCol, lastChangeCol
        );

    }

    @Override
    public void layoutParts() {
        //nothing to do
    }
}
