package src.main.java.com.controllers;

import javax.swing.JOptionPane;
import src.main.java.com.models.Tips;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanTipsUI;

public class TipsController {
    private DatabaseProvider databaseProvider;

    public TipsController() {
        this.databaseProvider = new DatabaseProvider();
    }

    public void tampilkanHalamanTips() {
        new HalamanTipsUI();
    }

    public void tampilkanTips(int tipsId) {
        Tips tips = getTipsById(tipsId);
        new HalamanTipsUI();
    }

    public Tips getTipsById(int id) {
        // Contoh data
        if (id == 1) return new Tips(1, "Memulai Gaya Hidup Ramah Lingkungan dan Manfaatnya", "Rheem", "src\\main\\resources\\images\\art1.png", "https://rheem.id/blog/gaya-hidup-ramah-lingkungan/");
        if (id == 2) return new Tips(2, "Mari Kelola Sampah Dengan Bijak Mulai Hari Ini", "Citarum Harum Juara", "src\\main\\resources\\images\\art2.png", "https://citarumharum.jabarprov.go.id/mari-kelola-sampah-dengan-bijak-mulai-hari-ini/");
        return null;
    }

    public void tampilkanPesanError() {
        JOptionPane.showMessageDialog(null, "Artikel tidak ditemukan!");
    }
}
