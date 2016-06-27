package kassoc.view.model;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import kassoc.Kassoc;
import kassoc.model.Account;
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
                            kassoc.view.model.Event e = new kassoc.view.model.Event(this.getModel());
                            if (Kassoc.account.getType() != Account.Type.ADMIN) {
                                Button b = e.getChildById("editBtn");
                                if (b != null) {
                                    b.setVisible(false);
                                }
                            }
                            e.show("Event");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
