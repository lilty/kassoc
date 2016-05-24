package kassoc.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Table(name = "KASSOC_ACCOUNT", schema = "S2AET07")
public class AccountEntity extends BaseEntity {
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty uniceId;
    private SimpleStringProperty name;
    private SimpleStringProperty mail;
    private SimpleStringProperty password;

    public AccountEntity() {
        this.id = new SimpleIntegerProperty();
        this.uniceId = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.mail = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AccountEntity that = (AccountEntity) o;
        if (id != that.id) { return false; }
        if (uniceId != null ? !uniceId.equals(that.uniceId) : that.uniceId != null) { return false; }
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id.get();
    }

    public void setId(final int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "MAIL")
    public String getMail() {
        return mail.get();
    }

    public void setMail(final String mail) {
        this.mail.set(mail);
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password.get();
    }

    public void setPassword(final String password) {
        this.password.set(password);
    }

    @Basic
    @Column(name = "UNICE_ID")
    public int getUniceId() {
        return uniceId.get();
    }

    public void setUniceId(final int uniceId) {
        this.uniceId.set(uniceId);
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31*result+(uniceId != null ? uniceId.hashCode() : 0);
        result = 31*result+(name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountEntity{"+
            "id="+id+
            ", uniceId="+uniceId+
            ", name='"+name+'\''+
            '}';
    }
}
