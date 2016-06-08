package kassoc.view.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import kassoc.FXUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * The type View model.
 * @param <TModel> the type parameter
 */
public abstract class ViewModel<TModel> {
    private Node view;
    private TModel model;
    private HashMap<String, Node> childes;

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(URL location, TModel model) throws IOException {
        this.view = FXMLLoader.load(location);
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
        this.view = FXMLLoader.load(getClass().getResource(location));
        this.model = model;
        this.fillView();
    }

    /**
     * Instantiates a new View model.
     * @param view  the view
     * @param model the model
     */
    public ViewModel(final Node view, final TModel model) {
        this.view = view;
        this.model = model;
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
    public Node getView() {
        return view;
    }

    /**
     * Sets view.
     * @param view the view
     */
    public void setView(final Node view) {
        this.view = view;
    }
}