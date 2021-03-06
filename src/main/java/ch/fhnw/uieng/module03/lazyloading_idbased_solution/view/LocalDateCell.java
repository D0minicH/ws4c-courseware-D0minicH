package ch.fhnw.uieng.module03.lazyloading_idbased_solution.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;

/**
 * @author Dieter Holz
 */
public class LocalDateCell extends TableCell<Long, LocalDate> {
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
