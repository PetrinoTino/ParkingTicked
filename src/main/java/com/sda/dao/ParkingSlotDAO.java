package com.sda.dao;

import com.sda.entity.ParkingSlot;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ParkingSlotDAO {

    public void saveParkingSlot(ParkingSlot slot) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(slot);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ParkingSlot> getAvailableParkingSlots() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ParkingSlot> query = session.createQuery("SELECT * FROM ParkingSlot WHERE isAvailable = TRUE\"");
            return query.list();
        }
    }

    public void updateParkingSlotAvailability(ParkingSlot slot) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(slot);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
