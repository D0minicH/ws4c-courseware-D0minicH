package ch.fhnw.uieng.module01.cantonapp_step2b;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module01.cantonapp_step2b.presentationmodel.Switzerland;
import ch.fhnw.uieng.module01.cantonapp_step2b.service.CantonService;
import ch.fhnw.uieng.module01.cantonapp_step2b.service.serviceimpl.CantonServiceFileBased;
import ch.fhnw.uieng.module01.cantonapp_step2b.view.RootPane;

/**
 * @author Dieter Holz
 */
public class CantonAppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        //alle Services die gebraucht werden
        CantonService service = new CantonServiceFileBased();

        // Zugang zu allen PresentationModels. Damit die erstellt werden können müssen alle Services bekannt sein.
        Switzerland rootModel = new Switzerland(service);

        // Das gesamte UI, muss wissen was es darstellen soll also wird das rootModel übergeben.
        Parent rootPanel = new RootPane(rootModel);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(rootModel.applicationTitleProperty());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
