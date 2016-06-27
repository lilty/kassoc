package kassoc.view;

import javafx.css.Styleable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import kassoc.FXUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * The type View.
 * @param <TView> the type parameter
 */
public class View<TView extends Styleable> {
    /**
     * The Loader.
     */
    protected FXMLLoader loader;
    /**
     * The Location.
     */
    protected URL location;
    /**
     * The Scene.
     */
    protected Scene scene;
    /**
     * The View.
     */
    protected TView view;
    private HashMap<String, Node> childes;

    /**
     * Instantiates a new View model.
     * @param location the location
     * @throws IOException the io exception
     */
    public View(URL location) throws IOException {
        this.location = location;
        this.loader = new FXMLLoader(location);
        this.load();
    }

    /**
     * Instantiates a new View model.
     * @param location the location
     * @throws IOException the io exception
     */
    public View(String location) throws IOException {
        this.location = getClass().getResource(location);
        this.loader = new FXMLLoader(this.location);
        this.load();
    }

    /**
     * Fill.
     */
    protected void bindView() { }

    /**
     * Build graphic t view.
     * @return the t view
     */
    public TView buildGraphic() {
        this.bindView();
        return this.getView();
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
     * Gets view.
     * @return the view
     */
    public TView getView() {
        if (this.scene != null) {
            return (TView) this.scene.getRoot();
        }
        return this.view;
    }

    /**
     * Load.
     * @throws IOException the io exception
     */
    public void load() throws IOException {
        this.loader.setRoot(null);
        this.loader.setController(null);
        this.view = this.loader.load();
        if (this.view instanceof Parent) {
            this.scene = new Scene((Parent) this.view);
        }
    }

    /**
     * Show.
     * @return the stage
     */
    public Stage show() {
        return this.show(null);
    }

    /**
     * Show.
     * @param title the title
     * @return the stage
     */
    public Stage show(String title) {
        if (this.getView() instanceof Parent) {
            Stage s = new Stage();
            s.getIcons().add(new Image("http://unice.fr/++theme++ThemeUNS/assets/ico/favicon.png"));
            return this.showOn(s, title);
        }
        return null;
    }

    /**
     * Show on.
     * @param stage the stage
     * @return the stage
     */
    public Stage showOn(Stage stage) {
        return this.showOn(stage, null);
    }

    /**
     * Show on.
     * @param stage the stage
     * @param title the title
     * @return the stage
     */
    public Stage showOn(Stage stage, String title) {
        if (this.scene != null) {
            if (title != null) {
                stage.setTitle(title);
            }
            stage.getIcons().add(new Image("http://unice.fr/++theme++ThemeUNS/assets/ico/favicon.png"));
            stage.requestFocus();
            stage.setScene(this.scene);
            stage.setResizable(true);
            stage.show();
            stage.sizeToScene();
            stage.setResizable(false);
        }
        return stage;
    }
}
