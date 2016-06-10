package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kassoc.Core;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;

/**
 * Class kassoc.controller.RegistrationController
 * @author Bastien
 * @project kassoc
 */
public class RegistrationController extends BaseController {
    public Accordion accordion;
    public TitledPane alumniceRegistrationPane;
    public TitledPane bdeRegistrationPane;
    public TitledPane bdsRegistrationPane;
    public TitledPane regentRegistrationPane;
    public TextField addressInput;
    public TextField numberInput;
    public Button academicRecordInput;

    public void academicRecordAction(ActionEvent e) throws IOException {
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
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setTitle("Kassoc - Dashboard");
            this.gotoScene(stage, "/kassoc/view/dashboard.fxml");


        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }
}
