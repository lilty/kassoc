package kassoc.controller;

import javafx.event.ActionEvent;
import kassoc.model.Event;
import kassoc.view.model.EventEdit;

import java.io.IOException;

/**
 * The type Admin controller.
 */
public class AdminController {
    /**
     * Add actuality.
     * @param e the e
     * @throws IOException the io exception
     */
    public void addActuality(ActionEvent e) throws IOException {
        new EventEdit(new Event()).show("New Event");
    }
}