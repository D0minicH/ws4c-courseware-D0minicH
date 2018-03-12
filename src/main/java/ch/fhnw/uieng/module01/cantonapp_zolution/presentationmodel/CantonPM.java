package ch.fhnw.uieng.module01.cantonapp_zolution.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module01.cantonapp_zolution.service.CantonDTO;

/**
 * Das PresentationModel stellt alles was dargestellt werden soll in Form von Properties zur Verfügung.
 *
 * Es ist Bestandteil des PresentationLayers und ist demzufolge an den Bedürfnissen der UIs ausgerichtet.
 *
 * Um moderne UIs umsetzen zu können haben sich observierbare und bindable Properties bewährt.
 *
 * Welche Informationen hier zusammengefasst sind, ist ebenfalls UI-orientiert. Insbesondere orientieren
 * sich PresentationModels nicht an der Datenbankstruktur.
 *
 * @author Dieter Holz
 */
public class CantonPM {
    private final StringProperty  kanton          = new SimpleStringProperty();
    private final StringProperty  kuerzel         = new SimpleStringProperty();
    private final LongProperty    kantonsnummer   = new SimpleLongProperty();
    private final DoubleProperty  standesstimme   = new SimpleDoubleProperty();
    private final IntegerProperty beitritt        = new SimpleIntegerProperty();
    private final StringProperty  hauptort        = new SimpleStringProperty();
    private final IntegerProperty einwohner       = new SimpleIntegerProperty();
    private final DoubleProperty  auslaender      = new SimpleDoubleProperty();
    private final DoubleProperty  flaeche         = new SimpleDoubleProperty();
    private final DoubleProperty  einwohnerdichte = new SimpleDoubleProperty();
    private final IntegerProperty gemeinden       = new SimpleIntegerProperty();
    private final StringProperty  amtssprache     = new SimpleStringProperty();

    public static CantonPM of(CantonDTO dto) {
        CantonPM pm = new CantonPM();
        pm.setKanton(dto.getKanton());
        pm.setKuerzel(dto.getKuerzel());
        pm.setKantonsnummer(dto.getKantonsnummer());
        pm.setStandesstimme(dto.getStandesstimme());
        pm.setBeitritt(dto.getBeitritt());
        pm.setHauptort(dto.getHauptort());
        pm.setEinwohner(dto.getEinwohner());
        pm.setAuslaender(dto.getAuslaender());
        pm.setFlaeche(dto.getFlaeche());
        pm.setEinwohnerdichte(dto.getEinwohnerdichte());
        pm.setGemeinden(dto.getGemeinden());
        pm.setAmtssprache(dto.getAmtssprache());

        return pm;
    }

    public String getKanton() {
        return kanton.get();
    }

    public StringProperty kantonProperty() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton.set(kanton);
    }

    public String getKuerzel() {
        return kuerzel.get();
    }

    public StringProperty kuerzelProperty() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel.set(kuerzel);
    }

    public long getKantonsnummer() {
        return kantonsnummer.get();
    }

    public LongProperty kantonsnummerProperty() {
        return kantonsnummer;
    }

    public void setKantonsnummer(long kantonsnummer) {
        this.kantonsnummer.set(kantonsnummer);
    }

    public double getStandesstimme() {
        return standesstimme.get();
    }

    public DoubleProperty standesstimmeProperty() {
        return standesstimme;
    }

    public void setStandesstimme(double standesstimme) {
        this.standesstimme.set(standesstimme);
    }

    public int getBeitritt() {
        return beitritt.get();
    }

    public IntegerProperty beitrittProperty() {
        return beitritt;
    }

    public void setBeitritt(int beitritt) {
        this.beitritt.set(beitritt);
    }

    public String getHauptort() {
        return hauptort.get();
    }

    public StringProperty hauptortProperty() {
        return hauptort;
    }

    public void setHauptort(String hauptort) {
        this.hauptort.set(hauptort);
    }

    public int getEinwohner() {
        return einwohner.get();
    }

    public IntegerProperty einwohnerProperty() {
        return einwohner;
    }

    public void setEinwohner(int einwohner) {
        this.einwohner.set(einwohner);
    }

    public double getAuslaender() {
        return auslaender.get();
    }

    public DoubleProperty auslaenderProperty() {
        return auslaender;
    }

    public void setAuslaender(double auslaender) {
        this.auslaender.set(auslaender);
    }

    public double getFlaeche() {
        return flaeche.get();
    }

    public DoubleProperty flaecheProperty() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
        this.flaeche.set(flaeche);
    }

    public double getEinwohnerdichte() {
        return einwohnerdichte.get();
    }

    public DoubleProperty einwohnerdichteProperty() {
        return einwohnerdichte;
    }

    public void setEinwohnerdichte(double einwohnerdichte) {
        this.einwohnerdichte.set(einwohnerdichte);
    }

    public int getGemeinden() {
        return gemeinden.get();
    }

    public IntegerProperty gemeindenProperty() {
        return gemeinden;
    }

    public void setGemeinden(int gemeinden) {
        this.gemeinden.set(gemeinden);
    }

    public String getAmtssprache() {
        return amtssprache.get();
    }

    public StringProperty amtsspracheProperty() {
        return amtssprache;
    }

    public void setAmtssprache(String amtssprache) {
        this.amtssprache.set(amtssprache);
    }
}
