package com.example.javawebcarrental.dao.daoImpl;

import com.example.javawebcarrental.config.HibernateSessionFactoryUtil;
import com.example.javawebcarrental.dao.daoInterfaces.CarDAO;
import com.example.javawebcarrental.entity.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    @Override
    public Car findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Car.class, id);
    }

    @Override
    public void save(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("delete from Car where id="+id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> findAllByMark(String mark) {
        String findAllByMarkQuery = "from Car c where c.mark=:n";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(findAllByMarkQuery);
        query.setParameter("n", mark);
        List<Car> carList = (List<Car>) query.getResultList();
        transaction.commit();
        session.close();
        return carList;
    }

    @Override
    public List<Car> findAllByClass(String carClass) {
        String findAllByMarkQuery = "from Car c where c.carClass=:n";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(findAllByMarkQuery);
        query.setParameter("n", carClass);
        List<Car> carList = (List<Car>) query.getResultList();
        transaction.commit();
        session.close();
        return carList;
    }

    @Override
    public List<Car> sortedByPrise(String sorted) {
        String sortedByPrise = "from Car c order by c.carPrise "+ sorted;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(sortedByPrise);
        List<Car> carList = (List<Car>) query.getResultList();
        transaction.commit();
        session.close();
        return carList;
    }

    @Override
    public List<Car> sortedByName(String sorted) {
        String sortedByCarName = "from Car c order by c.carName "+ sorted;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(sortedByCarName);
        List<Car> carList = (List<Car>) query.getResultList();
        transaction.commit();
        session.close();
        return carList;
    }

    @Override
    public List<Car> findAll() {
        return (List<Car>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Car").list();
    }
}
