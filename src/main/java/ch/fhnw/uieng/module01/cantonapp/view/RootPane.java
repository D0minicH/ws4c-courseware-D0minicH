package ch.fhnw.uieng.module01.cantonapp.view;

import ch.fhnw.uieng.module01.cantonapp.presentationmodel.Canton;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

import ch.fhnw.uieng.module01.cantonapp.presentationmodel.Swiss;
import ch.fhnw.uieng.module01.cantonapp.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends StackPane implements ViewMixin {
    private Swiss swiss;

    private TableView<Canton> cantonTable;

    public RootPane(Swiss swiss) {
        this.swiss = swiss;
        init();
    }

    @Override
    public void initializeSelf() {
        addStylesheetFiles("/fonts/fonts.css", "style.css");
        getStyleClass().add("root-pane");
    }

    @Override
    public void initializeParts() {

        cantonTable = new TableView <>(swiss.getAllCantons());

        TableColumn<Canton,String> nameColumn         = new TableColumn <>("Name");
        nameColumn.setCellValueFactory(cell -> cell.getValue().cantonNameProperty());

        TableColumn<Canton,String> abbreviationColumn = new TableColumn <>("Abbreviation");
        abbreviationColumn.setCellValueFactory(cell -> cell.getValue().cantonAbbreviationProperty());

        TableColumn<Canton,Integer> populationColumn = new TableColumn <>("Population");
        populationColumn.setCellValueFactory(cell -> cell.getValue().populationProperty().asObject());

        cantonTable.getColumns().addAll(nameColumn, abbreviationColumn, populationColumn);


    }

    @Override
    public void layoutParts() {

        getChildren().add(cantonTable);
    }

    @Override
    public void setupBindings() {

    }
}
