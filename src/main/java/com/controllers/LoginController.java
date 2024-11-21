package src.main.java.com.controllers;

import java.time.LocalDate;
import src.main.java.com.models.RegisterLogin;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.providers.UserProvider;
import src.main.java.com.ui.LupaPasswordUI;
import src.main.java.com.models.User;

public class LoginController {

    private UserProvider userProvider;

    public LoginController() {
        this.userProvider = new UserProvider();
    }

    // Method untuk menampilkan halaman login
    public void tampilkanHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        new HalamanLoginUI(registerLogin);
    }

    // Method untuk mengecek apakah username dan password sudah benar
    public boolean checkUsernamePassword(String username, String password) {
        User user = userProvider.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanError() {
        HalamanLoginUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses login
    public boolean checkData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        return userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu) != null;
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanErrorLupa() {
        LupaPasswordUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses lupa password
    public void tampilkanPesanSuksesLupa(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        User user = userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
        if (user != null) {
            LupaPasswordUI.pesanSukses(user.getUsername(), user.gettglLahir(), user.getnamaIbu());
        }
    }

    // Method untuk mendapatkan username
    public String getUsername(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        User user = userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
        return user != null ? user.getUsername() : null;
    }

    // Method untuk mendapatkan password
    public String getPassword(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        User user = userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu);
        return user != null ? user.getPassword() : null;
    }
}