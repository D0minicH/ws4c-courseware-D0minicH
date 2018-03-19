package ch.fhnw.uieng.module03.lazyloading_idbased.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.TableCell;

import ch.fhnw.uieng.module03.lazyloading_idbased.presentationmodel.CommunePM;

/**
 * @author Dieter Holz
 */
public class LocalDateCell extends TableCell<CommunePM, LocalDate> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");

    @Override
    protected void updateItem(LocalDate item, boolean empty) {
        setText("");
        setGraphic(null);
        if (!empty) {
            setText(DATE_FORMATTER.format(item));
        }
    }
}
