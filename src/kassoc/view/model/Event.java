package kassoc.view.model;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import kassoc.ScrollPane2;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class Event extends ViewModel<AnchorPane, kassoc.model.Event> {
    /**
     * Instantiates a new EventItem item view model.
     * @param event the actuality entity
     * @throws IOException the io exception
     */
    public Event(final kassoc.model.Event event) throws IOException {
        super("/event.fxml", event);
    }

    /**
     * Instantiates a new Event.
     * @param location the location
     * @param event    the actuality entity
     * @throws IOException the io exception
     */
    public Event(final String location, final kassoc.model.Event event) throws IOException {
        super(location, event);
    }

    @Override
    protected void bindView() {
        if (this.getModel() != null) {
            ImageView photo = this.getChildById("photo");
            Label title = this.getChildById("title");
            Text description = this.getChildById("description");
            ScrollPane2 scroll = this.getChildById("scroll");
            DatePicker at = this.getChildById("at");
            if (scroll != null) {
                scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            }
            if (photo != null) {
                photo.imageProperty().bind(this.getModel().imageProperty());
            }
            if (title != null) {
                title.textProperty().bind(this.getModel().titleProperty());
            }
            if (description != null) {
                description.textProperty().bind(this.getModel().descriptionProperty());
            }
            if (at != null) {
                at.valueProperty().bind(this.getModel().atProperty());
            }
        }
    }
}
