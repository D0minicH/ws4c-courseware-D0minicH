package ch.fhnw.uieng.module01.cantonapp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module01.cantonapp.presentationmodel.PM;
import ch.fhnw.uieng.module01.cantonapp.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        PM     model     = new PM();
        Parent rootPanel = new RootPane(model);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(model.applicationTitleProperty());

        primaryStage.setScene(scene);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
