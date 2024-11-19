package src.main.java.com.controllers;

import java.time.LocalDate;

import src.main.java.com.models.RegisterLogin;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.providers.UserProvider;
import src.main.java.com.ui.LupaPasswordUI;

public class LoginController {
    public void tampilkanHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        HalamanLoginUI halamanLoginUI = new HalamanLoginUI(registerLogin);
    }

    public boolean checkUsernamePassword(String Username, String Password) {
        UserProvider userProvider = new UserProvider();
        boolean userExists = false;
        if (userProvider.getUserByUsername(Username) != null) {
            userExists = userProvider.getUserByUsername(Username).getPassword().equals(Password);
        }
        return userExists;
    }

    public void tampilkanPesanError() {
        HalamanLoginUI.pesanError();
    }

    public boolean checkData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        boolean userExists = false;
        if (userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu) != null) {
            userExists = true;
        }
        return userExists;
    }

    public void tampilkanPesanErrorLupa() {
        LupaPasswordUI.pesanError();
    }

    public void tampilkanPesanSuksesLupa(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        LupaPasswordUI.pesanSukses(namaLengkap, tglLahir, namaIbu);
    }

    public String getUsername(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        return userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu).getUsername();
    }

    public String getPassword(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        UserProvider userProvider = new UserProvider();
        return userProvider.getUserByNamaLengkap(namaLengkap, tglLahir, namaIbu).getPassword();
    }
}