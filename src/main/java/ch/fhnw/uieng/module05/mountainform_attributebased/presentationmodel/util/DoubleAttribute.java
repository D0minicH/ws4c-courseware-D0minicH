package ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.util;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author Dieter Holz
 */
public class DoubleAttribute extends Attribute<DoubleProperty, Double, DoubleAttribute> {
    public DoubleAttribute(SimpleDoubleProperty value, SimpleDoubleProperty persistentValue) {
        super(value, persistentValue);

        userInputProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setValid(true);
                setValidationMessage("OK");
                setValue(Double.valueOf(newValue));
            } catch (NumberFormatException e) {
                setValid(false);
                setValidationMessage("Not a Double");
            }
        });

        valueProperty().addListener((observable, oldValue, newValue) -> setUserInput(String.valueOf(newValue)));
    }

}
