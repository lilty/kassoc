package kassoc.controller;

import javafx.event.ActionEvent;

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
        this.popup("New EventItem", "/kassoc/view/event-edit.fxml");
    }
}