package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.view;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class RootPane extends BorderPane implements ViewMixin {
    private Switzerland rootPM;

    private Node header;
    private Node content;
    private Node footer;

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
        header  = new Header(rootPM);
        content = new Content(rootPM);
        footer  = new Footer(rootPM);
    }

    @Override
    public void layoutParts() {
        setTop(header);
        setCenter(content);
        setBottom(footer);
    }
}
