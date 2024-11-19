package src.main.java.com.controllers;

import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.providers.UserProvider;
// import src.main.java.com.ui.HalamanUtamaUI;
import src.main.java.com.ui.HalamanLoginUI;

public class LoginController {
    public void showHalamanLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
        HalamanLoginUI halamanLoginUI = new HalamanLoginUI(registerLogin);
    }
}