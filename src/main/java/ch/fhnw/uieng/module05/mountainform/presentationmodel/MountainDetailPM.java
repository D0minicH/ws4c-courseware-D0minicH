package ch.fhnw.uieng.module05.mountainform.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform.service.MountainDetailDTO;

/**
 * @author Dieter Holz
 */
public class MountainDetailPM implements PMBase<MountainDetailDTO> {
    private static final String ELLIPSIS = "...";
    private static final String BASE_URL = "https://dieterholz.github.io/StaticResources/mountainpictures/";

    private final LongProperty   id              = new SimpleLongProperty();
    private final StringProperty name            = new SimpleStringProperty(ELLIPSIS);
    private final DoubleProperty height          = new SimpleDoubleProperty();
    private final StringProperty type            = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty region          = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty cantons         = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty range           = new SimpleStringProperty(ELLIPSIS);
    private final DoubleProperty isolation       = new SimpleDoubleProperty();
    private final StringProperty isolationPoint  = new SimpleStringProperty(ELLIPSIS);
    private final DoubleProperty prominence      = new SimpleDoubleProperty();
    private final StringProperty prominencePoint = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty caption         = new SimpleStringProperty(ELLIPSIS);
    private final StringProperty imageURL        = new SimpleStringProperty();



    private final StringProperty captionLabel = new SimpleStringProperty("Bildunterschrift");

    public static MountainDetailPM of(MountainDetailDTO dto) {
        MountainDetailPM pm = new MountainDetailPM();
        pm.apply(dto);

        return pm;
    }

    public void apply(MountainDetailDTO dto) {
        setId(dto.getId());
        setName(dto.getName());
        setHeight(dto.getHeight());
        setRegion(dto.getRegion());
        setType(dto.getType());
        setCantons(dto.getCantons());
        setRange(dto.getRange());
        setIsolation(dto.getIsolation());
        setIsolationPoint(dto.getIsolationPoint());
        setProminence(dto.getProminence());
        setProminencePoint(dto.getProminencePoint());
        setCaption(dto.getCaption());

        // ein erstes Beispiel, dass der Service nicht alles liefert, was man zur Darstellung braucht
        // die imageURL wird erst hier, im Switzerland, ergänzt
        // aber es bleibt dabei: das Switzerland liefert alles so, dass es möglichst direkt im UI dargestellt werden kann
        setImageURL(BASE_URL + dto.getId() + "-1.jpg");
    }

    // alle Getter und Setter

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    private void setId(long id) {
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

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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

    public String getCantons() {
        return cantons.get();
    }

    public StringProperty cantonsProperty() {
        return cantons;
    }

    public void setCantons(String cantons) {
        this.cantons.set(cantons);
    }

    public String getRange() {
        return range.get();
    }

    public StringProperty rangeProperty() {
        return range;
    }

    public void setRange(String range) {
        this.range.set(range);
    }

    public double getIsolation() {
        return isolation.get();
    }

    public DoubleProperty isolationProperty() {
        return isolation;
    }

    public void setIsolation(double isolation) {
        this.isolation.set(isolation);
    }

    public String getIsolationPoint() {
        return isolationPoint.get();
    }

    public StringProperty isolationPointProperty() {
        return isolationPoint;
    }

    public void setIsolationPoint(String isolationPoint) {
        this.isolationPoint.set(isolationPoint);
    }

    public double getProminence() {
        return prominence.get();
    }

    public DoubleProperty prominenceProperty() {
        return prominence;
    }

    public void setProminence(double prominence) {
        this.prominence.set(prominence);
    }

    public String getProminencePoint() {
        return prominencePoint.get();
    }

    public StringProperty prominencePointProperty() {
        return prominencePoint;
    }

    public void setProminencePoint(String prominencePoint) {
        this.prominencePoint.set(prominencePoint);
    }

    public String getCaption() {
        return caption.get();
    }

    public StringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
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

    public String getCaptionLabel() { return captionLabel.get(); }

    public StringProperty captionLabelProperty() { return captionLabel; }

    public void setCaptionLabel(String captionLabel) { this.captionLabel.set(captionLabel); }

    public void setLanguage(Language language) {
    }
}
