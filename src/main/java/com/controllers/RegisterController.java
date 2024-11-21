package src.main.java.com.controllers;
import java.time.LocalDate;
import src.main.java.com.models.User;
import java.sql.SQLException;
import src.main.java.com.ui.HalamanRegisterUI;
import src.main.java.com.providers.DatabaseProvider;

public class RegisterController {
    private DatabaseProvider databaseProvider;

    public RegisterController(DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    // Method untuk menampilkan halaman register
    public void tampilkanHalamanRegister() {
        new HalamanRegisterUI();
    }

    // Method untuk memasukkan data user ke database
    public void insertData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) {
        User newUser = new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
        try {
            databaseProvider.addUser(newUser);
            tampilkanPesanSuksesRegistrasi();
        } catch (SQLException e) {
            e.printStackTrace();
            tampilkanPesanErrorKonfirmasi();
        }
    }

    // Method untuk menampilkan pesan error konfirmasi
    public void tampilkanPesanErrorKonfirmasi() {
        HalamanRegisterUI.pesanErrorKonfirmasi();
    }

    // Method untuk menampilkan pesan sukses registrasi
    public void tampilkanPesanSuksesRegistrasi() {
        HalamanRegisterUI.pesanSuksesRegistrasi();
    }
}