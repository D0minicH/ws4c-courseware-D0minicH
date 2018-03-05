package ch.fhnw.uieng.module01.cantonapp_step2a;

import ch.fhnw.uieng.module01.cantonapp_step2a.service.CantonService;
import ch.fhnw.uieng.module01.cantonapp_step2a.service.CantonServiceFileBased;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module01.cantonapp_step2a.presentationmodel.Switzerland;
import ch.fhnw.uieng.module01.cantonapp_step2a.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        CantonService service = new CantonServiceFileBased();

        Switzerland rootModel = new Switzerland(service);
        Parent      rootPanel = new RootPane(rootModel);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(rootModel.applicationTitleProperty());

        primaryStage.setScene(scene);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
