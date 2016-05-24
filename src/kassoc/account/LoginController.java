package kassoc.account;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import kassoc.core.BaseController;

import java.io.IOException;
import java.net.URL;
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
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Pimp My Assoc - Dashboard");
        gotoScene(stage, "../dashboard.fxml");
    }

    /**
     * Sign up action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void signUpAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Pimp My Assoc - Sign up");
        gotoScene(stage, "signup.fxml");
    }
}
