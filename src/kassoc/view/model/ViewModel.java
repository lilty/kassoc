package kassoc.view.model;

import javafx.scene.Parent;
import javafx.stage.Stage;
import kassoc.controller.ViewModelController;
import kassoc.view.View;

import java.io.IOException;
import java.net.URL;

/**
 * The type View model.
 * @param <TView>  the type parameter
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
        if (this.view != null) {
            this.bindView();
        }
    }

    /**
     * Show.
     * @param title the title
     */
    public Stage show(String title) {
        try {
            this.loader.<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        return super.show(title);
    }

    /**
     * Show on.
     * @param stage the stage
     * @param title the title
     */
    public Stage showOn(Stage stage, String title) {
        try {
            this.loader.<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        return super.showOn(stage, title);
    }
}