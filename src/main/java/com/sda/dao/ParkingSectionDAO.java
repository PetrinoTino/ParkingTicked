package com.sda.dao;

import com.sda.entity.ParkingSection;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ParkingSectionDAO {

    public void saveParkingSection(ParkingSection section) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(section);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ParkingSection> getCurrentlyParkedCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ParkingSection> query = session.createQuery("FROM ParkingSection WHERE exitTime IS NULL");
            return query.list();
        }
    }

    @SuppressWarnings("unchecked")
    public ParkingSection getParkingSectionByLicensePlate(String licensePlate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ParkingSection> query = session.createQuery("FROM ParkingSection WHERE licensePlate = ? AND exitTime IS NULL");
            query.setParameter(0, licensePlate);
            return query.uniqueResult();
        }
    }
}
