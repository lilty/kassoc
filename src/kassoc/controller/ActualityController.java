package kassoc.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import kassoc.model.ActualityEntity;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
     * The Bde actuality list.
     */
    public ListView<ActualityEntity> bdeActualityList;
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
        bdeActualityList.setCellFactory((ListView<ActualityEntity> lv)->new ListCell<>() {
            @Override
            public void updateItem(ActualityEntity album, boolean empty) {
                super.updateItem(album, empty);
                if (empty) {
                    setText(null);
                } else {
                    // use whatever data you need from the album
                    // object to get the correct displayed value:
                    try {
                        setGraphic(FXMLLoader.load(getClass().getResource("/kassoc/view/login.fxml")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        List<ActualityEntity> actus = ActualityEntity.findBy("org", "ALUMNICE", ActualityEntity.class);
        bdeActualityList.setItems(FXCollections.observableList(actus));
    }
}
