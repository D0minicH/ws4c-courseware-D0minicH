package ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel;

import java.time.Duration;

import java.util.function.Function;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel.util.PagingList;
import ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel.util.TaskBatcher;
import ch.fhnw.uieng.module04.mountainapp_solution.service.MountainDTO;
import ch.fhnw.uieng.module04.mountainapp_solution.service.PagingService;

/**
 * @author Dieter Holz
 */
public class Switzerland {
    private static final Function<Integer, MountainPM> MOUNTAIN_PM_FACTORY = index -> new MountainPM();

    private final StringProperty applicationTitle = new SimpleStringProperty("Schweizer Berge");
    private final StringProperty filter           = new SimpleStringProperty();

    // damit das UI reagieren dann sobald die Liste neu gesetzt wird verwenden wir ein ObjectProperty
    private final ObjectProperty<PagingList<MountainPM, MountainDTO>> filteredMountains = new SimpleObjectProperty<>();

    private final TaskBatcher taskBatcher = new TaskBatcher(Duration.ofMillis(250));

    public Switzerland(PagingService<MountainDTO> service) {
        setFilteredMountains(new PagingList<>(service, index -> new MountainPM(), null));

        // immer wenn der Filter-String sich ändert, wird eine neue PagingList verwendet.
        filter.addListener((observable, oldValue, newValue) ->
                                   taskBatcher.batch(() -> setFilteredMountains(new PagingList<>(service,
                                                                                                 MOUNTAIN_PM_FACTORY,
                                                                                                 newValue))));
    }


    // alle Getter und Setter
    public String getFilter() {
        return filter.get();
    }

    public PagingList<MountainPM, MountainDTO> getFilteredMountains() {
        return filteredMountains.get();
    }

    public ObjectProperty<PagingList<MountainPM, MountainDTO>> filteredMountainsProperty() {
        return filteredMountains;
    }

    public void setFilteredMountains(PagingList<MountainPM, MountainDTO> filteredMountains) {
        this.filteredMountains.set(filteredMountains);
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter.set(filter);
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

}
