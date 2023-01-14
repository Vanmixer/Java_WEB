package com.example.javawebcarrental.dao.daoImpl;

import com.example.javawebcarrental.config.HibernateSessionFactoryUtil;
import com.example.javawebcarrental.dao.daoInterfaces.RentDAO;
import com.example.javawebcarrental.entity.Rent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class RentDAOImpl implements RentDAO {
    @Override
    public Rent findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Rent.class, id);
    }

    @Override
    public void save(Rent rent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(rent);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Rent rent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(rent);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("delete from Rent where id="+id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<Rent> findAll() {
        return (List<Rent>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Rent").list();
    }

    @Override
    public List<Rent> findAllUsersRent(int id) {
        String allRentQuery="from Rent r where r.user.id =:n";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query=session.createQuery(allRentQuery);
        query.setParameter("n", id);
        return (List<Rent>) query.getResultList();
    }
}
