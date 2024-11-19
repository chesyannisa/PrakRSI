package src.main.java.com.controllers;

import javax.swing.JOptionPane;

import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.providers.UserProvider;
// import src.main.java.com.ui.HalamanUtamaUI;
import src.main.java.com.ui.HalamanLoginUI;
import src.main.java.com.providers.UserProvider;

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
}