package ch.fhnw.uieng.module05.mountainform.view;

import ch.fhnw.uieng.module05.mountainform.presentationmodel.Switzerland;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import ch.fhnw.uieng.module05.mountainform.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
class Toolbar extends ToolBar implements ViewMixin {
    private static final String SAVE_ICON   = "\uf0c7";
    private static final String PLUS_ICON   = "\uf067";
    private static final String REMOVE_ICON = "\uf00d";
    private static final String UNDO_ICON   = "\uf0e2";
    private static final String REDO_ICON   = "\uf01e";
    private static final String CH_ICON     = "\ue001";
    private static final String UK_ICON     = "\ue000";

    private Button saveButton;
    private Button cancelButton;
    private Button languageDEButton;
    private Button languageUKButton;

    private final Switzerland rootSwitzerland;

    Toolbar(Switzerland rootSwitzerland) {
        this.rootSwitzerland = rootSwitzerland;
        init();
    }

    @Override
    public void initializeSelf() {
        getStyleClass().add("tool-bar");
    }

    @Override
    public void initializeParts() {
        saveButton = new Button(SAVE_ICON);
        saveButton.getStyleClass().add("fontawesome");

        cancelButton = new Button(UNDO_ICON);
        cancelButton.getStyleClass().add("fontawesome");

        languageDEButton = new Button(CH_ICON);
        languageDEButton.getStyleClass().add("flaticon");

        languageUKButton = new Button(UK_ICON);
        languageUKButton.getStyleClass().add("flaticon");
    }

    @Override
    public void layoutParts() {
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        getItems().addAll(saveButton, cancelButton, spacer, languageDEButton, languageUKButton);
    }
}
