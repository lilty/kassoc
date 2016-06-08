package kassoc.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kassoc.Core;
import kassoc.view.model.EventEdit;
import org.hibernate.exception.ConstraintViolationException;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * The type New actuality controller.
 */
public class EventEditController extends ViewModelController<EventEdit> implements Initializable {
    /**
     * The Date input.
     */
    public DatePicker at;
    /**
     * The Description input.
     */
    public TextArea description;
    /**
     * The Organisation input.
     */
    public ComboBox<String> org;
    /**
     * The New pane.
     */
    public TitledPane pane;
    /**
     * The Photo input.
     */
    public TextField photo;
    /**
     * The Title input.
     */
    public TextField title;
    /**
     * The View.
     */
    public AnchorPane view;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        if (org != null) {
            org.setItems(FXCollections.observableArrayList("bde", "bds", "alu"));
        }
    }

    /**
     * Save action.
     * @param e the e
     */
    public void saveAction(ActionEvent e) {
        org.hibernate.Transaction tx = Core.getCurrentSession().beginTransaction();
        try {
            LocalDate date = this.at.getValue();
            if (date == null) {
                new Alert(Alert.AlertType.ERROR, "The date input is a required field.").show();
                return;
            }
            String description = this.description.getText();
            if (description == null || description.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The description input is a required field.").show();
                return;
            }
            String org = this.org.getValue();
            if (org == null || org.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The organisation input is a required field.").show();
                return;
            }
            String photo = this.photo.getText();
            if (photo == null || photo.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The photo input is a required field.").show();
                return;
            }
            String title = this.title.getText();
            if (title == null || title.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "The title input is a required field.").show();
                return;
            }
            this.getViewModel().getModel().setTitle(title);
            this.getViewModel().getModel().setDescription(description);
            this.getViewModel().getModel().setPhoto(photo);
            this.getViewModel().getModel().setOrg(org);
            this.getViewModel().getModel().setAt(date);
            Core.getCurrentSession().saveOrUpdate(this.getViewModel().getModel());
            tx.commit();
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setTitle("Kassoc - Dashboard");
            this.gotoScene(stage, "/kassoc/view/dashboard.fxml");
        } catch (ConstraintViolationException t) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "This actuality already exist.").show();
        } catch (Exception ex) {
            tx.rollback();
            new Alert(Alert.AlertType.ERROR, "An error occurred while creating your event, please try again."
            ).show();
        }
    }
}
