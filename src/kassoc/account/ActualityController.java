package kassoc.account;

import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Actuality controller.
 */
public class ActualityController implements Initializable {
    /**
     * The Accordion.
     */
    public Accordion accordion;
    /**
     * The Alu actuality pane.
     */
    public TitledPane aluActualityPane;
    /**
     * The Bde actuality pane.
     */
    public TitledPane bdeActualityPane;
    /**
     * The Bds actuality pane.
     */
    public TitledPane bdsActualityPane;
    /**
     * The Oth actuality pane.
     */
    public TitledPane othActualityPane;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        accordion.setExpandedPane(bdeActualityPane);
    }
}
