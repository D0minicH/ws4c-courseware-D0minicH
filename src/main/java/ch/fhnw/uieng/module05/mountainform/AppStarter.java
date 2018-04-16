package ch.fhnw.uieng.module05.mountainform;

import ch.fhnw.uieng.module05.mountainform.presentationmodel.Switzerland;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module05.mountainform.service.MountainService;
import ch.fhnw.uieng.module05.mountainform.service.serviceimpl.MountainServiceImpl;
import ch.fhnw.uieng.module05.mountainform.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        MountainService service   = new MountainServiceImpl();
        Switzerland rootSwitzerland = new Switzerland(service);
        Parent          rootPanel = new RootPane(rootSwitzerland);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(rootSwitzerland.applicationTitleProperty());

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
