package ch.fhnw.uieng.module02.cantonfiltered.view;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import ch.fhnw.uieng.module02.cantonfiltered.presentationmodel.CantonPM;

/**
 * @author Dieter Holz
 */
class KantonTableCell extends TableCell<CantonPM, String> {
    private static final Map<String, Image> WAPPEN = new HashMap<>();
    private static final Insets             INSETS = new Insets(1, 8, 1, 5);

    private final ImageView imageView;

    KantonTableCell() {
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(18);
        imageView.setSmooth(true);

        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        setAlignment(Pos.CENTER);
        setPadding(INSETS);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        setGraphic(null);
        if (item != null && !empty) {
            Image img = WAPPEN.computeIfAbsent(item,
                                               s -> new Image(getClass().getResource("/wappen_klein/" + item + ".png").toExternalForm(),
                                                              true));

            imageView.setImage(img);

            setGraphic(imageView);
            setTooltip(new Tooltip(item));
        }
    }
}
