package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.util.PagingList;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */
public class Footer extends HBox implements ViewMixin {
    private final Switzerland rootPM;

    private Label  count;
    private Label  instances;
    private Slider pageSizeFactor;
    private Slider sleep;
    private Label  serviceCalls;

    public Footer(Switzerland rootPM) {
        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {
        count = new Label();
        instances = new Label();
        pageSizeFactor = new Slider(1, 5, 1);
        pageSizeFactor.setShowTickMarks(true);
        pageSizeFactor.setMajorTickUnit(1);
        pageSizeFactor.setMinorTickCount(0);
        pageSizeFactor.setShowTickLabels(true);
        pageSizeFactor.setSnapToTicks(true);

        sleep = new Slider(0, 1000, 200);
        sleep.setShowTickMarks(true);
        sleep.setShowTickLabels(true);
        sleep.setMajorTickUnit(200);
        sleep.setMinorTickCount(1);
        sleep.setSnapToTicks(true);

        serviceCalls = new Label();
    }

    @Override
    public void layoutParts() {
        setSpacing(5);
        getChildren().addAll(instances,
                             serviceCalls, pageSizeFactor, new Label("Faktor"),
                             sleep, new Label("Sleep"));
    }

    @Override
    public void setupBindings() {
        count.textProperty().bind(rootPM.communesCounterProperty().asString("%d Gemeinden"));

        PagingList communes = rootPM.getCommunes();
        instances.textProperty().bind(communes.cacheLevelProperty().asString("%d Commune Instances"));
        serviceCalls.textProperty().bind(communes.serviceCallsProperty().asString("%d Service Calls"));
        sleep.valueProperty().bindBidirectional(communes.sleepProperty());
        pageSizeFactor.valueProperty().bindBidirectional(communes.pageSizeFactorProperty());
    }
}
