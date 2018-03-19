package ch.fhnw.uieng.module03.lazyloading_lazylistbased.presentationmodel;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.CommuneDTO;

/**
 * @author Dieter Holz
 */
public class CommunePM {
    private final StringProperty            cantonCode       = new SimpleStringProperty();
    private final LongProperty              destrictID       = new SimpleLongProperty();
    private final LongProperty              id               = new SimpleLongProperty();
    private final StringProperty            nameOfficial     = new SimpleStringProperty();
    private final StringProperty            nameShort        = new SimpleStringProperty();
    private final StringProperty            destrictName     = new SimpleStringProperty();
    private final StringProperty            cantonName       = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> lastModification = new SimpleObjectProperty<>();

    public static CommunePM of(CommuneDTO dto) {
        CommunePM pm = new CommunePM();
        pm.setCantonCode(dto.getCantonCode());
        pm.setDestrictID(dto.getDestrictID());
        pm.setId(dto.getId());
        pm.setNameOfficial(dto.getNameOfficial());
        pm.setNameShort(dto.getNameShort());
        pm.setDestrictName(dto.getDestrictName());
        pm.setCantonName(dto.getCantonName());
        pm.setLastModification(dto.getLastModification());

        return pm;
    }

    public String getCantonCode() {
        return cantonCode.get();
    }

    public StringProperty cantonCodeProperty() {
        return cantonCode;
    }

    public void setCantonCode(String cantonCode) {
        this.cantonCode.set(cantonCode);
    }

    public long getDestrictID() {
        return destrictID.get();
    }

    public LongProperty destrictIDProperty() {
        return destrictID;
    }

    public void setDestrictID(long destrictID) {
        this.destrictID.set(destrictID);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getNameOfficial() {
        return nameOfficial.get();
    }

    public StringProperty nameOfficialProperty() {
        return nameOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial.set(nameOfficial);
    }

    public String getNameShort() {
        return nameShort.get();
    }

    public StringProperty nameShortProperty() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort.set(nameShort);
    }

    public String getDestrictName() {
        return destrictName.get();
    }

    public StringProperty destrictNameProperty() {
        return destrictName;
    }

    public void setDestrictName(String destrictName) {
        this.destrictName.set(destrictName);
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

    public LocalDate getLastModification() {
        return lastModification.get();
    }

    public ObjectProperty<LocalDate> lastModificationProperty() {
        return lastModification;
    }

    public void setLastModification(LocalDate lastModification) {
        this.lastModification.set(lastModification);
    }
}
