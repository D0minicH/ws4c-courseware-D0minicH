package ch.fhnw.uieng.module01.helloworld.view;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import ch.fhnw.uieng.module01.helloworld.presentationmodel.DemoPM;
import ch.fhnw.uieng.module01.helloworld.view.util.ViewMixin;


public class RootPane extends StackPane implements ViewMixin {
    private final DemoPM pm;

    private Button button;

    public RootPane(DemoPM pm) {
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
