package kassoc.view.model;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import kassoc.Kassoc;
import kassoc.model.Account;

import java.io.IOException;

/**
 * The type Account edit.
 */
public class AccountEdit extends ViewModel<AnchorPane, Account> {
    /**
     * Instantiates a new Account edit.
     * @throws IOException the io exception
     */
    public AccountEdit() throws IOException {
        super("/account-edit.fxml", Kassoc.account);
    }

    @Override
    protected void bindView() {
        TextField mailInput = this.getChildById("mailInput");
        TextField nameInput = this.getChildById("nameInput");
        TextField stdIdInput = this.getChildById("stdIdInput");
        PasswordField pwdInput = this.getChildById("pwdInput");
        PasswordField confirmPwdInput = this.getChildById("confirmPwdInput");
        if (mailInput != null) {
            mailInput.setText(this.getModel().getMail());
        }
        if (nameInput != null) {
            nameInput.setText(this.getModel().getName());
        }
        if (stdIdInput != null) {
            stdIdInput.setText(String.valueOf(this.getModel().getUniceId()));
        }
        if (pwdInput != null) {
            pwdInput.setText(this.getModel().getPassword());
        }
        if (confirmPwdInput != null) {
            confirmPwdInput.setText(this.getModel().getPassword());
        }
    }
}
