import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import kassoc.Kassoc;

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
        Kassoc.View.init();
        primaryStage.getIcons().add(new Image("http://unice.fr/++theme++ThemeUNS/assets/ico/favicon.png"));
        Kassoc.stage = Kassoc.View.index.showOn(primaryStage, "Kassoc");
        Kassoc.stage.setOnCloseRequest(e->{
            Kassoc.getCurrentSession().close();
            Platform.exit();
            System.exit(0);
        });
    }
}
