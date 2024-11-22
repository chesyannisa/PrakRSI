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

    public Connection getConnection() throws SQLException {
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

    public void addUser(User newUser) throws SQLException {
        String query = "INSERT INTO user_provider (username, namaLengkap, tanggalLahir, namaIbu, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getnamaLengkap());
            preparedStatement.setDate(3, java.sql.Date.valueOf(newUser.gettglLahir()));
            preparedStatement.setString(4, newUser.getnamaIbu());
            preparedStatement.setString(5, newUser.getPassword());
            preparedStatement.setString(6, newUser.getRoleUser());
            preparedStatement.executeUpdate();
        }
    }
}