package src.main.java.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
    public void addUser(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) throws SQLException {
        String sql = "INSERT INTO user_provider (username, namaLengkap, tanggalLahir, namaIbu, password, role) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
            // Set nilai untuk setiap parameter
            stmt.setString(1, namaLengkap);
            stmt.setDate(2, java.sql.Date.valueOf(tglLahir));
            stmt.setString(3, namaIbu);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, roleUser);
            // Eksekusi query
            stmt.executeUpdate();
    }
}
