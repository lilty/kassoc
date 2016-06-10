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

    public DatePicker birthdayInput;
    public TextField businessInput;
    public TextField levelInput;
    public TextField mailInput;
    public TextField lastNameInput;
    public Button okAluInput;
    public Button okBdeInput;
    public TextField firstNameInput;
    public Button okBdsInput;
    public TextField addressInput;
    public TextField numberInput;
    public Button academicRecordInput;
    public TextField sportPracticInput;
    public TextArea thematicInput;
    public CheckBox tournamentInput;

    public void okAction(ActionEvent e) throws IOException{
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try{
            String name = lastNameInput.getText();
            if(name == null || name.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "The name provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String firstName = firstNameInput.getText();
            if(firstName == null || firstName.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "The firstname provaded is not valid.").show();
                tx.rollback();
                return;
            }
            String address = addressInput.getText();
            if(address == null || address.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "The address provaded is not valid.").show();
                tx.rollback();
                return;
            }
        }
        catch(ConstraintViolationException t){
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

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

    public void okAluAction(ActionEvent actionEvent) throws Throwable{
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try{
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Kassoc - Dashboard");
            this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
        }
        catch(ConstraintViolationException t){
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }

    public void okBdsInput(ActionEvent actionEvent) throws IOException{
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try{
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Kassoc - Dashboard");
            this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
        }
        catch(ConstraintViolationException t){
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "You are already registered").show();
        }
    }
}
