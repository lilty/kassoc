package kassoc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Index controller.
 */
public class IndexController implements javafx.fxml.Initializable {
    /**
     * The Content.
     */
    @FXML
    public StackPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/kassoc/view/login.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}