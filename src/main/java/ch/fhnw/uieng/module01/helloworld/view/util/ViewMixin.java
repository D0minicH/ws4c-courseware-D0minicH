package ch.fhnw.uieng.module01.helloworld.view.util;

/**
 * @author Dieter Holz
 */
public interface ViewMixin {

    default void init() {
        initializeSelf();
        initializeParts();
        layoutParts();
        addEventHandlers();
        addValueChangedListeners();
        setupBindings();
    }

    default void initializeSelf() {
    }

    void initializeParts();

    void layoutParts();

    default void addEventHandlers() {
    }

    default void addValueChangedListeners() {
    }

    default void setupBindings() {
    }
}