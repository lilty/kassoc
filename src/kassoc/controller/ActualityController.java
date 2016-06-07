package kassoc.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import kassoc.Core;
import kassoc.FXUtils;
import kassoc.ScrollPane2;
import kassoc.model.ActualityEntity;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Actuality controller.
 */
public class ActualityController extends BaseController implements Initializable {
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
            @Override
            public void updateItem(ActualityEntity album, boolean empty) {
                super.updateItem(album, empty);
                if (empty) {
                    setText(null);
                } else {
                    try {
                        AnchorPane lol = FXMLLoader.load(getClass().getResource("/kassoc/view/actuality-item.fxml"));
                        ImageView image = FXUtils.getChildByID(lol, "image");
                        if (image != null) {
                            image.setImage(new Image(album.getPhoto()));
                        }
                        Label title = FXUtils.getChildByID(lol, "title");
                        if (title != null) {
                            title.setText(album.getTitle()+" "+album.getAt().toString());
                        }
                        Text content = FXUtils.getChildByID(lol, "content");
                        if (content != null) {
                            content.setText(album.getDescription());
                            content.wrappingWidthProperty().bind(lv.widthProperty().subtract(205));
                        }
                        ScrollPane2 scroll = FXUtils.getChildByID(lol, "scroll");
                        if (scroll != null) {
                            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                        }
                        setGraphic(lol);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
