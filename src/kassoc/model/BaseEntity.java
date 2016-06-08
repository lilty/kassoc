package kassoc.model;

import kassoc.Core;
import org.hibernate.Query;

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
     * @param <T>   the type parameter
     * @param id    the id
     * @param clazz the clazz
     * @return the t
     */
    public static <T> T find(int id, Class<T> clazz) {
        @SuppressWarnings("JpaQlInspection") Query query = Core.getCurrentSession().createQuery("from "+clazz.getName()+" where id=:parm").setParameter(
            "param",
            id
        );
        List ret = query.list();
        if (ret.size()>0) {
            return (T) ret.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find by list.
     * @param <T>       the type parameter
     * @param attribute the attribute
     * @param value     the value
     * @param clazz     the clazz
     * @return the list
     */
    public static <T> List<T> findBy(String attribute, Object value, Class<T> clazz) {
        Query query = Core.getCurrentSession().createQuery("from "+clazz.getName()+" cl "+
            "where cl."+attribute+"=:parm").setParameter(
            "parm",
            value
        );
        return (List<T>) query.list();
    }

    /**
     * Find one by t.
     * @param <T>       the type parameter
     * @param attribute the attribute
     * @param value     the value
     * @param clazz     the clazz
     * @return the t
     */
    public static <T> T findOneBy(String attribute, Object value, Class<T> clazz) {
        Query query = Core.getCurrentSession().createQuery("from "+clazz.getName()+" "+
            "where "+attribute+"=:parm").setParameter(
            "parm",
            value
        );
        List ret = query.list();
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
