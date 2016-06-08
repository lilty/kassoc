package kassoc.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

/**
 * The type Event entity.
 */
@Entity
@Table(name = "KASSOC_EVENT", schema = "S2AET07")
public class EventEntity extends BaseEntity {
    private SimpleStringProperty photo;
    private SimpleStringProperty title;
    private SimpleStringProperty description;
    private SimpleStringProperty org;
    private SimpleObjectProperty<Time> at;

    /**
     * Instantiates a new Event entity.
     */
    public EventEntity() {
        super();
        this.photo = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.org = new SimpleStringProperty();
        this.at = new SimpleObjectProperty<>();
    }

    /**
     * Instantiates a new Event entity.
     * @param org         the org
     * @param photo       the photo
     * @param title       the title
     * @param description the description
     * @param at          the date
     */
    public EventEntity(final String org, final String photo, final String title, final String description, final
    Time at) {
        this.photo = new SimpleStringProperty(photo);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.org = new SimpleStringProperty(org);
        this.at = new SimpleObjectProperty<>(at);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof EventEntity)) { return false; }
        EventEntity that = (EventEntity) o;
        if (!photo.equals(that.photo)) { return false; }
        if (!title.equals(that.title)) { return false; }
        if (!description.equals(that.description)) { return false; }
        if (!org.equals(that.org)) { return false; }
        return at.equals(that.at);
    }

    /**
     * Gets at.
     * @return the at
     */
    @Basic
    @Column(name = "AT")
    public Time getAt() {
        return at.get();
    }

    /**
     * Sets at.
     * @param at the at
     */
    public void setAt(final Time at) {
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
    public int getId() {
        return super.getId();
    }

    public void setId(final int id) {
        super.setId(id);
    }

    /**
     * Gets key.
     * @return the key
     */
    @Basic
    @Column(name = "ORG")
    public String getOrg() {
        return org.get();
    }

    /**
     * Sets key.
     * @param key the key
     */
    public void setOrg(final String key) {
        this.org.set(key);
    }

    /**
     * Gets photo.
     * @return the photo
     */
    @Basic
    @Column(name = "PHOTO")
    public String getPhoto() {
        return photo.get();
    }

    /**
     * Sets photo.
     * @param photo the photo
     */
    public void setPhoto(final String photo) {
        this.photo.set(photo);
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
        int result = photo.hashCode();
        result = 31*result+title.hashCode();
        result = 31*result+description.hashCode();
        result = 31*result+org.hashCode();
        result = 31*result+at.hashCode();
        return result;
    }
}
