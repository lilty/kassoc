package kassoc.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;

import java.io.IOException;
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
        try {
            tabPane.getTabs().add(FXMLLoader.load(getClass().getResource("/kassoc/view/event-tab.fxml")));
            tabPane.getTabs().add(FXMLLoader.load(getClass().getResource("/kassoc/view/settings.fxml")));
            tabPane.getTabs().add(FXMLLoader.load(getClass().getResource("/kassoc/view/admin.fxml")));
            tabPane.getTabs().add(FXMLLoader.load(getClass().getResource("/kassoc/view/registration.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}