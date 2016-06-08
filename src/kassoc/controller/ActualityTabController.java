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
import kassoc.model.ActualityEntity;
import kassoc.view.ActualityItem;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type ActualityTabController controller.
 */
public class ActualityTabController extends BaseController implements Initializable {
    /**
     * The Accordion.
     */
    public Accordion accordion;
    /**
     * The Alu actuality list.
     */
    public ListView<ActualityEntity> aluActualityList;
    /**
     * The Bde actuality list.
     */
    public ListView<ActualityEntity> bdeActualityList;
    /**
     * The Bde actuality pane.
     */
    public TitledPane bdeActualityPane;
    /**
     * The Bds actuality list.
     */
    public ListView<ActualityEntity> bdsActualityList;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        accordion.setExpandedPane(bdeActualityPane);
        Callback<ListView<ActualityEntity>, ListCell<ActualityEntity>> cellFactory = (ListView<ActualityEntity> lv)
            ->new ListCell<>() {
            private HashMap<Integer, ActualityItem> graphics;

            private HashMap<Integer, ActualityItem> getGraphics() {
                if (this.graphics == null) {
                    this.graphics = new HashMap<>();
                }
                return this.graphics;
            }

            @Override
            public void updateItem(ActualityEntity item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    try {
                        if (!this.getGraphics().containsKey(item.getId())) {
                            ActualityItem vm = new ActualityItem(item);
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
        List<ActualityEntity> actus = ActualityEntity.findBy("org", "bde", ActualityEntity.class);
        bdeActualityList.setItems(FXCollections.observableList(actus));
        actus = ActualityEntity.findBy("org", "bds", ActualityEntity.class);
        bdsActualityList.setItems(FXCollections.observableList(actus));
        actus = ActualityEntity.findBy("org", "alu", ActualityEntity.class);
        aluActualityList.setItems(FXCollections.observableList(actus));
        tx.commit();
    }
}
