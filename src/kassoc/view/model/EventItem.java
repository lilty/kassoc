package kassoc.view.model;

import javafx.scene.input.MouseButton;
import kassoc.model.Event;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class EventItem extends kassoc.view.model.Event {
    /**
     * Instantiates a new EventItem item view model.
     * @param event the actuality entity
     * @throws IOException the io exception
     */
    public EventItem(final Event event) throws IOException {
        super("/event-item.fxml", event);
    }

    @Override
    protected void bindView() {
        super.bindView();
        this.getView().setOnMouseClicked(mouseEvent->{
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        if (this.getModel() != null) {
                            new kassoc.view.model.Event(this.getModel()).show("Event");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
