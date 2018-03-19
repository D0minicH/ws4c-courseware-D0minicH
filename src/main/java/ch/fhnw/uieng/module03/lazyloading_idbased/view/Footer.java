package ch.fhnw.uieng.module03.lazyloading_idbased.view;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import ch.fhnw.uieng.module03.lazyloading_idbased.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_idbased.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
class Footer extends HBox implements ViewMixin {

    private final Switzerland rootPM;

    private Label count;

    Footer(Switzerland pm){
        rootPM = pm;
        init();
    }

    @Override
    public void initializeParts() {
        count = new Label();
    }

    @Override
    public void layoutParts() {
        count.setPadding(new Insets(5, 0, 0, 0));
        getChildren().add(count);
    }

    @Override
    public void setupBindings() {
        count.textProperty().bind(rootPM.communesCounterProperty().asString("%d Gemeinden"));
    }
}
