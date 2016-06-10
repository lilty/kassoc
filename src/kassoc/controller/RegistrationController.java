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
public class RegistrationController {
    /**
     * The Academic record input.
     */
    public Button academicRecordInput;
    /**
     * The Address input.
     */
    public TextField addressInput;
    /**
     * The Birthday input.
     */
    public DatePicker birthdayInput;
    /**
     * The Business input.
     */
    public TextField businessInput;
    /**
     * The First name input.
     */
    public TextField firstNameInput;
    /**
     * The Last name input.
     */
    public TextField lastNameInput;
    /**
     * The Level input.
     */
    public TextField levelInput;
    /**
     * The Mail input.
     */
    public TextField mailInput;
    /**
     * The Number input.
     */
    public TextField numberInput;
    /**
     * The Ok alu input.
     */
    public Button okAluInput;
    /**
     * The Ok bde input.
     */
    public Button okBdeInput;
    /**
     * The Ok bds input.
     */
    public Button okBdsInput;
    /**
     * The Sport practic input.
     */
    public TextField sportPracticInput;
    /**
     * The Thematic input.
     */
    public TextArea thematicInput;
    /**
     * The Tournament input.
     */
    public CheckBox tournamentInput;

    /**
     * Academic record action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void academicRecordAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            try {
                int number = Integer.parseInt(numberInput.getText());
            } catch (Exception t) {
                new Alert(Alert.AlertType.ERROR, "The number provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String address = addressInput.getText();
            if (address == null || address.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The address input is a required field.").show();
                return;
            }
            Core.View.dashboard.showOn((Stage) ((Node) e.getSource()).getScene().getWindow());
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    /**
     * Ok action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void okAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            String name = lastNameInput.getText();
            if (name == null || name.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The name provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String firstName = firstNameInput.getText();
            if (firstName == null || firstName.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The firstname provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String address = addressInput.getText();
            if (address == null || address.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The address provaded is not valid.").show();
                tx.rollback();
                return;
            }
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    /**
     * Ok alu action.
     * @param e the e
     * @throws Throwable the throwable
     */
    public void okAluAction(ActionEvent e) throws Throwable {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            Core.View.dashboard.showOn((Stage) ((Node) e.getSource()).getScene().getWindow());
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    /**
     * Ok bds input.
     * @param e the e
     * @throws IOException the io exception
     */
    public void okBdsInput(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            Core.View.dashboard.showOn((Stage) ((Node) e.getSource()).getScene().getWindow());
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    /**
     * Ok general action.
     * @param event the event
     */
    public void okGeneralAction(ActionEvent event) {
    }
}
