package src.main.java.com.controllers;

import java.time.LocalDate;
import src.main.java.com.models.User;
import src.main.java.com.ui.HalamanRegisterUI;
import src.main.java.com.providers.UserProvider;

public class RegisterController {
    public void tampilkanHalamanRegister() {
        new HalamanRegisterUI();
    }
    public void InsertData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) {
        UserProvider userProvider = new UserProvider();
        User newUser = new User(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
        userProvider.addUser(newUser);
    }

    public void tampilkanPesanErrorKonfirmasi() {
        HalamanRegisterUI.pesanErrorKonfirmasi();
    }

    public void tampilkanPesanSuksesRegistrasi() {
        HalamanRegisterUI.pesanSuksesRegistrasi();
    }
}
