package kassoc.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Base controller.
 */
public class BaseController {
    /**
     * Goto scene.
     * @param stage the stage
     * @param file  the file
     * @throws IOException the io exception
     */
    protected void gotoScene(Stage stage, String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        stage.setScene(new Scene(root));
        stage.setMinWidth(0);
        stage.setMinHeight(0);
        stage.sizeToScene();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
    }
}
