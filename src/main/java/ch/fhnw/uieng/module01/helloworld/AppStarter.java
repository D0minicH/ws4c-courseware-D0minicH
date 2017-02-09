package ch.fhnw.uieng.module01.helloworld;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module01.helloworld.presentationmodel.DemoPM;
import ch.fhnw.uieng.module01.helloworld.view.RootPane;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DemoPM model     = new DemoPM();
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
