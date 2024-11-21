package src.main.java.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import src.main.java.com.models.User;

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
    public void addUser(User newUser) throws SQLException {
        String sql = "INSERT INTO user_provider (username, namaLengkap, tanggalLahir, namaIbu, password, role) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
            // Set nilai untuk setiap parameter
            stmt.setString(1, newUser.getnamaLengkap());
            stmt.setDate(2, java.sql.Date.valueOf(newUser.gettglLahir()));
            stmt.setString(3, newUser.getnamaIbu());
            stmt.setString(4, newUser.getUsername());
            stmt.setString(5, newUser.getPassword());
            stmt.setString(6, newUser.getRoleUser());
            // Eksekusi query
            stmt.executeUpdate();
    }
}
