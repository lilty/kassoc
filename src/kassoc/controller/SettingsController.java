package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kassoc.Core;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Settings controller.
 */
public class SettingsController extends BaseController implements javafx.fxml.Initializable {
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
     * The Std id input.
     */
    public TextField stdIdInput;

    /**
     * Back action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void backAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Kassoc - Dashboard");
        this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        if (Core.account != null) {
            mailInput.setText(Core.account.getMail());
            nameInput.setText(Core.account.getName());
            pwdInput.setText(Core.account.getPassword());
            confirmPwdInput.setText(Core.account.getPassword());
            stdIdInput.setText(String.valueOf(Core.account.getUniceId()));
        }
    }

    /**
     * Save action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void saveAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
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
            if (!pwd.equals(confirmPwd)) {
                new Alert(Alert.AlertType.ERROR, "Both provided password are not equals.").show();
                tx.rollback();
                return;
            }
            Core.account.setMail(mail);
            Core.account.setPassword(pwd);
            Core.account.setUniceId(Integer.parseInt(stdId));
            Core.account.setName(name);
            Core.getCurrentSession().update(Core.account);
            tx.commit();
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "Already used mail or unice id.").show();
            return;
        } catch (Exception ex) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR,
                "An error occurred while editing your account, please try again later."
            ).show();
        }
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Kassoc - Dashboard");
        this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
    }
}
