package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kassoc.Kassoc;
import kassoc.model.Account;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Login controller.
 */
public class LoginController implements javafx.fxml.Initializable {
    /**
     * The Banner.
     */
    public ImageView banner;
    /**
     * The Login btn.
     */
    public Button loginBtn;
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
        try {
            banner.setImage(new Image(getClass().getResource("/banner.png").openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Login action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void loginAction(ActionEvent e) throws IOException {
        Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        try {
            String mail = mailInput.getText();
            if (mail == null || mail.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please set your mail or your Unice id.").show();
                tx.rollback();
                return;
            }
            String pwd = pwdInput.getText();
            if (pwd == null || pwd.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please enter a password !").show();
                tx.rollback();
                return;
            }
            Account account = Account.findOneBy("mail", mailInput.getText(), Account.class);
            if (account == null) {
                try {
                    int uniceId = Integer.parseInt(mailInput.getText());
                    account = Account.findOneBy("uniceId", uniceId, Account.class);
                } catch (Throwable t) { account = null; }
            }
            boolean gotoScene = false;
            if (account == null) {
                new Alert(Alert.AlertType.ERROR, "User not found !").show();
            } else if (!Objects.equals(this.pwdInput.getText(), account.getPassword())) {
                new Alert(Alert.AlertType.ERROR, "Wrong password provided !").show();
            } else {
                Kassoc.account = account;
                Kassoc.View.accountEdit.setModel(account);
                gotoScene = true;
            }
            tx.commit();
            if (gotoScene) {
                Kassoc.stage = Kassoc.View.dashboard.showOn(Kassoc.stage);
            }
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
        Kassoc.stage = Kassoc.View.signup.showOn(Kassoc.stage);
    }
}
