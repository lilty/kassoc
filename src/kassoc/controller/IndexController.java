package kassoc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import kassoc.Core;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Index controller.
 */
public class IndexController implements javafx.fxml.Initializable {
    /**
     * The Content.
     */
    @FXML
    public StackPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            final Session session = Core.getCurrentSession();
            Transaction tx = session.beginTransaction();
            tx.commit();
            content.getChildren().clear();
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/kassoc/view/login.fxml")));
        } catch (JDBCException e) {
            Alert a = new Alert(
                Alert.AlertType.ERROR,
                "You have to be connected to an Unice network to use this app !"
            );
            a.setHeaderText(e.getClass().getSimpleName());
            a.showAndWait();
            System.exit(0);
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
            a.setHeaderText(e.getClass().getSimpleName());
            a.showAndWait();
            System.exit(0);
        }
    }
}