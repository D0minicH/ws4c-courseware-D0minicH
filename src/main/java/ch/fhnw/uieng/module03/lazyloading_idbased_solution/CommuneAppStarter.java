package ch.fhnw.uieng.module03.lazyloading_idbased_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.uieng.module03.lazyloading_idbased_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module03.lazyloading_idbased_solution.service.CommuneService;
import ch.fhnw.uieng.module03.lazyloading_idbased_solution.service.serviceimpl.CommuneServiceFileBased;
import ch.fhnw.uieng.module03.lazyloading_idbased_solution.view.RootPane;

/**
 * @author Dieter Holz
 */
public class CommuneAppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //alle Services die gebraucht werden
        CommuneService service = new CommuneServiceFileBased();

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
