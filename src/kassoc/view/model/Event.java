package kassoc.view.model;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import kassoc.ScrollPane2;
import kassoc.model.EventEntity;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class Event extends ViewModel<AnchorPane, EventEntity> {
    /**
     * Instantiates a new EventItem item view model.
     * @param eventEntity the actuality entity
     * @throws IOException the io exception
     */
    public Event(final EventEntity eventEntity) throws IOException {
        super("/event.fxml", eventEntity);
    }

    /**
     * Instantiates a new Event.
     * @param location        the location
     * @param eventEntity the actuality entity
     * @throws IOException the io exception
     */
    public Event(final String location, final EventEntity eventEntity) throws IOException {
        super(location, eventEntity);
    }

    @Override
    protected void bindView() {
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
