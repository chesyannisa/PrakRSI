package src.main.java.com.controllers;
import src.main.java.com.ui.HalamanProfilUI;
import src.main.java.com.ui.HalamanEditProfilUI;
public class ProfileController {
    // Method untuk menampilkan halaman profil
    public void tampilkanHalamanProfil() {
        new HalamanProfilUI();
    }

    // Method untuk menampilkan halaman edit profil
    public void tampilkanHalamanEditProfil() {
        new HalamanEditProfilUI();
    }
}
