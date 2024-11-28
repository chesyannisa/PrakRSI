package src.main.java.com.controllers;

import java.time.LocalDate;
import java.sql.SQLException;

import src.main.java.com.models.User;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanRegisterUI;

public class RegisterController {
    private DatabaseProvider databaseProvider;

    public RegisterController () {
        this.databaseProvider = new DatabaseProvider();
    }
    
    // Method untuk menampilkan halaman register
    public void tampilkanHalamanRegister() {
        new HalamanRegisterUI();
    }

    // Method untuk memasukkan data user ke database
    public void InsertData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser, String phoneNumber) {
        User newUser = new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser, phoneNumber);
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
