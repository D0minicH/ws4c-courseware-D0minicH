package ch.fhnw.uieng.module04.mountainapp.view;

import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import ch.fhnw.uieng.module04.mountainapp.presentationmodel.MountainPM;
import ch.fhnw.uieng.module04.mountainapp.presentationmodel.Switzerland;
import ch.fhnw.uieng.module04.mountainapp.view.util.FHNWListView;
import ch.fhnw.uieng.module04.mountainapp.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends BorderPane implements ViewMixin {
    private Switzerland rootPM;

    // für das Gesamtlayout sind spezifischen Typen nicht relavant. Es reicht 'Node'
    private Node listView;
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
        listView = new FHNWListView<>(rootPM.getMountains(), param -> new MountainCell());
        footer   = new Footer(rootPM);
    }

    @Override
    public void layoutParts() {
        setTop(header);
        setCenter(listView);
        setBottom(footer);
    }

}
