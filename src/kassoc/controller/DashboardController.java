package kassoc.controller;

import javafx.scene.control.TabPane;
import kassoc.Kassoc;

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
        tabPane.getTabs().add(Kassoc.View.eventTab.getView());
        tabPane.getTabs().add(Kassoc.View.settingsTab.getView());
        tabPane.getTabs().add(Kassoc.View.adminTab.getView());
        tabPane.getTabs().add(Kassoc.View.registrationTab.getView());
    }
}