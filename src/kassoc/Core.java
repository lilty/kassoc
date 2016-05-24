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
        sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    /**
     * Gets current session.
     * @return the current session
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}