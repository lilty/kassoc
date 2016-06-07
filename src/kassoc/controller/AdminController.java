package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Admin controller.
 */
public class AdminController extends BaseController {
    /**
     * Add actuality.
     * @param e the e
     * @throws IOException the io exception
     */
    public void addActuality(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("New Actuality");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/kassoc/view/new-actuality.fxml"))));
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
    }
}