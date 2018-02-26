package ch.fhnw.uieng.module01.cantonapp.view;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import ch.fhnw.uieng.module01.cantonapp.presentationmodel.PM;
import ch.fhnw.uieng.module01.cantonapp.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends StackPane implements ViewMixin {
    private PM pm;

    private Button button;

    public RootPane(PM pm) {
        this.pm = pm;
        init();
    }

    @Override
    public void initializeSelf() {
        addStylesheetFiles("/fonts/fonts.css", "style.css");
        getStyleClass().add("root-pane");
    }

    @Override
    public void initializeParts() {
        button = new Button();
    }

    @Override
    public void layoutParts() {
        getChildren().add(button);
    }

    @Override
    public void setupBindings() {
        button.textProperty().bind(pm.greetingProperty());
    }
}
