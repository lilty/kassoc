package kassoc.view.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kassoc.FXUtils;
import kassoc.controller.ViewModelController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * The type View model.
 * @param <TModel> the type parameter
 */
public abstract class ViewModel<TModel> {
    private Parent view;
    private FXMLLoader loader;
    private TModel model;
    private HashMap<String, Node> childes;

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(URL location, TModel model) throws IOException {
        this.loader = new FXMLLoader(location);
        this.view = this.loader.load();
        this.model = model;
        this.fillView();
    }

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(String location, TModel model) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(location));
        this.view = this.loader.load();
        this.model = model;
        this.fillView();
    }

    /**
     * Instantiates a new View model.
     * @param view  the view
     * @param model the model
     */
    public ViewModel(final Parent view, final TModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Instantiates a new View model.
     */
    public ViewModel() {
    }

    /**
     * Fill.
     */
    protected abstract void fillView();

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
            this.childes.put(id, FXUtils.getChildByID(this.getView(), id));
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
     * Gets model.
     * @return the model
     */
    public TModel getModel() {
        return model;
    }

    /**
     * Sets model.
     * @param model the model
     */
    public void setModel(final TModel model) {
        this.model = model;
    }

    /**
     * Gets view.
     * @return the view
     */
    public Parent getView() {
        return view;
    }

    /**
     * Sets view.
     * @param view the view
     */
    public void setView(final Parent view) {
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
     * @param title   the title
     */
    public void show(String title) {
        try {
            this.loader.<ViewModelController<ViewModel<TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        Stage stage = new Stage();
        if (title != null) {
            stage.setTitle(title);
        }
        stage.setScene(new Scene(this.getView()));
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
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
        try {
            this.loader.<ViewModelController<ViewModel<TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        if (title != null) {
            stage.setTitle(title);
        }
        stage.setScene(new Scene(this.getView()));
        stage.setMinWidth(0);
        stage.setMinHeight(0);
        stage.sizeToScene();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.centerOnScreen();
    }
}