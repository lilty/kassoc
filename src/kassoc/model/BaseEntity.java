package kassoc.model;

import kassoc.Core;

import java.util.List;

/**
 * The type Base entity.
 */
public class BaseEntity {
    private int id;

    /**
     * Instantiates a new Base entity.
     */
    BaseEntity() { }

    /**
     * Instantiates a new Base entity.
     * @param id the id
     */
    BaseEntity(final int id) {
        this.id = id;
    }

    /**
     * Find t.
     * @param <T> the type parameter
     * @param id  the id
     * @return the t
     */
    public static <T> T find(int id) {
        @SuppressWarnings("JpaQlInspection") List ret = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where id=?").setParameter(
            0,
            id
        ).list();
        if (ret.size()>0) {
            return (T) ret.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find by list.
     * @param attribute the attribute
     * @param value     the value
     * @return the list
     */
    public static List findBy(String attribute, Object value) {
        return Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?").setParameter(
            0,
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
    public static <T> T findOneBy(String attribute, java.io.Serializable value) {
        List ret = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?").setParameter(
            0,
            value
        ).list();
        if (ret.size()>0) {
            return (T) ret.get(0);
        } else {
            return null;
        }
    }

    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(final int id) {
        this.id = id;
    }
}
