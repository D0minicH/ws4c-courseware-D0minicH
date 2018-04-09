package ch.fhnw.uieng.module04.mountainapp_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module04.mountainapp_solution.service.MountainDTO;
import ch.fhnw.uieng.module04.mountainapp_solution.service.PagingService;
import ch.fhnw.uieng.module04.mountainapp_solution.service.serviceimpl.MountainServiceFileBased;
import ch.fhnw.uieng.module04.mountainapp_solution.view.RootPane;

/**
 * @author Dieter Holz
 */
public class MountainAppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //alle Services, die gebraucht werden
        PagingService<MountainDTO> service = new MountainServiceFileBased();

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
