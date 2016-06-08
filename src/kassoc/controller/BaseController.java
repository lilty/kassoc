package kassoc.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Base controller.
 */
class BaseController {
    /**
     * Goto scene.
     * @param stage the stage
     * @param file  the file
     * @throws IOException the io exception
     */
    void gotoScene(Stage stage, String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        stage.setScene(new Scene(root));
        stage.setMinWidth(0);
        stage.setMinHeight(0);
        stage.sizeToScene();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.centerOnScreen();
    }

    /**
     * Popup.
     * @param title the title
     * @param file  the file
     */
    void popup(String title, String file) {
        try {
            this.popup(title, (Parent) FXMLLoader.load(getClass().getResource(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Popup.
     * @param title the title
     * @param view  the view
     */
    void popup(String title, Parent view) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(view));
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
    }
}