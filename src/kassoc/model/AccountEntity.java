package kassoc.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * The type Account entity.
 */
@Entity
@Table(name = "KASSOC_ACCOUNT", schema = "S2AET07")
public class AccountEntity extends BaseEntity {
    private SimpleIntegerProperty uniceId;
    private SimpleStringProperty name;
    private SimpleStringProperty mail;
    private SimpleStringProperty password;

    /**
     * Instantiates a new Account entity.
     */
    public AccountEntity() {
        super();
        this.uniceId = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.mail = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    /**
     * Instantiates a new Account entity.
     * @param id       the id
     * @param uniceId  the unice id
     * @param name     the name
     * @param mail     the mail
     * @param password the password
     */
    public AccountEntity(final int id, final int uniceId, final String name, final String mail, final String password) {
        super(id);
        this.uniceId = new SimpleIntegerProperty(uniceId);
        this.name = new SimpleStringProperty(name);
        this.mail = new SimpleStringProperty(mail);
        this.password = new SimpleStringProperty(password);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AccountEntity that = (AccountEntity) o;
        return this.getId() == that.getId() && (uniceId != null ? uniceId.equals(that.uniceId) : that.uniceId == null
            && (name != null ? name.equals(
            that.name) : that.name == null));
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return super.getId();
    }

    public void setId(final int id) {
        super.setId(id);
    }

    /**
     * Gets mail.
     * @return the mail
     */
    @Basic
    @Column(name = "MAIL")
    public String getMail() {
        return mail.get();
    }

    /**
     * Sets mail.
     * @param mail the mail
     */
    public void setMail(final String mail) {
        this.mail.set(mail);
    }

    /**
     * Gets name.
     * @return the name
     */
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name.get();
    }

    /**
     * Sets name.
     * @param name the name
     */
    public void setName(final String name) {
        this.name.set(name);
    }

    /**
     * Gets password.
     * @return the password
     */
    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password.get();
    }

    /**
     * Sets password.
     * @param password the password
     */
    public void setPassword(final String password) {
        this.password.set(password);
    }

    /**
     * Gets unice id.
     * @return the unice id
     */
    @Basic
    @Column(name = "UNICE_ID")
    public int getUniceId() {
        return uniceId.get();
    }

    /**
     * Sets unice id.
     * @param uniceId the unice id
     */
    public void setUniceId(final int uniceId) {
        this.uniceId.set(uniceId);
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31*result+(uniceId != null ? uniceId.hashCode() : 0);
        result = 31*result+(name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountEntity{"+
            "id="+this.getId()+
            ", uniceId="+uniceId+
            ", name='"+name+'\''+
            '}';
    }
}
