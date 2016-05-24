package kassoc.model;

import javafx.beans.property.SimpleIntegerProperty;
import kassoc.Core;

import java.util.List;

public class BaseEntity {
    private SimpleIntegerProperty id;

    public BaseEntity() {
        this.id = new SimpleIntegerProperty();
    }

    public BaseEntity(final int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public static <T> T find(int id) {
        List users;
        users = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where id=?").setParameter(0,
            id
        ).list();
        if (users.size()>0) {
            return (T) users.get(0);
        } else {
            return null;
        }
    }

    public static <T> List<T> findBy(String attribute, Object value) {
        return Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?")
            .setParameter(0,
            value
        ).list();
    }

    public static <T> T findOneBy(String attribute, Object value) {
        List users;
        users = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?")
            .setParameter(0,
            value
        ).list();
        if (users.size()>0) {
            return (T) users.get(0);
        } else {
            return null;
        }
    }

    public int getId() {
        return id.get();
    }

    public void setId(final int id) {
        this.id.set(id);
    }
}
