package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kassoc.Core;
import kassoc.model.AccountEntity;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Login controller.
 */
public class LoginController extends BaseController implements javafx.fxml.Initializable {
    /**
     * The Login btn.
     */
    public Button loginBtn;
    /**
     * The Login pane.
     */
    public TitledPane loginPane;
    /**
     * The Mail input.
     */
    public TextField mailInput;
    /**
     * The Pwd input.
     */
    public PasswordField pwdInput;
    /**
     * The Sign up btn.
     */
    public Button signUpBtn;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        loginPane.setCollapsible(false);
    }

    /**
     * Login action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void loginAction(ActionEvent e) throws IOException {
        Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            AccountEntity account;
            try {
                account = AccountEntity.findOneBy("uniceId", Integer.parseInt(mailInput.getText()));
            } catch (Throwable t) {
                account = null;
            }
            if (account == null) {
                account = AccountEntity.findOneBy("mail", mailInput.getText());
            }
            if (account == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("User not found !");
                a.show();
            } else {
                if (!Objects.equals(pwdInput.getText(), account.getPassword())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Wrong password provided !");
                    a.show();
                } else {
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setTitle("Kassoc - Dashboard");
                    gotoScene(stage, "/kassoc/view/dashboard.fxml");
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Welcome "+account.getName()+" !");
                    a.show();
                }
            }
        } finally {
            tx.commit();
        }
    }

    /**
     * Sign up action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void signUpAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Kassoc - Sign up");
        gotoScene(stage, "/kassoc/view/signup.fxml");
    }
}
