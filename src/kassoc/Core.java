package kassoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

/**
 * The type Core.
 */
public final class Core {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().
                configure("hibernate.cfg.xml").
                buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Find by id object.
     * @param id the id
     * @return the object
     */
    public static Object findById(int id) {
        List users;
        users = sessionFactory.getCurrentSession().createQuery("from AccountEntity where id=?").setParameter(
            0,
            id
        ).list();
        if (users.size()>0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    /**
     * Gets current session.
     * @return the current session
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}