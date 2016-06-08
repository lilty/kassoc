package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kassoc.Core;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;

/**
 * Class kassoc.controller.InscriptionOtherController
 * @author Bastien
 * @project kassoc
 */
public class InscriptionOtherController {
    public TextField addressInput;
    public TextField numberInput;
    public Button schoolFolderInput;

    public void signUpAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            try {
                int number = Integer.parseInt(numberInput.getText());
            }
            catch (Exception t) {
                new Alert(Alert.AlertType.ERROR, "The number provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String address = addressInput.getText();
            if (address == null || address.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The address input is a required field.").show();
                return;
            }


        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }
}
