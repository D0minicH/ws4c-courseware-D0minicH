package ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.service.MountainDetailDTO;

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
    private final StringProperty imageURL        = new SimpleStringProperty(MountainDetailPM.class.getResource("/images/noImg.jpg").toExternalForm());

    private final StringProperty idLabel              = new SimpleStringProperty();
    private final StringProperty nameLabel            = new SimpleStringProperty();
    private final StringProperty heightLabel          = new SimpleStringProperty();
    private final StringProperty typeLabel            = new SimpleStringProperty();
    private final StringProperty regionLabel          = new SimpleStringProperty();
    private final StringProperty cantonsLabel         = new SimpleStringProperty();
    private final StringProperty rangeLabel           = new SimpleStringProperty();
    private final StringProperty isolationLabel       = new SimpleStringProperty();
    private final StringProperty isolationPointLabel  = new SimpleStringProperty();
    private final StringProperty prominenceLabel      = new SimpleStringProperty();
    private final StringProperty prominencePointLabel = new SimpleStringProperty();
    private final StringProperty captionLabel         = new SimpleStringProperty();
    private final StringProperty imageURLLabel        = new SimpleStringProperty();


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
        setImageURL(BASE_URL + dto.getId() + "-1.jpg");
    }

    public void setLanguage(Language language) {
        if(language.equals(Language.DE)){
            setLabelsToGerman();
        }
        else {
            setLabelsToEnglish();
        }
    }

    private void setLabelsToGerman(){
        setIdLabel("ID");
        setNameLabel("Name");
        setHeightLabel("H\u00f6he (m)");
        setTypeLabel("Typ");
        setRegionLabel("Region");
        setCantonsLabel("Kantone");
        setRangeLabel("Gebiet");
        setIsolationLabel("Dominanz");
        setIsolationPointLabel("km bis");
        setProminenceLabel("Schartenh\u00f6he");
        setProminencePointLabel("m bis");
        setCaptionLabel("Bildunterschrift");
        setImageURLLabel("Bild URL");
    }

    private void setLabelsToEnglish(){
        setIdLabel("ID");
        setNameLabel("Name");
        setHeightLabel("Height (m)");
        setTypeLabel("Type");
        setRegionLabel("Region");
        setCantonsLabel("Cantons");
        setRangeLabel("Range");
        setIsolationLabel("Isolation");
        setIsolationPointLabel("Isolation Point");
        setProminenceLabel("Prominence");
        setProminencePointLabel("Prominence Point");
        setCaptionLabel("Caption");
        setImageURLLabel("Image URL");
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

    public String getIdLabel() {
        return idLabel.get();
    }

    public StringProperty idLabelProperty() {
        return idLabel;
    }

    public void setIdLabel(String idLabel) {
        this.idLabel.set(idLabel);
    }

    public String getNameLabel() {
        return nameLabel.get();
    }

    public StringProperty nameLabelProperty() {
        return nameLabel;
    }

    public void setNameLabel(String nameLabel) {
        this.nameLabel.set(nameLabel);
    }

    public String getHeightLabel() {
        return heightLabel.get();
    }

    public StringProperty heightLabelProperty() {
        return heightLabel;
    }

    public void setHeightLabel(String heightLabel) {
        this.heightLabel.set(heightLabel);
    }

    public String getTypeLabel() {
        return typeLabel.get();
    }

    public StringProperty typeLabelProperty() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel.set(typeLabel);
    }

    public String getRegionLabel() {
        return regionLabel.get();
    }

    public StringProperty regionLabelProperty() {
        return regionLabel;
    }

    public void setRegionLabel(String regionLabel) {
        this.regionLabel.set(regionLabel);
    }

    public String getCantonsLabel() {
        return cantonsLabel.get();
    }

    public StringProperty cantonsLabelProperty() {
        return cantonsLabel;
    }

    public void setCantonsLabel(String cantonsLabel) {
        this.cantonsLabel.set(cantonsLabel);
    }

    public String getRangeLabel() {
        return rangeLabel.get();
    }

    public StringProperty rangeLabelProperty() {
        return rangeLabel;
    }

    public void setRangeLabel(String rangeLabel) {
        this.rangeLabel.set(rangeLabel);
    }

    public String getIsolationLabel() {
        return isolationLabel.get();
    }

    public StringProperty isolationLabelProperty() {
        return isolationLabel;
    }

    public void setIsolationLabel(String isolationLabel) {
        this.isolationLabel.set(isolationLabel);
    }

    public String getIsolationPointLabel() {
        return isolationPointLabel.get();
    }

    public StringProperty isolationPointLabelProperty() {
        return isolationPointLabel;
    }

    public void setIsolationPointLabel(String isolationPointLabel) {
        this.isolationPointLabel.set(isolationPointLabel);
    }

    public String getProminenceLabel() {
        return prominenceLabel.get();
    }

    public StringProperty prominenceLabelProperty() {
        return prominenceLabel;
    }

    public void setProminenceLabel(String prominenceLabel) {
        this.prominenceLabel.set(prominenceLabel);
    }

    public String getProminencePointLabel() {
        return prominencePointLabel.get();
    }

    public StringProperty prominencePointLabelProperty() {
        return prominencePointLabel;
    }

    public void setProminencePointLabel(String prominencePointLabel) {
        this.prominencePointLabel.set(prominencePointLabel);
    }

    public String getCaptionLabel() {
        return captionLabel.get();
    }

    public StringProperty captionLabelProperty() {
        return captionLabel;
    }

    public void setCaptionLabel(String captionLabel) {
        this.captionLabel.set(captionLabel);
    }

    public String getImageURLLabel() {
        return imageURLLabel.get();
    }

    public StringProperty imageURLLabelProperty() {
        return imageURLLabel;
    }

    public void setImageURLLabel(String imageURLLabel) {
        this.imageURLLabel.set(imageURLLabel);
    }

}
