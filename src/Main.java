import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kassoc.Core;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {
    public static void main(final String[] args) throws Exception {
        final Session session = Core.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Application.launch(args);
        } finally {
            tx.commit();
        }
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("kassoc/index.fxml"));
        primaryStage.setTitle("Kassoc - Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }
}
