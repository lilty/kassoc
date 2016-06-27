package kassoc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import kassoc.Kassoc;
import org.hibernate.exception.ConstraintViolationException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
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
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            // Get a Properties object
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");
            final String username = "ab.lucas77@gmail.com";//
            final String password = "65033095049814";
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress("ab.lucas77@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Kassoc.account.getMail(), false));
            msg.setSubject("Hello");
            msg.setText("How are you");
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");

        } catch (ConstraintViolationException t) {
            tx.rollback();
        } catch (MessagingException e1) {
            e1.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e1.getMessage()).show();
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
