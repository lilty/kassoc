package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kassoc.Kassoc;
import kassoc.model.Account;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Sign up controller.
 */
public class SignUpController implements javafx.fxml.Initializable {
    /**
     * The Back to login action btn.
     */
    public Button backToLoginActionBtn;
    /**
     * The Banner.
     */
    public ImageView banner;
    /**
     * The Confirm pwd input.
     */
    public PasswordField confirmPwdInput;
    /**
     * The Mail input.
     */
    public TextField mailInput;
    /**
     * The Name input.
     */
    public TextField nameInput;
    /**
     * The Pwd input.
     */
    public PasswordField pwdInput;
    /**
     * The Sign up btn.
     */
    public Button signUpBtn;
    /**
     * The Sign up pane.
     */
    public TitledPane signUpPane;
    /**
     * The Sdt n input.
     */
    public TextField stdIdInput;

    /**
     * Back to login action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void backToLoginAction(ActionEvent e) throws IOException {
        Kassoc.stage = Kassoc.View.login.showOn(Kassoc.stage);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        try {
            banner.setImage(new Image(getClass().getResource("/banner.png").openStream()));
            banner.setFocusTraversable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sign up action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void signUpAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        try {
            String mail = mailInput.getText();
            if (mail == null || mail.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The email input is a required field.").show();
                tx.rollback();
                return;
            }
            String name = pwdInput.getText();
            if (name == null || name.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The name input is a required field.").show();
                tx.rollback();
                return;
            }
            String stdId = stdIdInput.getText();
            if (stdId == null || stdId.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The student id input is a required field.").show();
                tx.rollback();
                return;
            }
            String pwd = pwdInput.getText();
            if (pwd == null || pwd.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The password input is a required field.").show();
                tx.rollback();
                return;
            }
            String confirmPwd = confirmPwdInput.getText();
            if (confirmPwd == null || confirmPwd.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please confirm your password.").show();
                tx.rollback();
                return;
            }
            Account a = new Account(Integer.parseInt(stdId), name, mail, pwd, Account.Type.ADMIN);
            Kassoc.account = a;
            Kassoc.getCurrentSession().save(a);
            tx.commit();
            Kassoc.stage = Kassoc.View.dashboard.showOn(Kassoc.stage);
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "This account already exist.").show();
        } catch (Exception ex) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR,
                "An error occurred while creating your account, please try again later."
            ).show();
        }
    }
}
