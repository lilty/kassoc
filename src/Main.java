import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import kassoc.Core;

import java.io.IOException;

/**
 * The type Main.
 */
public class Main extends Application {
    /**
     * Main.
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(final String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        Platform.setImplicitExit(true);
        Core.View.init();
        Core.View.index.showOn(primaryStage, "Kassoc");
    }
}
