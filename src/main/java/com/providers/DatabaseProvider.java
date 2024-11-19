package src.main.java.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/resikinae_db";
    private static final String DB_USER = "root"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "BeLlA04_"; // Ganti dengan password database Anda

    public static Connection getConnection() throws SQLException {
        try {
            // Load driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Return koneksi
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            // Throw exception jika driver tidak ditemukan
            throw new SQLException("Driver MySQL tidak ditemukan", e);
        }
    }
}
