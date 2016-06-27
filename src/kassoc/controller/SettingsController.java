package kassoc.controller;

import javafx.scene.control.Tab;
import kassoc.Kassoc;

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
        tab.setContent(Kassoc.View.accountEdit.getView());
    }
}
