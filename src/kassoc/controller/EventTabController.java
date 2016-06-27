package kassoc.controller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import kassoc.Kassoc;
import kassoc.model.Event;
import kassoc.view.model.EventItem;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type EventTabController controller.
 */
public class EventTabController implements Initializable {
    /**
     * The Accordion.
     */
    public Accordion accordion;
    /**
     * The Alu actuality list.
     */
    public ListView<Event> aluActualityList;
    /**
     * The Bde actuality list.
     */
    public ListView<Event> bdeActualityList;
    /**
     * The Bde actuality pane.
     */
    public TitledPane bdeActualityPane;
    /**
     * The Bds actuality list.
     */
    public ListView<Event> bdsActualityList;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        accordion.setExpandedPane(bdeActualityPane);
        Callback<ListView<Event>, ListCell<Event>> cellFactory = (ListView<Event> lv)->new
            ListCell<>() {
            private HashMap<Integer, EventItem> graphics;

            private HashMap<Integer, EventItem> getGraphics() {
                if (this.graphics == null) {
                    this.graphics = new HashMap<>();
                }
                return this.graphics;
            }

            @Override
            public void updateItem(Event item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    try {
                        if (!this.getGraphics().containsKey(item.getId())) {
                            EventItem vm = new EventItem(item);
                            Text description = vm.getChildById("description");
                            if (description != null) {
                                description.wrappingWidthProperty().bind(lv.widthProperty().subtract(205));
                            }
                            this.getGraphics().put(item.getId(), vm);
                        }
                        this.setGraphic(this.getGraphics().get(item.getId()).getView());
                    } catch (Exception ignored) { }
                }
            }
        };
        bdeActualityList.setCellFactory(cellFactory);
        bdsActualityList.setCellFactory(cellFactory);
        aluActualityList.setCellFactory(cellFactory);
        Transaction tx = Kassoc.getCurrentSession().beginTransaction();
        List<Event> actus = Event.findBy("org", "bde", Event.class);
        bdeActualityList.setItems(FXCollections.observableList(actus));
        actus = Event.findBy("org", "bds", Event.class);
        bdsActualityList.setItems(FXCollections.observableList(actus));
        actus = Event.findBy("org", "alu", Event.class);
        aluActualityList.setItems(FXCollections.observableList(actus));
        tx.commit();
    }
}
