package src.main.java.com.controllers;

import java.time.LocalDate;
import src.main.java.com.models.User;
import java.sql.SQLException;
import src.main.java.com.ui.HalamanRegisterUI;
import src.main.java.com.providers.DatabaseProvider;

public class RegisterController {
    // Method untuk menampilkan halaman register
    public void tampilkanHalamanRegister() {
        new HalamanRegisterUI();
    }

    // Method untuk memasukkan data user ke database
    public void InsertData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) {
        DatabaseProvider databaseProvider = new DatabaseProvider();
        User newUser = new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
        try {
            databaseProvider.addUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mengecek apakah username sudah ada di database
    public void tampilkanPesanErrorKonfirmasi() {
        HalamanRegisterUI.pesanErrorKonfirmasi();
    }

    // Method untuk menampilkan pesan sukses registrasi
    public void tampilkanPesanSuksesRegistrasi() {
        HalamanRegisterUI.pesanSuksesRegistrasi();
    }
}
