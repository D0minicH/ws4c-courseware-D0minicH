package ch.fhnw.uieng.module05.mountainform_multilanguage_solution.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.ConstraintsBase;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;

import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel.MountainDetailPM;
import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.presentationmodel.Switzerland;
import ch.fhnw.uieng.module05.mountainform_multilanguage_solution.view.util.ViewMixin;

/**
 * @author Dieter Holz
 */

class MountainForm extends GridPane implements ViewMixin {

    private final Switzerland switzerland;

    private Label nameLabel;
    private Label heightLabel;
    private Label typeLabel;
    private Label regionLabel;
    private Label cantonsLabel;
    private Label rangeLabel;
    private Label isolationLabel;
    private Label isolationPointLabel;
    private Label prominenceLabel;
    private Label prominencePointLabel;
    private Label captionLabel;
    private Label imageURLLabel;

    private TextField nameField;
    private TextField heightField;
    private TextField typeField;
    private TextField regionField;
    private TextField cantonsField;
    private TextField rangeField;
    private TextField isolationField;
    private TextField isolationPointField;
    private TextField prominenceField;
    private TextField prominencePointField;
    private TextField captionField;
    private TextField imageURLField;

    MountainForm(Switzerland switzerland) {
        this.switzerland = switzerland;
        init();
    }

    @Override
    public void initializeSelf() {
        getStyleClass().add("form");
    }

    @Override
    public void initializeParts() {
        nameLabel            = new Label();
        heightLabel          = new Label();
        typeLabel            = new Label();
        regionLabel          = new Label();
        cantonsLabel         = new Label();
        rangeLabel           = new Label();
        isolationLabel       = new Label();
        isolationPointLabel  = new Label();
        prominenceLabel      = new Label();
        prominencePointLabel = new Label();
        captionLabel         = new Label();
        imageURLLabel        = new Label();

        nameField            = new TextField();
        heightField          = new TextField();
        typeField            = new TextField();
        regionField          = new TextField();
        cantonsField         = new TextField();
        rangeField           = new TextField();
        isolationField       = new TextField();
        isolationPointField  = new TextField();
        prominenceField      = new TextField();
        prominencePointField = new TextField();
        captionField         = new TextField();
        imageURLField        = new TextField();
    }

    @Override
    public void layoutParts() {
        ColumnConstraints firstLabelCol = new ColumnConstraints();
        firstLabelCol.setMaxWidth(ConstraintsBase.CONSTRAIN_TO_PREF);
        firstLabelCol.setMinWidth(30);

        ColumnConstraints firstFieldCol = new ColumnConstraints();
        firstFieldCol.setMinWidth(100);
        firstFieldCol.setFillWidth(true);
        firstFieldCol.setHgrow(Priority.ALWAYS);

        ColumnConstraints secondLabelCol = new ColumnConstraints();
        secondLabelCol.setMaxWidth(ConstraintsBase.CONSTRAIN_TO_PREF);
        secondLabelCol.setMinWidth(30);

        ColumnConstraints secondFieldCol = new ColumnConstraints();
        secondFieldCol.setMinWidth(100);
        secondFieldCol.setFillWidth(true);
        secondFieldCol.setHgrow(Priority.ALWAYS);

        getColumnConstraints().addAll(firstLabelCol, firstFieldCol, new ColumnConstraints(), secondLabelCol, secondFieldCol);

        Region spacer = new Region();
        spacer.getStyleClass().add("spacer");

        addRow(0, nameLabel          , nameField          , spacer      , heightLabel         , heightField);
        addRow(1, isolationLabel     , isolationField     , new Region(), prominenceLabel     , prominenceField);
        addRow(2, isolationPointLabel, isolationPointField, new Region(), prominencePointLabel, prominencePointField);
        addRow(3, typeLabel          , typeField          , new Region(), regionLabel         , regionField);
        addRow(4, cantonsLabel       , cantonsField       , new Region(), rangeLabel          , rangeField);

        add(imageURLLabel, 0, 5);
        add(imageURLField, 1, 5, 4, 1);
        add(captionLabel , 0, 6);
        add(captionField , 1, 6, 4, 1);
    }

    @Override
    public void setupBindings() {
        MountainDetailPM mountain = switzerland.getCurrentMountain();

        nameField.textProperty()           .bindBidirectional(mountain.nameProperty());
        heightField.textProperty()         .bindBidirectional(mountain.heightProperty(), new NumberStringConverter());
        typeField.textProperty()           .bindBidirectional(mountain.typeProperty());
        regionField.textProperty()         .bindBidirectional(mountain.regionProperty());
        cantonsField.textProperty()        .bindBidirectional(mountain.cantonsProperty());
        rangeField.textProperty()          .bindBidirectional(mountain.rangeProperty());
        isolationField.textProperty()      .bindBidirectional(mountain.isolationProperty(), new NumberStringConverter());
        isolationPointField.textProperty() .bindBidirectional(mountain.isolationPointProperty());
        prominenceField.textProperty()     .bindBidirectional(mountain.prominenceProperty(), new NumberStringConverter());
        prominencePointField.textProperty().bindBidirectional(mountain.prominencePointProperty());
        imageURLField.textProperty()       .bindBidirectional(mountain.imageURLProperty());
        captionField.textProperty()        .bindBidirectional(mountain.captionProperty());

        nameLabel.textProperty()           .bind(mountain.nameLabelProperty());
        heightLabel.textProperty()         .bind(mountain.heightLabelProperty());
        typeLabel.textProperty()           .bind(mountain.typeLabelProperty());
        regionLabel.textProperty()         .bind(mountain.regionLabelProperty());
        cantonsLabel.textProperty()        .bind(mountain.cantonsLabelProperty());
        rangeLabel.textProperty()          .bind(mountain.rangeLabelProperty());
        isolationLabel.textProperty()      .bind(mountain.isolationLabelProperty());
        isolationPointLabel.textProperty() .bind(mountain.isolationPointLabelProperty());
        prominenceLabel.textProperty()     .bind(mountain.prominenceLabelProperty());
        prominencePointLabel.textProperty().bind(mountain.prominenceLabelProperty());
        captionLabel.textProperty()        .bind(mountain.captionLabelProperty());
        imageURLLabel.textProperty()       .bind(mountain.imageURLLabelProperty());
    }
}
