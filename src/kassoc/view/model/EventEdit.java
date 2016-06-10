package kassoc.view.model;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kassoc.model.EventEntity;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class EventEdit extends Event {
    /**
     * Instantiates a new EventItem item view model.
     * @param eventEntity the actuality entity
     * @throws IOException the io exception
     */
    public EventEdit(final EventEntity eventEntity) throws IOException {
        super("/event-edit.fxml", eventEntity);
    }

    @Override
    public void bindView() {
        TextField photo = this.getChildById("photo");
        TextField title = this.getChildById("title");
        TextArea description = this.getChildById("description");
        DatePicker at = this.getChildById("at");
        ComboBox<String> org = this.getChildById("org");
        if (title != null) {
            title.setText(this.getModel().getTitle());
        }
        if (description != null) {
            description.setText(this.getModel().getDescription());
        }
        if (photo != null) {
            photo.setText(this.getModel().getImageUrl());
        }
        if (at != null) {
            at.setValue(this.getModel().getAt());
        }
        if (org != null) {
            org.setValue(this.getModel().getOrg());
        }
    }
}
