package ch.fhnw.uieng.module04.mountainapp_solution.view;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel.MountainPM;
import ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module04.mountainapp_solution.view.util.FHNWListView;
import ch.fhnw.uieng.module04.mountainapp_solution.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends BorderPane implements ViewMixin {
    private Switzerland rootPM;

    private ListView<MountainPM> listView;
    private Node header;
    private Node footer;

    public RootPane(Switzerland pm) {
        this.rootPM = pm;
        init();
    }

    @Override
    public void initializeSelf() {
        addStylesheetFiles("fonts.css", "style.css");

        getStyleClass().add("root-pane");
    }

    @Override
    public void initializeParts() {
        header   = new Header(rootPM);
        listView = new FHNWListView<>(param -> new MountainCell());
        footer   = new Footer(rootPM);
    }

    @Override
    public void layoutParts() {
        setTop(header);
        setCenter(listView);
        setBottom(footer);
    }

    @Override
    public void setupBindings() {
        listView.itemsProperty().bind(rootPM.filteredMountainsProperty());
    }
}
