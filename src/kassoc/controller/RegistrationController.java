package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import kassoc.Kassoc;
import org.hibernate.exception.ConstraintViolationException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class kassoc.controller.RegistrationController
 * @author Bastien
 * @project kassoc
 */
public class RegistrationController implements Initializable {
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
        org.hibernate.Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        try {
            try {
                int number = Integer.parseInt(numberInput.getText());
            } catch (Exception t) {
                new Alert(Alert.AlertType.ERROR, "The number provided is not valid.").show();
                tx.rollback();
                return;
            }
            String address = addressInput.getText();
            if (address == null || address.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The address input is a required field.").show();
                return;
            }
            Kassoc.stage = Kassoc.View.dashboard.showOn(Kassoc.stage);
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        academicRecordInput.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(((Node) e.getSource()).getScene().getWindow());
            System.out.println(file);
        });
    }

    /**
     * Ok action.
     * @param e the e
     * @throws IOException the io exception
     */
    public void okAction(ActionEvent e) throws IOException {
        org.hibernate.Transaction tx = Kassoc.getCurrentSession().beginTransaction();
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
        org.hibernate.Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        try {
            Kassoc.stage = Kassoc.View.dashboard.showOn(Kassoc.stage);
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
        org.hibernate.Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        try {
            Kassoc.stage = Kassoc.View.dashboard.showOn(Kassoc.stage);
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
