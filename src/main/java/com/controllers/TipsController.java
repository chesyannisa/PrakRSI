package src.main.java.com.controllers;

import src.main.java.com.models.Tips;
import src.main.java.com.providers.TipsProvider;
import src.main.java.com.ui.HalamanTipsUI;

import javax.swing.JOptionPane;
import java.util.List;

public class TipsController {
    private TipsProvider tipsProvider;

    public TipsController() {
        this.tipsProvider = new TipsProvider();
    }

    public void tampilkanHalamanTips() {
        new HalamanTipsUI();
    }

    public void tampilkanTips(int id) {
        Tips tips = tipsProvider.getTips(id);
        if (tips != null) {
            new HalamanTipsUI(tips);
        } else {
            tampilkanPesanError();
        }
    }

    public List<Tips> getAllTips() {
        return tipsProvider.getAllTips();
    }

    public void tampilkanPesanError() {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "Error", JOptionPane.ERROR_MESSAGE);
    }
}