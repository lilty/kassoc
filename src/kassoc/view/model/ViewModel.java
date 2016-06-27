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
        this.setModel(model);
    }

    /**
     * Instantiates a new View model.
     * @param location the location
     * @param model    the model
     * @throws IOException the io exception
     */
    public ViewModel(String location, TModel model) throws IOException {
        super(location);
        this.setModel(model);
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
        if (this.getView() != null) {
            this.bindView();
        }
    }

    @Override
    public void load() throws IOException {
        super.load();
        this.bindView();
    }

    /**
     * Show.
     * @param title the title
     */
    public Stage show(String title) {
        Stage ret = super.show(title);
        try {
            this.loader.<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        return ret;
    }

    /**
     * Show on.
     * @param stage the stage
     * @param title the title
     */
    public Stage showOn(Stage stage, String title) {
        Stage ret = super.showOn(stage, title);
        try {
            this.loader.<ViewModelController<ViewModel<TView, TModel>>>getController().setViewModel(this);
        } catch (Exception ignored) { }
        return ret;
    }
}