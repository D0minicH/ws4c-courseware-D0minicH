package ch.fhnw.uieng.module05.mountainform_multilanguage_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.service.MountainService;
import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.service.serviceimpl.MountainServiceImpl;
import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MountainService service     = new MountainServiceImpl();
        Switzerland     switzerland = new Switzerland(service);
        Parent          rootPanel   = new RootPane(switzerland);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(switzerland.applicationTitleProperty());

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
