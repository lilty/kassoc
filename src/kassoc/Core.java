package kassoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
     * Gets current session.
     * @return the current session
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}