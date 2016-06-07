package kassoc;

import kassoc.model.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * The type Core.
 */
public final class Core {
    private static final SessionFactory sessionFactory;
    /**
     * The constant account.
     */
    public static AccountEntity account;

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