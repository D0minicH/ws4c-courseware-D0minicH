package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step2.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Dieter Holz
 */

public class CommuneDTO {
    private final String    cantonCode;
    private final long      destrictID;
    private final long      id;
    private final String    nameOfficial;
    private final String    nameShort;
    private final String    destrictName;
    private final String    cantonName;
    private final LocalDate lastModification;

    public CommuneDTO(String... args) {
        cantonCode       = args[0];
        destrictID       = Integer.parseInt(args[1]);
        id               = Integer.parseInt(args[2]);
        nameOfficial     = args[3];
        nameShort        = args[4];
        destrictName     = args[5];
        cantonName       = args[6];
        lastModification = LocalDate.parse(args[7], DateTimeFormatter.ofPattern("d/M/y"));
    }

    public String getCantonCode() {
        return cantonCode;
    }

    public long getDestrictID() {
        return destrictID;
    }

    public long getId() {
        return id;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getDestrictName() {
        return destrictName;
    }

    public String getCantonName() {
        return cantonName;
    }

    public LocalDate getLastModification() {
        return lastModification;
    }
}
