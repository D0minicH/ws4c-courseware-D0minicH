package ch.fhnw.uieng.module05.mountainform_attributebased_solution.view.util;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * @author Dieter Holz
 */
public interface ImageCache {
    Map<String, Image> cache = new HashMap<>();

    default Image getImage(String url){
        final String lookupURL = (url == null || url.isEmpty()) ?
                                 ImageCache.class.getResource("/images/noImg.jpg").toExternalForm() :
                                 url;

        return cache.computeIfAbsent(url, s -> new Image(lookupURL, true));
    }
}