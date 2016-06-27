package kassoc.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Account entity.
 */
@Entity
@Table(name = "KASSOC_ACCOUNT", schema = "S2AET07")
public class Account extends ORMEntity {
    private SimpleIntegerProperty uniceId;
    private SimpleStringProperty name;
    private SimpleStringProperty mail;
    private SimpleStringProperty password;
    private SimpleObjectProperty<Type> type;

    /**
     * Instantiates a new Account entity.
     */
    public Account() {
        super();
        this.uniceId = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.mail = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.type = new SimpleObjectProperty<>();
    }

    /**
     * Instantiates a new Account entity.
     * @param uniceId  the unice id
     * @param name     the name
     * @param mail     the mail
     * @param password the password
     * @param type     the type
     */
    public Account(final int uniceId, final String name, final String mail, final String password, final Type type) {
        super();
        this.uniceId = new SimpleIntegerProperty(uniceId);
        this.name = new SimpleStringProperty(name);
        this.mail = new SimpleStringProperty(mail);
        this.password = new SimpleStringProperty(password);
        this.type = new SimpleObjectProperty<>(type);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Account)) { return false; }
        Account account = (Account) o;
        if (!uniceId.equals(account.uniceId)) { return false; }
        if (!name.equals(account.name)) { return false; }
        if (!mail.equals(account.mail)) { return false; }
        if (!password.equals(account.password)) { return false; }
        return type.equals(account.type);
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
     * Gets type.
     * @return the type
     */
    @Basic
    @Column(name = "TYPE")
    @Enumerated(EnumType.ORDINAL)
    public Type getType() {
        return type.get();
    }

    /**
     * Sets type.
     * @param type the type
     */
    public void setType(final Type type) {
        this.type.set(type);
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
        int result = uniceId.hashCode();
        result = 31*result+name.hashCode();
        result = 31*result+mail.hashCode();
        result = 31*result+password.hashCode();
        result = 31*result+type.hashCode();
        return result;
    }

    /**
     * Mail property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty mailProperty() {
        return mail;
    }

    /**
     * Name property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty nameProperty() {
        return name;
    }

    /**
     * Password property simple string property.
     * @return the simple string property
     */
    public SimpleStringProperty passwordProperty() {
        return password;
    }

    /**
     * Type property simple object property.
     * @return the simple object property
     */
    public SimpleObjectProperty<Type> typeProperty() {
        return type;
    }

    /**
     * Unice id property simple integer property.
     * @return the simple integer property
     */
    public SimpleIntegerProperty uniceIdProperty() {
        return uniceId;
    }

    /**
     * The enum Type.
     */
    public enum Type {
        /**
         * Admin type.
         */
        ADMIN(-1),
        /**
         * Student type.
         */
        STUDENT(0);
        private int type;

        Type(int type) {
            this.type = type;
        }
    }
}
