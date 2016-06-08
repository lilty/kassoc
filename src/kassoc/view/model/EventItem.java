package kassoc.view.model;

import javafx.scene.input.MouseButton;
import kassoc.model.EventEntity;

import java.io.IOException;

/**
 * The type EventItem item view model.
 */
public class EventItem extends Event {
    /**
     * Instantiates a new EventItem item view model.
     * @param eventEntity the actuality entity
     * @throws IOException the io exception
     */
    public EventItem(final EventEntity eventEntity) throws IOException {
        super("/kassoc/view/event-item.fxml", eventEntity);
    }

    @Override
    protected void fillView() {
        super.fillView();
        this.getView().setOnMouseClicked(mouseEvent->{
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        new Event(this.getModel()).show("Event");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
