package ch.fhnw.uieng.module03.lazyloading_idbased_solution.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import ch.fhnw.uieng.module03.lazyloading_idbased_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_idbased_solution.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
class Footer extends HBox implements ViewMixin {

    private final Switzerland rootPM;

    private Label count;
    private Label loadCount;
    private Label serviceCalls;

    Footer(Switzerland pm) {
        rootPM = pm;
        init();
    }

    @Override
    public void initializeParts() {
        count        = new Label();
        loadCount    = new Label();
        serviceCalls = new Label();
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(count, new Label(", "), loadCount, new Label(", "), serviceCalls);
    }

    @Override
    public void setupBindings() {
        count.textProperty()       .bind(rootPM.communesCounterProperty().asString("%d Gemeinden"));
        loadCount.textProperty()   .bind(rootPM.instanceCounterProperty().asString("%d Commune Instanzen"));
        serviceCalls.textProperty().bind(rootPM.serviceCallCounterProperty().asString("%d Service Calls"));
    }
}
