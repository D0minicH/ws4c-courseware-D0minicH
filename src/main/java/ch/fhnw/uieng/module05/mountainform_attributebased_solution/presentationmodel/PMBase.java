package ch.fhnw.uieng.module05.mountainform_attributebased_solution.presentationmodel;

import javafx.beans.property.BooleanProperty;


/**
 * @author Dieter Holz
 */
public interface PMBase<DTO> {

    void apply(DTO dto);

    void setLanguage(Language lang);

    void rebase();

    BooleanProperty dirtyProperty();

    BooleanProperty validProperty();

    void revert();

    DTO toDTO();
}

