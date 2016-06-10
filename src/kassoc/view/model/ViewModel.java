package kassoc.view.model;

import javafx.scene.Parent;
import javafx.stage.Stage;
import kassoc.controller.ViewModelController;
import kassoc.view.View;

import java.io.IOException;
import java.net.URL;

/**
 * The type View model.
 * @param <TModel> the type parameter
 */
public abstract class ViewModel<TView extends Parent, TModel> extends View<TView> {
    private TModel model;

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(URL location, TModel model) throws IOException {
        super(location);
        this.model = model;
        this.bindView();
    }

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(String location, TModel model) throws IOException {
        super(location);
        this.model = model;
        this.bindView();
    }

    /**
     * Fill.
     */
    protected abstract void bindView();

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
     * Show.
     * @param title the title
     */
    public void show(String title) {
        try {
            this.getLoader().<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        super.show(title);
    }

    /**
     * Show on.
     * @param stage the stage
     * @param title the title
     */
    public void showOn(Stage stage, String title) {
        try {
            this.getLoader().<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        super.showOn(stage, title);
    }
}