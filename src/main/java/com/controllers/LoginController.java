package src.main.java.com.controllers;

import java.time.LocalDate;
import java.sql.SQLException;

import src.main.java.com.models.RegisterLogin;
import src.main.java.com.models.User;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.ui.LupaPasswordUI;

public class LoginController {
    private DatabaseProvider databaseProvider;

    public LoginController() {
        this.databaseProvider = new DatabaseProvider();
    }

    public void tampilkanHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        new HalamanLoginUI(registerLogin);
    }

    public boolean checkUsernamePassword(String username, String password) {
        try {
            User user = databaseProvider.getUserByUsername(username);
            return user != null && user.getPassword().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void tampilkanPesanError() {
        HalamanLoginUI.pesanError();
    }

    public boolean checkData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            return databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu) != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void tampilkanPesanErrorLupa() {
        LupaPasswordUI.pesanError();
    }

    public void tampilkanPesanSuksesLupa(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            User user = databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
            if (user != null) {
                LupaPasswordUI.pesanSukses(user.getUsername(), user.getTglLahir(), user.getNamaIbu());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        try {
            User user = databaseProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
            return user != null ? user.getUsername() : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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