package kassoc.view;

import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import kassoc.Kassoc;
import kassoc.model.Account;

import java.io.IOException;

/**
 * The type Dashboard.
 */
public class Dashboard extends View<TabPane> {
    private boolean isLoaded = false;

    /**
     * Instantiates a new Dashboard.
     * @throws IOException the io exception
     */
    public Dashboard() throws IOException {
        super("/dashboard.fxml");
    }

    @Override
    public Stage showOn(final Stage stage, final String title) {
        this.getView().getTabs().clear();
        this.getView().getTabs().add(Kassoc.View.eventTab.buildGraphic());
        this.getView().getTabs().add(Kassoc.View.settingsTab.buildGraphic());
        this.getView().getTabs().add(Kassoc.View.registrationTab.buildGraphic());
        if (Kassoc.account.getType() == Account.Type.ADMIN) {
            this.getView().getTabs().add(Kassoc.View.adminTab.buildGraphic());
        }
        return super.showOn(stage, title);
    }
}
