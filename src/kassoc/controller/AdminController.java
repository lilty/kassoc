package kassoc.controller;

import javafx.event.ActionEvent;
import kassoc.model.EventEntity;
import kassoc.view.model.EventEdit;

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
        new EventEdit(new EventEntity()).show("New Event");
    }
}