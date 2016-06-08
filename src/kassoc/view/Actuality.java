package kassoc.view;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import kassoc.ScrollPane2;
import kassoc.model.ActualityEntity;

import java.io.IOException;

/**
 * The type ActualityItem item view model.
 */
public class Actuality extends ViewModel<ActualityEntity> {
    /**
     * Instantiates a new ActualityItem item view model.
     * @param actualityEntity the actuality entity
     * @throws IOException the io exception
     */
    public Actuality(final ActualityEntity actualityEntity) throws IOException {
        super("/kassoc/view/actuality.fxml", actualityEntity);
    }

    /**
     * Instantiates a new Actuality.
     * @param location        the location
     * @param actualityEntity the actuality entity
     * @throws IOException the io exception
     */
    public Actuality(final String location, final ActualityEntity actualityEntity) throws IOException {
        super(location, actualityEntity);
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
