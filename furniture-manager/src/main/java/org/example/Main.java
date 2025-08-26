package org.example;
import entity.Room;
import entity.Bed;
import entity.Sofa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Create Operation
            transaction = session.beginTransaction();

            // Create first room (Living Room)
            Room livingRoom = new Room();
            livingRoom.setName("Living Room");
            System.out.println("\nCreating Living Room:");
            System.out.println("--------------------");
            System.out.println("Room Name: " + livingRoom.getName());

            // Add bed to living room
            Bed bed1 = new Bed();
            bed1.setType("King Bed");
            bed1.setSize(1.8);
            bed1.setHasStorage(true);
            bed1.setPrice(1300.0);
            livingRoom.addBed(bed1);

            System.out.println("\nAdding Bed to Living Room:");
            System.out.println("Type: " + bed1.getType());
            System.out.println("Size: " + bed1.getSize() + " meters");
            System.out.println("Has Storage: " + bed1.getHasStorage());
            System.out.println("Price: $" + bed1.getPrice());

            // Add sofa to living room
            Sofa sofa1 = new Sofa();
            sofa1.setModel("Comfort Plus");
            sofa1.setMaterial("Leather");
            sofa1.setSeatingCapacity(3);
            sofa1.setPrice(1000.0);
            sofa1.setConvertible(true);
            livingRoom.addSofa(sofa1);

            System.out.println("\nAdding Sofa to Living Room:");
            System.out.println("Model: " + sofa1.getModel());
            System.out.println("Material: " + sofa1.getMaterial());
            System.out.println("Seating Capacity: " + sofa1.getSeatingCapacity());
            System.out.println("Price: $" + sofa1.getPrice());
            System.out.println("Convertible: " + sofa1.getConvertible());

            // Create second room (Bedroom)
            Room bedroom = new Room();
            bedroom.setName("Bedroom");
            System.out.println("\nCreating Bedroom:");
            System.out.println("--------------------");
            System.out.println("Room Name: " + bedroom.getName());

            // Add bed to bedroom
            Bed bed2 = new Bed();
            bed2.setType("Queen Bed");
            bed2.setSize(1.5);
            bed2.setHasStorage(false);
            bed2.setPrice(900.0);
            bedroom.addBed(bed2);

            System.out.println("\nAdding Bed to Bedroom:");
            System.out.println("Type: " + bed2.getType());
            System.out.println("Size: " + bed2.getSize() + " meters");
            System.out.println("Has Storage: " + bed2.getHasStorage());
            System.out.println("Price: $" + bed2.getPrice());

            // Save rooms (cascade will save beds and sofas)
            System.out.println("\nSaving to database...");
            session.persist(livingRoom);
            session.persist(bedroom);

            transaction.commit();
            System.out.println("Initial save completed!");

            // 2. Read Operation
            transaction = session.beginTransaction();

            System.out.println("\nReading all rooms and their furniture ");
            List<Room> rooms = session.createQuery(
                    "FROM Room r LEFT JOIN FETCH r.beds LEFT JOIN FETCH r.sofas",
                    Room.class).getResultList();

            // Print detailed results
            for (Room room : rooms) {
                System.out.println("\nROOM DETAILS:");
                System.out.println("=============");
                System.out.println("Room ID: " + room.getId());
                System.out.println("Room Name: " + room.getName());

                System.out.println("\nBEDS IN THIS ROOM:");
                System.out.println("=================");
                for (Bed bed : room.getBeds()) {
                    System.out.println("Bed ID: " + bed.getId());
                    System.out.println("Type: " + bed.getType());
                    System.out.println("Size: " + bed.getSize() + " meters");
                    System.out.println("Price: $" + bed.getPrice());
                    System.out.println("Has Storage: " + bed.getHasStorage());
                    System.out.println("-----------------");
                }

                System.out.println("\nSOFAS IN THIS ROOM:");
                System.out.println("=================");
                for (Sofa sofa : room.getSofas()) {
                    System.out.println("Sofa ID: " + sofa.getId());
                    System.out.println("Model: " + sofa.getModel());
                    System.out.println("Material: " + sofa.getMaterial());
                    System.out.println("Seating Capacity: " + sofa.getSeatingCapacity());
                    System.out.println("Price: $" + sofa.getPrice());
                    System.out.println("Convertible: " + sofa.getConvertible());
                    System.out.println("-----------------");
                }
                System.out.println("=============================");
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Close the SessionFactory
        HibernateUtil.getSessionFactory().close();
        System.out.println("\nDatabase operations completed.");
    }
}