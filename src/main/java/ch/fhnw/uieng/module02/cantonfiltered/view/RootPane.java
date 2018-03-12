package ch.fhnw.uieng.module02.cantonfiltered.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import ch.fhnw.uieng.module02.cantonfiltered.presentationmodel.CantonPM;
import ch.fhnw.uieng.module02.cantonfiltered.presentationmodel.Switzerland;
import ch.fhnw.uieng.module02.cantonfiltered.view.util.ViewMixin;
import javafx.scene.layout.VBox;

/**
 * @author Dieter Holz
 */
public class RootPane extends VBox implements ViewMixin {
    private final Switzerland rootPM;

    private TextField filterField;
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
        filterField = new TextField();

        tableView = new TableView<>(rootPM.getFilteredCantons());

        //todo Die Beschriftungen der ColumnHeader ins PM verlagern.
        TableColumn<CantonPM, String> wappenCol = new TableColumn<>("");
        wappenCol.setCellValueFactory(cell -> cell.getValue().kuerzelProperty());
        wappenCol.setCellFactory(cell -> new KantonTableCell());

        TableColumn<CantonPM, String> nameCol = new TableColumn<>("Kanton");
        nameCol.setCellValueFactory(cell -> cell.getValue().kantonProperty());

        TableColumn<CantonPM, String> kuerzelCol = new TableColumn<>("K\u00fcrzel");
        kuerzelCol.setCellValueFactory(cell -> cell.getValue().kuerzelProperty());

        TableColumn<CantonPM, Number> kantonsnummerCol = new TableColumn<>("Nr.");
        kantonsnummerCol.setCellValueFactory(cell -> cell.getValue().kantonsnummerProperty());

        TableColumn<CantonPM, Number> standesstimmeCol = new TableColumn<>("Stimme");
        standesstimmeCol.setCellValueFactory(cell -> cell.getValue().standesstimmeProperty());

        TableColumn<CantonPM, Number> beitrittCol = new TableColumn<>("Beitritt");
        beitrittCol.setCellValueFactory(cell -> cell.getValue().beitrittProperty());

        TableColumn<CantonPM, String> hauptortCol = new TableColumn<>("Hauptort");
        hauptortCol.setCellValueFactory(cell -> cell.getValue().hauptortProperty());

        TableColumn<CantonPM, Number> einwohnerCol = new TableColumn<>("Einwohner");
        einwohnerCol.setCellValueFactory(cell -> cell.getValue().einwohnerProperty());

        TableColumn<CantonPM, Number> auslaenderCol = new TableColumn<>("% Ausländer");
        auslaenderCol.setCellValueFactory(cell -> cell.getValue().auslaenderProperty());

        TableColumn<CantonPM, Number> flaecheCol = new TableColumn<>("Fl\u00e4che");
        flaecheCol.setCellValueFactory(cell -> cell.getValue().flaecheProperty());

        TableColumn<CantonPM, Number> einwohnerdichteCol = new TableColumn<>("Einw. / km2");
        einwohnerdichteCol.setCellValueFactory(cell -> cell.getValue().einwohnerdichteProperty());

        TableColumn<CantonPM, Number> gemeindenCol = new TableColumn<>("Gemeinden");
        gemeindenCol.setCellValueFactory(cell -> cell.getValue().gemeindenProperty());

        TableColumn<CantonPM, String> amtsspracheCol = new TableColumn<>("Amtssprachen");
        amtsspracheCol.setCellValueFactory(cell -> cell.getValue().amtsspracheProperty());

        tableView.getColumns()
                 .addAll(wappenCol, nameCol, kuerzelCol, kantonsnummerCol, standesstimmeCol, beitrittCol, hauptortCol,
                         einwohnerCol, auslaenderCol, flaecheCol,
                         einwohnerdichteCol, gemeindenCol, amtsspracheCol);
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(filterField, tableView);
    }

    @Override
    public void setupBindings() {
        filterField.textProperty().bindBidirectional(rootPM.filterStringProperty());
    }
}
