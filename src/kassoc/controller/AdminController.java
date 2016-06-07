package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Admin controller.
 */
public class AdminController extends BaseController {
    /**
     * Add actuality.
     * @param e the e
     */
    public void addActuality(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Kassoc - Dashboard");
        this.gotoScene(stage, "/kassoc/view/new-actuality.fxml");
    }
}
