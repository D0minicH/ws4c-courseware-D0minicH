package ch.fhnw.uieng.module01.cantonapp_step1;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module01.cantonapp_step1.presentationmodel.Switzerland;
import ch.fhnw.uieng.module01.cantonapp_step1.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Switzerland rootModel = new Switzerland();
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
