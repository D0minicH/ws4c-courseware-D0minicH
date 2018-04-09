package ch.fhnw.uieng.module04.mountainapp_solution.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module04.mountainapp_solution.service.MountainDTO;

/**
 * @author Dieter Holz
 */
public class MountainPM implements PMBase<MountainDTO> {
    private static final String ELLIPSIS = "...";
    private static final String BASE_URL = "https://dieterholz.github.io/StaticResources/mountainpictures/";

    private final LongProperty   id       = new SimpleLongProperty();
    private final StringProperty name     = new SimpleStringProperty(ELLIPSIS);
    private final DoubleProperty height   = new SimpleDoubleProperty();
    private final StringProperty region   = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty imageURL = new SimpleStringProperty();

    public static MountainPM of(MountainDTO dto) {
        MountainPM pm = new MountainPM();
        pm.apply(dto);

        return pm;
    }

    public void apply(MountainDTO dto) {
        setId(dto.getId());
        setName(dto.getName());
        setHeight(dto.getHeight());
        setRegion(dto.getRegion());

        // ein erstes Beispiel, dass der Service nicht alles liefert, was man zur Darstellung braucht
        // die imageURL wird erst hier, im PM, ergänzt
        // aber es bleibt dabei: das PM liefert alles so, dass es möglichst direkt im UI dargestellt werden kann
        setImageURL(BASE_URL + dto.getId() + "-1.jpg");
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getImageURL() {
        return imageURL.get();
    }

    public StringProperty imageURLProperty() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL.set(imageURL);
    }
}
