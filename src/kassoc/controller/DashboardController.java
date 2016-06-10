package kassoc.controller;

import javafx.scene.control.TabPane;
import kassoc.Core;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Dashboard controller.
 */
public class DashboardController implements javafx.fxml.Initializable {
    /**
     * The Tab pane.
     */
    public TabPane tabPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getTabs().add(Core.View.eventTab.getView());
        tabPane.getTabs().add(Core.View.settings.getView());
        tabPane.getTabs().add(Core.View.admin.getView());
        tabPane.getTabs().add(Core.View.registration.getView());
    }
}