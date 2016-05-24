package kassoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

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

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}