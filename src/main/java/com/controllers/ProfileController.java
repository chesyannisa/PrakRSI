package src.main.java.com.controllers;

import java.sql.SQLException;

import src.main.java.com.ui.HalamanProfilUI;
import src.main.java.com.ui.HalamanEditProfilUI;
import src.main.java.com.models.User;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.models.RegisterLogin;


public class ProfileController {
    private DatabaseProvider databaseProvider;
    private RegisterLogin registerLogin;

    public ProfileController() {
        this.databaseProvider = new DatabaseProvider();
        this.registerLogin = new RegisterLogin();
    }

    // Method untuk menampilkan halaman profil
    public void tampilkanHalamanProfil() {
        User loggedInUser = registerLogin.getUserData();
        new HalamanProfilUI(loggedInUser.getUsername());
    }

    // Method untuk menampilkan halaman edit profil
    public void tampilkanHalamanEditProfil(String username) {
        new HalamanEditProfilUI(username);
    }

    // Method untuk mendapatkan data user dari database
    public User getUserData(String username) {
        try {
            return databaseProvider.getUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method untuk memperbarui data user di database
    public void updateUser(User user) throws SQLException {
        databaseProvider.updateUser(user);
    }
}