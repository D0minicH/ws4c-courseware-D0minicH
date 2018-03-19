package ch.fhnw.uieng.module02.cantonfiltered_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module02.cantonfiltered_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module02.cantonfiltered_solution.service.CantonService;
import ch.fhnw.uieng.module02.cantonfiltered_solution.service.serviceimpl.CantonServiceFileBased;
import ch.fhnw.uieng.module02.cantonfiltered_solution.view.RootPane;

/**
 * @author Dieter Holz
 */
public class CantonAppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //alle Services die gebraucht werden
        CantonService service = new CantonServiceFileBased();

        // Zugang zu allen PresentationModels. Damit die erstellt werden können müssen alle Services bekannt sein.
        Switzerland rootModel = new Switzerland(service);

        // Das gesamte UI. Muss wissen was es darstellen soll also wird das rootModel übergeben.
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
