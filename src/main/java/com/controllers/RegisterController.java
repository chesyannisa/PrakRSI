package src.main.java.com.controllers;

import java.time.LocalDate;
import src.main.java.com.models.User;
import java.sql.SQLException;
import src.main.java.com.ui.HalamanRegisterUI;
import src.main.java.com.providers.DatabaseProvider;

public class RegisterController {
    public void tampilkanHalamanRegister() {
        new HalamanRegisterUI();
    }
    public void InsertData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) {
        DatabaseProvider databaseProvider = new DatabaseProvider();
        User newUser = new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
        try {
            databaseProvider.addUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tampilkanPesanErrorKonfirmasi() {
        HalamanRegisterUI.pesanErrorKonfirmasi();
    }

    public void tampilkanPesanSuksesRegistrasi() {
        HalamanRegisterUI.pesanSuksesRegistrasi();
    }
}
