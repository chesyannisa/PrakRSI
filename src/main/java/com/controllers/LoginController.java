// package src.main.java.com.controllers;

// import src.main.java.com.models.RegisterLogin;
// import src.main.java.com.providers.UserProvider;
// import src.main.java.com.ui.HalamanUtamaUI;

// public class LoginController {
//     private UserProvider userProvider;
//     private HalamanUtamaUI halamanUtamaUI;
    
//     public LoginController() {
//         userProvider = new UserProvider();
//         halamanUtamaUI = new HalamanUtamaUI();
//     }
    
//     public void TampilkanHalamanUtama(RegisterLogin login) {
//         if (userProvider.isValidUser(login)) {
//             halamanUtamaUI.tampilkan();
//         }
//     }

//     public boolean verifikasiAkun(RegisterLogin login) {
//         return userProvider.isValidUser(login);
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