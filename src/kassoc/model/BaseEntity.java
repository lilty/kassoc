package kassoc.model;

import kassoc.Core;

import java.util.List;

public class BaseEntity {
    public static BaseEntity find(int id) {
        List users;
        users = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where id=?").setParameter(0,
            id
        ).list();
        if (users.size()>0) {
            return (BaseEntity) users.get(0);
        } else {
            return null;
        }
    }

    public static List<BaseEntity> findBy(String attribute, Object value) {
        return Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?")
            .setParameter(0,
            value
        ).list();
    }

    public static BaseEntity findOneBy(String attribute, Object value) {
        List users;
        users = Core.getCurrentSession().createQuery("from "+BaseEntity.class.getName()+" where "+attribute+"=?")
            .setParameter(0,
            value
        ).list();
        if (users.size()>0) {
            return (BaseEntity) users.get(0);
        } else {
            return null;
        }
    }
}
