package src.main.java.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import src.main.java.com.models.User;

public class DatabaseProvider {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/resikinae_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "BeLlA04_";

    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM user_provider WHERE username = ?";
    private static final String SELECT_USER_BY_NAMA_LENGKAP = "SELECT * FROM user_provider WHERE namaLengkap = ? AND tanggalLahir = ? AND namaIbu = ?";
    private static final String INSERT_USER = "INSERT INTO user_provider (username, namaLengkap, tanggalLahir, namaIbu, password, role) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE user_provider SET namaLengkap = ?, password = ? WHERE username = ?";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL tidak ditemukan", e);
        }
    }

    public void addUser(User newUser) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getNamaLengkap());
            preparedStatement.setDate(3, java.sql.Date.valueOf(newUser.getTglLahir()));
            preparedStatement.setString(4, newUser.getNamaIbu());
            preparedStatement.setString(5, newUser.getPassword());
            preparedStatement.setString(6, newUser.getRoleUser());
            preparedStatement.executeUpdate();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String namaLengkap = resultSet.getString("namaLengkap");
                    LocalDate tglLahir = resultSet.getDate("tanggalLahir").toLocalDate();
                    String namaIbu = resultSet.getString("namaIbu");
                    String password = resultSet.getString("password");
                    String roleUser = resultSet.getString("role");
                    return new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
                }
            }
        }
        return null;
    }

    public User getUserByNamaLengkap(String namaLengkap, LocalDate tglLahir, String namaIbu) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAMA_LENGKAP)) {
            preparedStatement.setString(1, namaLengkap);
            preparedStatement.setDate(2, java.sql.Date.valueOf(tglLahir));
            preparedStatement.setString(3, namaIbu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String roleUser = resultSet.getString("role");
                    return new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
                }
            }
        }
        return null;
    }

    public void updateUser(User user) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getNamaLengkap());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.executeUpdate();
        }
    }
}