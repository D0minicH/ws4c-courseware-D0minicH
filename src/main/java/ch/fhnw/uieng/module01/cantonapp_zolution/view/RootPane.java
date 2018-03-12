package ch.fhnw.uieng.module01.cantonapp_zolution.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

import ch.fhnw.uieng.module01.cantonapp_zolution.presentationmodel.CantonPM;
import ch.fhnw.uieng.module01.cantonapp_zolution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module01.cantonapp_zolution.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends StackPane implements ViewMixin {
    private Switzerland rootPM;

    private TableView<CantonPM> tableView;

    public RootPane(Switzerland pm) {
        this.rootPM = pm;
        init();
    }

    @Override
    public void initializeSelf() {
        addStylesheetFiles("/fonts/fonts.css", "style.css");
        getStyleClass().add("root-pane");
    }

    @Override
    public void initializeParts() {
        tableView = new TableView<>(rootPM.getAllCantons());

        //todo Die Beschriftungen der ColumnHeader ins PM verlagern.
        TableColumn<CantonPM, String> wappenCol = new TableColumn<>("");
        wappenCol.setCellValueFactory(param -> param.getValue().kuerzelProperty());
        wappenCol.setCellFactory(param -> new KantonTableCell());

        TableColumn<CantonPM, String> nameCol = new TableColumn<>("Kanton");
        nameCol.setCellValueFactory(param -> param.getValue().kantonProperty());

        TableColumn<CantonPM, String> kuerzelCol = new TableColumn<>("K\u00fcrzel");
        kuerzelCol.setCellValueFactory(param -> param.getValue().kuerzelProperty());

        TableColumn<CantonPM, Number> kantonsnummerCol = new TableColumn<>("Nr.");
        kantonsnummerCol.setCellValueFactory(param -> param.getValue().kantonsnummerProperty());

        TableColumn<CantonPM, Number> standesstimmeCol = new TableColumn<>("Stimme");
        standesstimmeCol.setCellValueFactory(param -> param.getValue().standesstimmeProperty());

        TableColumn<CantonPM, Number> beitrittCol = new TableColumn<>("Beitritt");
        beitrittCol.setCellValueFactory(param -> param.getValue().beitrittProperty());

        TableColumn<CantonPM, String> hauptortCol = new TableColumn<>("Hauptort");
        hauptortCol.setCellValueFactory(param -> param.getValue().hauptortProperty());

        TableColumn<CantonPM, Number> einwohnerCol = new TableColumn<>("Einwohner");
        einwohnerCol.setCellValueFactory(param -> param.getValue().einwohnerProperty());

        TableColumn<CantonPM, Number> auslaenderCol = new TableColumn<>("% Ausländer");
        auslaenderCol.setCellValueFactory(param -> param.getValue().auslaenderProperty());

        TableColumn<CantonPM, Number> flaecheCol = new TableColumn<>("Fl\u00e4che");
        flaecheCol.setCellValueFactory(param -> param.getValue().flaecheProperty());

        TableColumn<CantonPM, Number> einwohnerdichteCol = new TableColumn<>("Einw. / km2");
        einwohnerdichteCol.setCellValueFactory(param -> param.getValue().einwohnerdichteProperty());

        TableColumn<CantonPM, Number> gemeindenCol = new TableColumn<>("Gemeinden");
        gemeindenCol.setCellValueFactory(param -> param.getValue().gemeindenProperty());

        TableColumn<CantonPM, String> amtsspracheCol = new TableColumn<>("Amtssprachen");
        amtsspracheCol.setCellValueFactory(param -> param.getValue().amtsspracheProperty());

        tableView.getColumns()
                 .addAll(wappenCol, nameCol, kuerzelCol, kantonsnummerCol, standesstimmeCol, beitrittCol, hauptortCol,
                         einwohnerCol, auslaenderCol, flaecheCol,
                         einwohnerdichteCol, gemeindenCol, amtsspracheCol);
    }

    @Override
    public void layoutParts() {
        getChildren().add(tableView);
    }

}
