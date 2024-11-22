package src.main.java.com.controllers;
import java.time.LocalDate;
import src.main.java.com.models.RegisterLogin;
import java.sql.SQLException;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.ui.LupaPasswordUI;
import src.main.java.com.models.User;
import src.main.java.com.providers.DatabaseProvider;

public class LoginController {

    private DatabaseProvider databaseProvider;

    public LoginController() {
        this.databaseProvider = new DatabaseProvider();
    }

    // Method untuk menampilkan halaman login
    public void tampilkanHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        new HalamanLoginUI(registerLogin);
    }

    // Method untuk mengecek apakah username dan password sudah benar
    public boolean checkUsernamePassword(String username, String password) {
        try {
            User user = databaseProvider.getUserByUsername(username);
            return user != null && user.getPassword().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanError() {
        HalamanLoginUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses login
    public boolean checkData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            return databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu) != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanErrorLupa() {
        LupaPasswordUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses lupa password
    public void tampilkanPesanSuksesLupa(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            User user = databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
            if (user != null) {
                LupaPasswordUI.pesanSukses(user.getUsername(), user.gettglLahir(), user.getnamaIbu());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mendapatkan username
    public String getUsername(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            User user = databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
            return user != null ? user.getUsername() : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method untuk mendapatkan password
    public String getPassword(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            User user = databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
            return user != null ? user.getPassword() : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}