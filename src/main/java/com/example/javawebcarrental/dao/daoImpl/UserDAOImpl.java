package com.example.javawebcarrental.dao.daoImpl;

import com.example.javawebcarrental.config.HibernateSessionFactoryUtil;
import com.example.javawebcarrental.dao.daoInterfaces.UserDAO;
import com.example.javawebcarrental.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("delete from User where id="+id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from User").list();

    }

    @Override
    public void blockUser(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean oldActive = (boolean) session.createQuery("select active from User u where u.id="+id).list().get(0);
        String setUserStatusQuery = "update User u set u.active=:n1 where u.id=:n2";
        Query query=session.createQuery(setUserStatusQuery);
        query.setParameter("n1", !oldActive);
        query.setParameter("n2", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
