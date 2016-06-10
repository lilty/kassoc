package kassoc.controller;

import javafx.scene.control.Tab;
import kassoc.Core;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Settings controller.
 */
public class SettingsController implements javafx.fxml.Initializable {
    /**
     * The Tab.
     */
    public Tab tab;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        tab.setContent(Core.View.accountEdit.getView());
    }
}
