package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kassoc.Core;
import kassoc.model.ActualityEntity;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;

/**
 * Class kassoc.controller.NewActualityController
 * @author Bastien
 * @project kassoc
 */
public class NewActualityController extends BaseController {
    /**
     * The Date input.
     */
    public DatePicker dateInput;
    /**
     * The Description input.
     */
    public TextArea descriptionInput;
    /**
     * The New pane.
     */
    public TitledPane newPane;
    /**
     * The Organisation input.
     */
    public TextField organisationInput;
    /**
     * The Photo input.
     */
    public TextField photoInput;
    /**
     * The Title input.
     */
    public TextField titleInput;

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

    /**
     * Save action.
     * @param e the e
     */
    public void saveAction(ActionEvent e) {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();

        try{
            LocalDate date = dateInput.getValue();
            if (date == null) {
                new Alert(Alert.AlertType.ERROR, "The date input is a required field.").show();
                return;
            }
            Time time = new Time(date.getYear(), date.getMonthValue(), date.getDayOfMonth());

            String description = descriptionInput.getText();
            if (description == null || description.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The description input is a required field.").show();
                return;
            }

            String organisation = organisationInput.getText();
            if (organisation == null || organisation.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The organisation input is a required field.").show();
                return;
            }

            String photo = photoInput.getText();
            if (photo == null || photo.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The photo input is a required field.").show();
                return;
            }

            String title = titleInput.getText();
            if (title == null || title.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The title input is a required field.").show();
                return;
            }
            ActualityEntity a = new ActualityEntity(organisation, photo, title, description, time);
            Core.getCurrentSession().save(a);
            tx.commit();
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setTitle("Kassoc - Dashboard");
            this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
        }
        catch (ConstraintViolationException t){
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "This actuality already exist.").show();
        } catch (Exception ex) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR,
                "An error occurred while creating your acuality, please try again."
            ).show();
        }
    }
}
