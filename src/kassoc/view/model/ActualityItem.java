package kassoc.view.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import kassoc.model.ActualityEntity;

import java.io.IOException;

/**
 * The type ActualityItem item view model.
 */
public class ActualityItem extends Actuality {
    /**
     * Instantiates a new ActualityItem item view model.
     * @param actualityEntity the actuality entity
     * @throws IOException the io exception
     */
    public ActualityItem(final ActualityEntity actualityEntity) throws IOException {
        super("/kassoc/view/actuality-item.fxml", actualityEntity);
    }

    @Override
    protected void fillView() {
        super.fillView();
        this.getView().setOnMouseClicked(mouseEvent->{
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        Stage stage = new Stage();
                        stage.setTitle("New ActualityItem");
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(
                            "/kassoc/view/actuality-edit.fxml"))));
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
