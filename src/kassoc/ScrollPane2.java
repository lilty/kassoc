package kassoc;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Skin;

/**
 * The type Scroll pane 2.
 */
public class ScrollPane2 extends ScrollPane {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new ScrollPaneSkin2(this);
    }
}