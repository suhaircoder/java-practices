package dao;

import entity.Furniture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class FurnitureDAO {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public void saveFurniture(Furniture furniture) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(furniture);
            transaction.commit();
        }
    }

    public List<Furniture> getAllFurniture() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Furniture", Furniture.class).list();
        }
    }

    public Furniture getFurnitureById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Furniture.class, id);
        }
    }

    public void updateFurniture(Furniture furniture) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(furniture);
            transaction.commit();
        }
    }

    public void deleteFurniture(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Furniture furniture = session.get(Furniture.class, id);
            if (furniture != null) {
                session.remove(furniture);
            }
            transaction.commit();
        }
    }
} 