package kassoc.controller;

import kassoc.view.model.ViewModel;

/**
 * The type View model controller.
 * @param <T> the type parameter
 */
public abstract class ViewModelController<T extends ViewModel> {
    /**
     * The View model.
     */
    protected T viewModel;

    /**
     * Instantiates a new View model controller.
     */
    protected ViewModelController() { }

    /**
     * Gets view model.
     * @return the view model
     */
    public T getViewModel() {
        return viewModel;
    }

    /**
     * Sets view model.
     * @param viewModel the view model
     */
    public void setViewModel(final T viewModel) {
        this.viewModel = viewModel;
    }
}
