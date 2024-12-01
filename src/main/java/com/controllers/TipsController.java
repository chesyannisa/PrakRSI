package src.main.java.com.controllers;

import javax.swing.JOptionPane;

import src.main.java.com.models.Tips;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanTipsUI;

public class TipsController {
    private DatabaseProvider databaseProvider;
    
    public TipsController()   {
        this.databaseProvider = new DatabaseProvider();
    }

    public void tampilkanHalamanTips() {
        new HalamanTipsUI();
    }

    public void tampilkanTips(int tipsId) {
        Tips tips = getTipsById(tipsId);
        new HalamanTipsUI(tips);
    }

    public Tips getTipsById(int id) {
        // Contoh data
        if (id == 1) return new Tips(1, "Judul Artikel 1", "Penulis", "Isi artikel 1", "https://example.com/article1");
        if (id == 2) return new Tips(2, "Judul Artikel 2", "Penulis", "Isi artikel 2", "https://example.com/article2");
        return null;
    }
    

    public void tampilkanPesanError() {
        JOptionPane.showMessageDialog(null, "Artikel tidak ditemukan!");
    }
}
