package ch.fhnw.uieng.module05.mountainform_attributebased;

import ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.Switzerland;
import ch.fhnw.uieng.module05.mountainform_attributebased.view.RootPane;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module05.mountainform_attributebased.service.MountainService;
import ch.fhnw.uieng.module05.mountainform_attributebased.service.serviceimpl.MountainServiceImpl;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MountainService service     = new MountainServiceImpl();
        Switzerland switzerland = new Switzerland(service);
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
