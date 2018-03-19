package ch.fhnw.uieng.module03.lazyloading_lazylistbased.view;

import java.time.LocalDate;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.presentationmodel.CommunePM;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased.view.LocalDateCell;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
class Content extends TableView<CommunePM> implements ViewMixin {
    private final Switzerland rootPM;

    Content(Switzerland rootPM) {
        super(rootPM.getCommunes());

        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {
        //todo Die Beschriftungen der ColumnHeader ins PM verlagern.
        TableColumn<CommunePM, String> cantonCodeCol = new TableColumn<>("Kantonsk\u00fcrzel");
        cantonCodeCol.setCellValueFactory(cell -> cell.getValue().cantonCodeProperty());
        cantonCodeCol.getStyleClass().add("center");

        TableColumn<CommunePM, Number> destrictCodeCol = new TableColumn<>("Bezirksnummer");
        destrictCodeCol.setCellValueFactory(cell -> cell.getValue().destrictIDProperty());
        destrictCodeCol.getStyleClass().add("center");

        TableColumn<CommunePM, Number> communeIdCol = new TableColumn<>("Gemeindenummer");
        communeIdCol.setCellValueFactory(cell -> cell.getValue().idProperty());
        communeIdCol.getStyleClass().add("center");

        TableColumn<CommunePM, String> nameOfficialCol = new TableColumn<>("Gemeindename (amtlich)");
        nameOfficialCol.setCellValueFactory(cell -> cell.getValue().nameOfficialProperty());

        TableColumn<CommunePM, String> nameShortCol = new TableColumn<>("Gemeindename (kurz");
        nameShortCol.setCellValueFactory(cell -> cell.getValue().nameShortProperty());

        TableColumn<CommunePM, String> destrictNameCol = new TableColumn<>("Bezirksname");
        destrictNameCol.setCellValueFactory(cell -> cell.getValue().destrictNameProperty());

        TableColumn<CommunePM, String> cantonNameCol = new TableColumn<>("Kantonsname");
        cantonNameCol.setCellValueFactory(cell -> cell.getValue().cantonNameProperty());

        TableColumn<CommunePM, LocalDate> lastChangeCol = new TableColumn<>("Letzte Aenderung");
        lastChangeCol.setCellValueFactory(cell -> cell.getValue().lastModificationProperty());
        lastChangeCol.getStyleClass().add("center");

        lastChangeCol.setCellFactory(cell -> new LocalDateCell());  // legt die Formatierung des Datums fest

        getColumns().addAll(cantonCodeCol, destrictCodeCol, communeIdCol, nameOfficialCol, nameShortCol, destrictNameCol,
                            cantonNameCol, lastChangeCol);

    }

    @Override
    public void layoutParts() {
        //nothing to do
    }
}
