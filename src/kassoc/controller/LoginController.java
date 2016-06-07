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
            String mail = mailInput.getText();
            if (mail == null || mail.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please set your mail or your Unice id.").show();
                return;
            }
            String pwd = pwdInput.getText();
            if (pwd == null || pwd.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please enter a password !").show();
                return;
            }
            AccountEntity account = AccountEntity.findOneBy("mail", mailInput.getText(), AccountEntity.class);
            if (account == null) {
                try {
                    int uniceId = Integer.parseInt(mailInput.getText());
                    account = AccountEntity.findOneBy("uniceId", uniceId, AccountEntity.class);
                } catch (Throwable t) { account = null; }
            }
            if (account == null) {
                new Alert(Alert.AlertType.ERROR, "User not found !").show();
            } else if (!Objects.equals(this.pwdInput.getText(), account.getPassword())) {
                new Alert(Alert.AlertType.ERROR, "Wrong password provided !").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Welcome "+account.getName()+" !").show();
                Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage1.setTitle("Kassoc - Dashboard");
                this.gotoScene(stage1, "/kassoc/view/dashboard.fxml");
            }
            tx.commit();
        } catch (Throwable t) {
            tx.rollback();
            Alert a = new Alert(Alert.AlertType.ERROR, t.getMessage());
            a.setHeaderText(t.getClass().getSimpleName());
            a.showAndWait();
        }
    }

    /**
     * Sign up action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void signUpAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Kassoc - Sign up");
        this.gotoScene(stage, "/kassoc/view/signup.fxml");
    }
}
