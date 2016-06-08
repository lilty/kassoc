package kassoc.view.model;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import kassoc.ScrollPane2;
import kassoc.model.EventEntity;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class Event extends ViewModel<EventEntity> {
    /**
     * Instantiates a new EventItem item view model.
     * @param eventEntity the actuality entity
     * @throws IOException the io exception
     */
    public Event(final EventEntity eventEntity) throws IOException {
        super("/kassoc/view/event.fxml", eventEntity);
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
    protected void fillView() {
        try {
            ImageView image = this.getChildById("image");
            if (image != null) {
                image.setImage(new Image(this.getModel().getPhoto()));
            }
        } catch (Exception ignored) { }
        ImageView image = this.getChildById("image");
        Label title = this.getChildById("title");
        Text content = this.getChildById("content");
        ScrollPane2 scroll = this.getChildById("scroll");
        if (scroll != null) {
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }
        if (image != null) {
            try {
                image.setImage(new Image(this.getModel().getPhoto()));
            } catch (Exception ignored) { }
        }
        if (title != null) {
            title.setText(this.getModel().getTitle()+" "+this.getModel().getAt().toString());
        }
        if (content != null) {
            content.setText(this.getModel().getDescription());
        }
    }
}
