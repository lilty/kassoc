package kassoc.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Event entity.
 */
@Entity
@Table(name = "KASSOC_EVENT", schema = "S2AET07")
public class Event extends ORMEntity {
    private SimpleObjectProperty<LocalDate> at;
    private SimpleStringProperty description;
    private SimpleObjectProperty<Image> image;
    private SimpleStringProperty imageUrl;
    private SimpleStringProperty org;
    private SimpleStringProperty title;

    /**
     * Instantiates a new Event entity.
     */
    public Event() {
        super();
        this.imageUrl = new SimpleStringProperty();
        this.image = new SimpleObjectProperty<>();
        this.title = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.org = new SimpleStringProperty();
        this.at = new SimpleObjectProperty<>();
    }

    /**
     * Instantiates a new Event entity.
     * @param org         the org
     * @param imageUrl    the photo
     * @param title       the title
     * @param description the description
     * @param at          the date
     */
    public Event(final String org, final String imageUrl, final String title, final String description, final
    LocalDate at) {
        this.imageUrl = new SimpleStringProperty(imageUrl);
        this.image = new SimpleObjectProperty<>(new Image(imageUrl));
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.org = new SimpleStringProperty(org);
        this.at = new SimpleObjectProperty<>(at);
    }

    /**
     * At property simple object property.
     * @return the simple object property
     */
    public SimpleObjectProperty<LocalDate> atProperty() {
        return at;
    }

    /**
     * Description property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Event)) { return false; }
        Event that = (Event) o;
        if (!at.equals(that.at)) { return false; }
        if (!description.equals(that.description)) { return false; }
        if (!image.equals(that.image)) { return false; }
        if (!imageUrl.equals(that.imageUrl)) { return false; }
        if (!org.equals(that.org)) { return false; }
        return title.equals(that.title);
    }

    /**
     * Gets at.
     * @return the at
     */
    @Column(name = "AT")
    public LocalDate getAt() {
        return at.get();
    }

    /**
     * Sets at.
     * @param at the at
     */
    public void setAt(final LocalDate at) {
        this.at.set(at);
    }

    /**
     * Gets description.
     * @return the description
     */
    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description.get();
    }

    /**
     * Sets description.
     * @param description the description
     */
    public void setDescription(final String description) {
        this.description.set(description);
    }

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(final int id) {
        super.setId(id);
    }

    /**
     * Gets image.
     * @return the image
     */
    @Transient
    public Image getImage() {
        return image.get();
    }

    /**
     * Sets image.
     * @param image the image
     */
    public void setImage(final Image image) {
        this.image.set(image);
    }

    /**
     * Gets image url.
     * @return the image url
     */
    @Basic
    @Column(name = "PHOTO")
    public String getImageUrl() {
        return imageUrl.get();
    }

    /**
     * Sets image url.
     * @param imageUrl the image url
     */
    public void setImageUrl(final String imageUrl) {
        this.imageUrl.set(imageUrl);
        this.image.set(new Image(imageUrl));
    }

    /**
     * Gets org.
     * @return the org
     */
    @Basic
    @Column(name = "ORG")
    public String getOrg() {
        return org.get();
    }

    /**
     * Sets org.
     * @param org the org
     */
    public void setOrg(final String org) {
        this.org.set(org);
    }

    /**
     * Gets title.
     * @return the title
     */
    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title.get();
    }

    /**
     * Sets title.
     * @param title the title
     */
    public void setTitle(final String title) {
        this.title.set(title);
    }

    @Override
    public int hashCode() {
        int result = at.hashCode();
        result = 31*result+description.hashCode();
        result = 31*result+image.hashCode();
        result = 31*result+imageUrl.hashCode();
        result = 31*result+org.hashCode();
        result = 31*result+title.hashCode();
        return result;
    }

    /**
     * Image property simple object property.
     * @return the simple object property
     */
    public SimpleObjectProperty<Image> imageProperty() {
        return image;
    }

    /**
     * Image url property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty imageUrlProperty() {
        return imageUrl;
    }

    /**
     * Org property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty orgProperty() {
        return org;
    }

    /**
     * Title property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty titleProperty() {
        return title;
    }
}
