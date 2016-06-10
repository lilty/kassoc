package kassoc.view;

import javafx.css.Styleable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kassoc.FXUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * The type View.
 */
public class View<TView extends Styleable> {
    private TView view;
    private FXMLLoader loader;
    private HashMap<String, Node> childes;

    /**
     * Instantiates a new View model.
     * @param location the location
     * @throws IOException the io exception
     */
    public View(URL location) throws IOException {
        this.loader = new FXMLLoader(location);
        this.view = this.loader.load();
    }

    /**
     * Instantiates a new View model.
     * @param location the location
     * @throws IOException the io exception
     */
    public View(String location) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(location));
        this.view = this.loader.load();
    }

    /**
     * Gets child by id.
     * @param <T> the type parameter
     * @param id  the id
     * @return the child by id
     */
    public <T> T getChildById(String id) {
        if (this.childes == null) {
            this.childes = new HashMap<>();
        }
        if (!this.childes.containsKey(id)) {
            if (this.getView() instanceof Node) {
                this.childes.put(id, FXUtils.getChildByID((Node) this.getView(), id));
            } else {
                this.childes.put(id, null);
            }
        }
        return (T) this.childes.get(id);
    }

    /**
     * Gets loader.
     * @return the loader
     */
    public FXMLLoader getLoader() {
        return loader;
    }

    /**
     * Sets loader.
     * @param loader the loader
     */
    public void setLoader(final FXMLLoader loader) {
        this.loader = loader;
    }

    /**
     * Gets view.
     * @return the view
     */
    public TView getView() {
        return view;
    }

    /**
     * Sets view.
     * @param view the view
     */
    public void setView(final TView view) {
        this.view = view;
    }

    /**
     * Show.
     */
    public void show() {
        this.show(null);
    }

    /**
     * Show.
     * @param title the title
     */
    public void show(String title) {
        if (this.getView() instanceof Parent) {
            Stage stage = new Stage();
            if (title != null) {
                stage.setTitle(title);
            }
            stage.setScene(new Scene((Parent) this.getView()));
            stage.sizeToScene();
            stage.centerOnScreen();
            stage.show();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }

    /**
     * Show on.
     * @param stage the stage
     */
    public void showOn(Stage stage) {
        this.showOn(stage, null);
    }

    /**
     * Show on.
     * @param stage the stage
     * @param title the title
     */
    public void showOn(Stage stage, String title) {
        if (this.getView() instanceof Parent) {
            if (title != null) {
                stage.setTitle(title);
            }
            stage.setScene(new Scene((Parent) this.getView()));
            stage.setMinWidth(0);
            stage.setMinHeight(0);
            stage.sizeToScene();
            stage.centerOnScreen();
            stage.show();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
}
