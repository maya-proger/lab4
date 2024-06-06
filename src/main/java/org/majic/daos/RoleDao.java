package org.majic.daos;
import org.majic.models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.majic.utils.HibernateSessionFactoryUtil;
import java.util.List;

public class RoleDao {

    public Role findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }

    public void save(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(role);
        tx1.commit();
        session.close();
    }

    public void update(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(role);
        tx1.commit();
        session.close();
    }

    public void delete(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(role);
        tx1.commit();
        session.close();
    }

    public List<Role> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Role> roles = session.createQuery("From Role").list();
        session.close();
        return roles;
    }
}
