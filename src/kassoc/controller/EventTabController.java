package kassoc.controller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import kassoc.Core;
import kassoc.model.EventEntity;
import kassoc.view.model.EventItem;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type EventTabController controller.
 */
public class EventTabController extends BaseController implements Initializable {
    /**
     * The Accordion.
     */
    public Accordion accordion;
    /**
     * The Alu actuality list.
     */
    public ListView<EventEntity> aluActualityList;
    /**
     * The Bde actuality list.
     */
    public ListView<EventEntity> bdeActualityList;
    /**
     * The Bde actuality pane.
     */
    public TitledPane bdeActualityPane;
    /**
     * The Bds actuality list.
     */
    public ListView<EventEntity> bdsActualityList;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        accordion.setExpandedPane(bdeActualityPane);
        Callback<ListView<EventEntity>, ListCell<EventEntity>> cellFactory = (ListView<EventEntity> lv)
            ->new ListCell<>() {
            private HashMap<Integer, EventItem> graphics;

            private HashMap<Integer, EventItem> getGraphics() {
                if (this.graphics == null) {
                    this.graphics = new HashMap<>();
                }
                return this.graphics;
            }

            @Override
            public void updateItem(EventEntity item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    try {
                        if (!this.getGraphics().containsKey(item.getId())) {
                            EventItem vm = new EventItem(item);
                            Text content = vm.getChildById("content");
                            if (content != null) {
                                content.wrappingWidthProperty().bind(lv.widthProperty().subtract(205));
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
        Transaction tx = Core.getCurrentSession().beginTransaction();
        List<EventEntity> actus = EventEntity.findBy("org", "bde", EventEntity.class);
        bdeActualityList.setItems(FXCollections.observableList(actus));
        actus = EventEntity.findBy("org", "bds", EventEntity.class);
        bdsActualityList.setItems(FXCollections.observableList(actus));
        actus = EventEntity.findBy("org", "alu", EventEntity.class);
        aluActualityList.setItems(FXCollections.observableList(actus));
        tx.commit();
    }
}
