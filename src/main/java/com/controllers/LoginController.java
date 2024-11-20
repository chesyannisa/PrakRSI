package src.main.java.com.controllers;

import java.time.LocalDate;

import src.main.java.com.models.RegisterLogin;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.providers.UserProvider;
import src.main.java.com.ui.LupaPasswordUI;

public class LoginController {
    // Method untuk menampilkan halaman login
    public void tampilkanHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        new HalamanLoginUI(registerLogin);
    }

    // Method untuk mengecek apakah username dan password sudah benar
    public boolean checkUsernamePassword(String Username, String Password) {
        UserProvider userProvider = new UserProvider();
        boolean userExists = false;
        if (userProvider.getUserByUsername(Username) != null) {
            userExists = userProvider.getUserByUsername(Username).getPassword().equals(Password);
        }
        return userExists;
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanError() {
        HalamanLoginUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses login
    public boolean checkData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        boolean userExists = false;
        if (userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu) != null) {
            userExists = true;
        }
        return userExists;
    }

    // Method untuk menampilkan pesan error
    public void tampilkanPesanErrorLupa() {
        LupaPasswordUI.pesanError();
    }

    // Method untuk menampilkan pesan sukses lupa password
    public void tampilkanPesanSuksesLupa(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        LupaPasswordUI.pesanSukses(namaLengkap, tglLahir, namaIbu);
    }

    // Method untuk mendapatkan username
    public String getUsername(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        return userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu).getUsername();
    }

    // Method untuk mendapatkan password
    public String getPassword(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        return userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu).getPassword();
    }
}