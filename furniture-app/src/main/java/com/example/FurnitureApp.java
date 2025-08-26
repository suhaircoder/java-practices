package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.example.dao.DatabaseManager;
import com.example.model.Furniture;
import com.example.util.CSVParser;

public class FurnitureApp {
    private final DatabaseManager dbManager;
    private final CSVParser csvParser;

    public FurnitureApp() {
        this.dbManager = new DatabaseManager();
        this.csvParser = new CSVParser();
    }

    private void insertFurniture(List<Furniture> furniture) throws SQLException {
        String sql = "INSERT INTO furniture (type, name, price, material) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dbManager.getConnection();
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (Furniture item : furniture) {
                    pstmt.setString(1, item.getClass().getSimpleName().toLowerCase());
                    pstmt.setString(2, item.getName());
                    pstmt.setDouble(3, item.getPrice());
                    pstmt.setString(4, item.getMaterial());
                    pstmt.addBatch(); // Use batch processing for better performance
                }
                pstmt.executeBatch();
                conn.commit(); // Commit transaction
                System.out.println("Furniture data inserted successfully");
            } catch (SQLException e) {
                if (conn != null) conn.rollback(); 
                throw e;
            }
        } finally {
            if (conn != null) conn.setAutoCommit(true); // Reset auto-commit
        }
    }

    public void run(String[] args) {
        try {
            // Initial database setup
            dbManager.createTables();
            List<Furniture> furniture = csvParser.parseFurniture(args[0]);
            insertFurniture(furniture);

            Thread writeThread = new Thread(() -> {
                Connection conn = null;
                try {
                    System.out.println("Write Thread: Starting...");
                    conn = dbManager.getConnection();
                    conn.setAutoCommit(false);  // Start transaction

                    // Insert new furniture
                    try (PreparedStatement insertStmt = conn.prepareStatement(
                            "INSERT INTO furniture (type, name, price, material) VALUES (?, ?, ?, ?)"
                    )) {
                        insertStmt.setString(1, "chair");
                        insertStmt.setString(2, "Office Chair");
                        insertStmt.setDouble(3, 130.0);
                        insertStmt.setString(4, "aqw");
                        insertStmt.executeUpdate();
                    }

                    System.out.println("Write Thread: Inserted new furniture, waiting 3 seconds...");
                    Thread.sleep(3000);  // Wait 3 seconds before updating

                    // Update prices
                    try (PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE furniture SET price = price * 1.1"
                    )) {
                        updateStmt.executeUpdate();
                    }

                    conn.commit();  // Commit all changes
                    System.out.println("Write Thread: Changes committed");

                } catch (Exception e) {
                    System.out.println("Write Thread Error: " + e.getMessage());
                    if (conn != null) {
                        try {
                            conn.rollback();
                            System.out.println("Write Thread: Transaction rolled back");
                        } catch (SQLException ex) {
                            System.out.println("Write Thread: Rollback failed: " + ex.getMessage());
                        }
                    }
                } finally {
                    if (conn != null) {
                        try {
                            conn.setAutoCommit(true);
                            conn.close();
                        } catch (SQLException e) {
                            System.out.println("Write Thread: Error closing connection: " + e.getMessage());
                        }
                    }
                }
            });

            Thread readThread = new Thread(() -> {
                Connection conn = null;
                try {
                    System.out.println("Read Thread: Starting...");
                    conn = dbManager.getConnection();
                    conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                    // First read - should show original data
                    readFurniture(conn, "First");

                    // Wait and read again - should show updated data
                    Thread.sleep(4000);
                    readFurniture(conn, "Second");

                } catch (Exception e) {
                    System.out.println("Read Thread Error: " + e.getMessage());
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            System.out.println("Read Thread: Error closing connection: " + e.getMessage());
                        }
                    }
                }
            });

            // Start both threads
            writeThread.start();
            readThread.start();

            // Wait for both threads to complete
            writeThread.join();
            readThread.join();

            System.out.println("All operations completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFurniture(Connection conn, String readNumber) throws SQLException {
        System.out.println("\n" + readNumber + " Read:");
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM furniture")) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Price: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        }
    }

    public static void main(String[] args) {
        new FurnitureApp().run(args);
    }
}


        /*try {
            // Создаем таблицы
            dbManager.createTables();

            // Читаем данные из CSV
            List<Furniture> furniture = csvParser.parseFurniture(args[0]);


            // Добавляем данные в БД
            insertFurniture(furniture);

            // Демонстрируем запросы
            showAllFurniture();

            // Пользовательский запрос
            userQuery();

            // Транзакция с Dirty Read
            dirtyReadTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertFurniture(List<Furniture> furniture) throws SQLException {
        String sql = "INSERT INTO furniture (type, name, price, material) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            for (Furniture item : furniture) {
                pstmt.setString(1, item.getClass().getSimpleName().toLowerCase());
                pstmt.setString(2, item.getName());
                pstmt.setDouble(3, item.getPrice());
                pstmt.setString(4, item.getMaterial());
                pstmt.executeUpdate();
            }
        }
    }

    private void showAllFurniture() throws SQLException {
        String sql = "SELECT * FROM furniture f " +
                "LEFT JOIN sofa s ON f.id = s.furniture_id " +
                "LEFT JOIN bed b ON f.id = b.furniture_id";

        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d, Тип: %s, Название: %s, Цена: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getDouble("price"));
            }
        }
    }

    private void userQuery() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальную цену:");
        double minPrice = scanner.nextDouble();

        String sql = "SELECT * FROM furniture WHERE price >= ?";

        try (Connection conn = dbManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, minPrice);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.printf("ID: %d, Название: %s, Цена: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
            }
        }
    }

    private void dirtyReadTransaction() throws SQLException {
        Connection conn = dbManager.getConnection();
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            conn.setAutoCommit(false);

            // Обновляем цену
            String updateSql = "UPDATE furniture SET price = price * 1.1 WHERE id = 1";
            String deleteSql = "DELETE FROM furniture WHERE id = 2";

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(updateSql);
                stmt.executeUpdate(deleteSql);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } finally {
            conn.close();
        }
    }

    public static void main(String[] args) {
        new FurnitureApp().run(args);
    }
}
*/
