package ch.fhnw.uieng.module05.mountainform_attributebased.presentationmodel.util;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * @author Dieter Holz
 */
public class LongAttribute extends Attribute<LongProperty, Long, LongAttribute> {
    public LongAttribute(SimpleLongProperty value, SimpleLongProperty persistentValue) {
        super(value, persistentValue);

        userInputProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setValid(true);
                setValidationMessage("OK");
                setValue(Long.valueOf(newValue));
            } catch (NumberFormatException e) {
                setValid(false);
                setValidationMessage("Not a Long");
            }
        });

        valueProperty().addListener((observable, oldValue, newValue) -> setUserInput(String.format("%d", newValue.longValue())));
    }
}
