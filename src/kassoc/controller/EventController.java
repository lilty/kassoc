package kassoc.controller;

import javafx.event.ActionEvent;
import kassoc.view.model.Event;
import kassoc.view.model.EventEdit;

import java.io.IOException;

/**
 * The type New actuality controller.
 */
public class EventController extends ViewModelController<Event> {
    /**
     * Edit action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void editAction(ActionEvent e) throws IOException {
        new EventEdit(this.getViewModel().getModel()).show("Edit");
    }
}
