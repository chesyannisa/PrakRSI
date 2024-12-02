package src.main.java.com.controllers;

import java.net.URI;
import java.awt.Desktop;

import javax.swing.JOptionPane;
import src.main.java.com.models.Tips;
import src.main.java.com.providers.TipsProvider;
import src.main.java.com.ui.HalamanTipsUI;

public class TipsController {
    TipsProvider tipsProvider;

    public TipsController() {
        this.tipsProvider = new TipsProvider();
    }

    public void tampilkanHalamanTips() {
        new HalamanTipsUI();
    }

    public void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membuka URL: " + e.getMessage());
        }
    }

    public Tips getTipsById(int id) {
        return tipsProvider.getTipsById(id);
    }

    public void tampilkanPesanError() {
        JOptionPane.showMessageDialog(null, "Artikel tidak ditemukan!");
    }
}
