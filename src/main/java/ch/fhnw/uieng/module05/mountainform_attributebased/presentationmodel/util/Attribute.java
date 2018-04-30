package ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.util;

import java.util.HashMap;
import java.util.Map;

import ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.Language;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Dieter Holz
 */
public abstract class Attribute<P extends Property, E, A extends Attribute> {
    private Map<Language, String> labels = new HashMap<>();

    private final P value;
    private final P persistentValue;

    private final StringProperty  userInput         = new SimpleStringProperty();
    private final StringProperty  label             = new SimpleStringProperty();
    private final BooleanProperty mandatory         = new SimpleBooleanProperty(false);
    private final BooleanProperty readOnly          = new SimpleBooleanProperty(false);
    private final BooleanProperty valid             = new SimpleBooleanProperty(true);
    private final StringProperty  validationMessage = new SimpleStringProperty();
    private final BooleanProperty dirty             = new SimpleBooleanProperty(false);

    protected Attribute(P valueProperty, P persistentValueProperty) {
        value = valueProperty;
        persistentValue = persistentValueProperty;
        dirtyProperty().bind(Bindings.createBooleanBinding(() -> !persistentValueProperty().getValue().equals(valueProperty().getValue()),
                                                           valueProperty(), persistentValueProperty()));

    }

    public static DoubleAttribute of(double value) {
        return new DoubleAttribute(new SimpleDoubleProperty(value), new SimpleDoubleProperty(value));
    }

    public static LongAttribute of(long value) {
        return new LongAttribute(new SimpleLongProperty(value), new SimpleLongProperty(value));
    }

    public static StringAttribute of(String value) {
        return new StringAttribute(new SimpleStringProperty(value), new SimpleStringProperty(value));
    }

    public A label(Language lang, String label) {
        labels.put(lang, label);

        return (A) this;
    }

    public A mandatory(boolean mandatory) {
        setMandatory(mandatory);

        return (A) this;
    }

    public A readOnly(boolean readOnly) {
        setReadOnly(readOnly);

        return (A) this;
    }

    public void setLanguage(Language lang) {
        setLabel(labels.getOrDefault(lang, "some Label"));
    }

    public void rebase() {
       persistentValue.setValue(value.getValue());
    }

    public String getLabel() {
        return label.get();
    }

    public StringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public E getValue() {
        return (E) value.getValue();
    }

    public P valueProperty() {
        return value;
    }

    public void setValue(E value) {
        this.value.setValue(value);
    }

    public E getPersistentValue() {
        return (E) persistentValue.getValue();
    }

    public P persistentValueProperty() {
        return persistentValue;
    }

    public void setPersistentValue(E persistentValue) {
        this.persistentValue.setValue(persistentValue);
    }

    public boolean isMandatory() {
        return mandatory.get();
    }

    public BooleanProperty mandatoryProperty() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory.set(mandatory);
    }

    public boolean isValid() {
        return valid.get();
    }

    public BooleanProperty validProperty() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid.set(valid);
    }

    public String getValidationMessage() {
        return validationMessage.get();
    }

    public StringProperty validationMessageProperty() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage.set(validationMessage);
    }

    public boolean isDirty() {
        return dirty.get();
    }

    public BooleanProperty dirtyProperty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty.set(dirty);
    }

    public boolean isReadOnly() {
        return readOnly.get();
    }

    public BooleanProperty readOnlyProperty() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly.set(readOnly);
    }

    public String getUserInput() {
        return userInput.get();
    }

    public StringProperty userInputProperty() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput.set(userInput);
    }
}
