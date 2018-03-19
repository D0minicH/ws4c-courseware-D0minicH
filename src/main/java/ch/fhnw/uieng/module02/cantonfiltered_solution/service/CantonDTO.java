package ch.fhnw.uieng.module02.cantonfiltered_solution.service;

import java.util.Locale;
import java.util.Scanner;

/**
 * Data Transfer Object für Canton
 *
 * Typisch für DTOs:
 *  - die Felder sind primitive Datentypen
 *  - DTOs können nicht nach der Initialisierung nicht verändert werden (immutable Objects)
 *  - Die Lebensdauer eines DTOs ist kurz. Im PresentationLayer werden mit den Daten des DTOs die PresentationModels befüllt.
 *    Danach werden die DTOs nicht mehr benötigt.
 *
 * @author Dieter Holz
 */

public class CantonDTO {
    private static final Locale CH = new Locale("de", "CH");

    private final String kanton;
    private final String kuerzel;
    private final long   kantonsnummer;
    private final double standesstimme;
    private final int    beitritt;
    private final String hauptort;
    private final int    einwohner;
    private final double auslaender;
    private final double flaeche;
    private final double einwohnerdichte;
    private final int    gemeinden;
    private final String amtssprache;

    public CantonDTO(String... args) {
        kanton          = args[0];
        kuerzel         = args[1];
        kantonsnummer   = toLong(args[2]);
        standesstimme   = toDouble(args[3]);
        beitritt        = toInt(args[4]);
        hauptort        = args[5];
        einwohner       = toInt(args[6]);
        auslaender      = toDouble(args[7]);
        flaeche         = toDouble(args[8]);
        einwohnerdichte = toDouble(args[9]);
        gemeinden       = toInt(args[10]);
        amtssprache     = args[11];
    }

    public String getKanton() {
        return kanton;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public long getKantonsnummer() {
        return kantonsnummer;
    }

    public double getStandesstimme() {
        return standesstimme;
    }

    public int getBeitritt() {
        return beitritt;
    }

    public String getHauptort() {
        return hauptort;
    }

    public int getEinwohner() {
        return einwohner;
    }

    public double getAuslaender() {
        return auslaender;
    }

    public double getFlaeche() {
        return flaeche;
    }

    public double getEinwohnerdichte() {
        return einwohnerdichte;
    }

    public int getGemeinden() {
        return gemeinden;
    }

    public String getAmtssprache() {
        return amtssprache;
    }

    private int toInt(String str) {
        Scanner s = new Scanner(str);
        s.useLocale(CH);
        int result = s.nextInt();
        s.close();
        return result;
    }

    private long toLong(String str) {
        Scanner s = new Scanner(str);
        s.useLocale(CH);
        long result = s.nextLong();
        s.close();

        return result;
    }

    private double toDouble(String str) {
        Scanner s = new Scanner(str);
        s.useLocale(CH);
        double result = s.nextDouble();
        s.close();
        return result;
    }

}
