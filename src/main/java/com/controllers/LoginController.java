// package src.main.java.com.controllers;

// import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.providers.UserProvider;
// import src.main.java.com.ui.HalamanUtamaUI;
// import src.main.java.com.ui.HalamanLoginUI;

// public class LoginController {
//     private UserProvider userProvider;
//     private HalamanUtamaUI halamanUtamaUI;
//     private HalamanLoginUI halamanLoginUI;
    
//     public void TampilkanHalamanUtama() {
//         halamanUtamaUI = new HalamanUtamaUI();
//     }

//     public boolean verifikasiAkun() {
//         if (checkUsernamePassword(login)) {
//             TampilkanHalamanUtama();
//             return true;
//         } else {
//             halamanLoginUI.showErrorMessage("Username or password is incorrect.");
//             return false;
//         }
//     }

//     public boolean checkUsernamePassword(RegisterLogin login) {
//         return userProvider.checkUsernamePassword(login);
//     }

//     public boolean checkData(RegisterLogin login) {
//         return userProvider.checkData(login);
//     }

//     public String tampilkanPasswordLama(RegisterLogin login) {
//         return userProvider.tampilkanPasswordLama(login);
//     }
// }