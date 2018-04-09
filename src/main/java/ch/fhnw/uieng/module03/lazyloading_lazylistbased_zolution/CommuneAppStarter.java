package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service.PagingService;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service.serviceimpl.CommuneServiceFileBased;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.view.RootPane;

/**
 * @author Dieter Holz
 */
public class CommuneAppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //alle Services, die gebraucht werden
        PagingService<CommuneDTO> service = new CommuneServiceFileBased();

        // Zugang zu allen PresentationModels. Damit die erstellt werden können müssen alle Services bekannt sein.
        Switzerland rootPM = new Switzerland(service);

        // Das gesamte UI, muss wissen was es darstellen soll also wird das rootPM übergeben.
        Parent rootPanel = new RootPane(rootPM);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(rootPM.applicationTitleProperty());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
