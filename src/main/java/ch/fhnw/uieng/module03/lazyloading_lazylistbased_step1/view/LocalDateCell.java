package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.presentationmodel.CommunePM;

/**
 * @author Dieter Holz
 */
public class LocalDateCell extends TableCell<CommunePM, LocalDate> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");

    public LocalDateCell() {
        setGraphic(null);
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    protected void updateItem(LocalDate item, boolean empty) {
        setText(null);

        if (item != null && !empty) {
            setText(DATE_FORMATTER.format(item));
        }
    }
}
