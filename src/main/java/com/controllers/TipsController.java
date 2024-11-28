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

    public void tampilkanTips(int tipsId) {
        Tips tips = getTipsById(tipsId);
        new HalamanTipsUI(tips);
    }

    public Tips getTipsById(int id) {
        return databaseProvider.getTipsbyId(id);
    }

    public void tampilkanPesanError() {
        JOptionPane.showMessageDialog(null, "Artikel tidak ditemukan!");
    }
}
