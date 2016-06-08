package kassoc.view.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
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
                        Stage stage = new Stage();
                        stage.setTitle("New EventItem");
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/kassoc/view/event-edit"+"" +
                            ".fxml"))));
                        stage.sizeToScene();
                        stage.centerOnScreen();
                        stage.show();
                        stage.setMinWidth(stage.getWidth());
                        stage.setMinHeight(stage.getHeight());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
