package dao;

import entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class RoomDAO {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public void saveRoom(Room room) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(room);
            transaction.commit();
        }
    }

    public List<Room> getAllRooms() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Room", Room.class).list();
        }
    }

    public Room getRoomById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Room.class, id);
        }
    }

    public void updateRoom(Room room) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(room);
            transaction.commit();
        }
    }

    public void deleteRoom(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Room room = session.get(Room.class, id);
            if (room != null) {
                session.remove(room);
            }
            transaction.commit();
        }
    }
} 