package com.example.dao;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD ="0000";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void createTables() throws SQLException {
        String furnitureTable = " CREATE TABLE IF NOT EXISTS furniture ("+
                "id INT AUTO_INCREMENT PRIMARY KEY,"+
                "type VARCHAR(50) NOT NULL,"+
                "name VARCHAR(100) NOT NULL,"+
                "price DECIMAL(10,2) NOT NULL,"+
                "material VARCHAR(50) NOT NULL"+")";

        String sofaTable =
            "CREATE TABLE IF NOT EXISTS sofa ("+
                "furniture_id INT PRIMARY KEY,"+
                "seating_capacity INT NOT NULL,"+
               " FOREIGN KEY  (furniture_id) REFERENCES furniture(id)"+")";

        String bedTable =
            "CREATE TABLE IF NOT EXISTS bed ("+
                "furniture_id INT PRIMARY KEY,"+
                "size VARCHAR(20) NOT NULL,"+
                "FOREIGN KEY (furniture_id) REFERENCES furniture(id)"+")";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(furnitureTable);
            stmt.execute(sofaTable);
            stmt.execute(bedTable);
        }
    }
}