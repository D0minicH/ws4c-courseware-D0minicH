package ch.fhnw.uieng.module01.cantonapp.presentationmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Canton {

    private final StringProperty  cantonName          = new SimpleStringProperty();
    private final StringProperty  cantonAbbreviation  = new SimpleStringProperty();
    private final IntegerProperty population          = new SimpleIntegerProperty();

    public Canton(String name, String abbreviation, int population) {
        setCantonName(name);
        setCantonAbbreviation(abbreviation);
        setPopulation(population);
    }

    public String getCantonName() {
        return cantonName.get();
    }

    public StringProperty cantonNameProperty() {
        return cantonName;
    }

    public void setCantonName(String cantonName) {
        this.cantonName.set(cantonName);
    }

    public String getCantonAbbreviation() {
        return cantonAbbreviation.get();
    }

    public StringProperty cantonAbbreviationProperty() {
        return cantonAbbreviation;
    }

    public void setCantonAbbreviation(String cantonAbbreviation) {
        this.cantonAbbreviation.set(cantonAbbreviation);
    }

    public int getPopulation() {
        return population.get();
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public void setPopulation(int population) {
        this.population.set(population);
    }
}
