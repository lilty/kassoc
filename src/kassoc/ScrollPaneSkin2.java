package kassoc;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.skin.ScrollPaneSkin;
import javafx.scene.layout.StackPane;

import java.lang.reflect.Field;

/**
 * The type Scroll pane skin 2.
 */
class ScrollPaneSkin2 extends ScrollPaneSkin {
    private static Field viewRectField;

    static {
        try {
            viewRectField = ScrollPaneSkin.class.getDeclaredField("viewRect");
            viewRectField.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private StackPane viewRect;

    /**
     * Instantiates a new Scroll pane skin 2.
     * @param scrollpane the scrollpane
     */
    public ScrollPaneSkin2(final ScrollPane scrollpane) {
        super(scrollpane);
        try {
            this.viewRect = (StackPane) viewRectField.get(this);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
        this.viewRect.setCache(false);
    }
}