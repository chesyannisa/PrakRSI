package src.main.java.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    // Metode untuk insert data user ke tabel user_provider
    public static void insertUser(String username, String namaLengkap, String tanggalLahir, 
                                  String namaLengkapIbu, String password, 
                                  String konfirmasiPass, boolean role) throws SQLException {
        String sql = "INSERT INTO user_provider (username, namaLengkap, tanggalLahir, namaLengkapIbu, password, konfirmasiPass, role) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set nilai untuk setiap parameter
            stmt.setString(1, username);
            stmt.setString(2, namaLengkap);
            stmt.setString(3, tanggalLahir);
            stmt.setString(4, namaLengkapIbu);
            stmt.setString(5, password);
            stmt.setString(6, konfirmasiPass);
            stmt.setBoolean(7, role);
            // Eksekusi query
            stmt.executeUpdate();
        }
    }
}
