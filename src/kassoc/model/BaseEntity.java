package kassoc.model;

import javafx.beans.property.SimpleIntegerProperty;
import kassoc.Core;

import java.util.List;

/**
 * The type Base entity.
 */
public class BaseEntity {
    private SimpleIntegerProperty id;

    /**
     * Instantiates a new Base entity.
     */
    public BaseEntity() {
        this.id = new SimpleIntegerProperty();
    }

    /**
     * Instantiates a new Base entity.
     * @param id the id
     */
    public BaseEntity(final int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    /**
     * Find t.
     * @param <T> the type parameter
     * @param id  the id
     * @return the t
     */
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

    /**
     * Find by list.
     * @param <T>       the type parameter
     * @param attribute the attribute
     * @param value     the value
     * @return the list
     */
    public static <T> List<T> findBy(String attribute, Object value) {
        return Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?")
            .setParameter(0,
            value
        ).list();
    }

    /**
     * Find one by t.
     * @param <T>       the type parameter
     * @param attribute the attribute
     * @param value     the value
     * @return the t
     */
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

    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return id.get();
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(final int id) {
        this.id.set(id);
    }
}