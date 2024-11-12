package src.main.java.com.controllers;

import src.main.java.com.models.Login;
import src.main.java.com.providers.UserProvider;
import src.main.java.com.ui.HalamanUtamaUI;

public class LoginController {
    private UserProvider userProvider;
    private HalamanUtamaUI halamanUtamaUI;
    
    public LoginController() {
        userProvider = new UserProvider();
        halamanUtamaUI = new HalamanUtamaUI();
    }
    
    public void TampilkanHalamanUtama(Login login) {
        if (userProvider.isValidUser(login)) {
            halamanUtamaUI.tampilkan();
        }
    }

    public boolean verifikasiAkun(Login login) {
        return userProvider.isValidUser(login);
    }

    public boolean checkUsernamePassword(Login login) {
        return userProvider.checkUsernamePassword(login);
    }

    public boolean checkData(Login login) {
        return userProvider.checkData(login);
    }

    public String tampilkanPasswordLama(Login login) {
        return userProvider.tampilkanPasswordLama(login);
    }
}