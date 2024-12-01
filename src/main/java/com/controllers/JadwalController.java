package src.main.java.com.controllers;

import src.main.java.com.models.Jadwal;
import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanJadwalUI;

import java.sql.SQLException;
import java.util.List;

public class JadwalController {
    private DatabaseProvider databaseProvider;
    
    public JadwalController()   {
        this.databaseProvider = new DatabaseProvider();
    }

    public void tampilkanHalamanJadwal() {
        new HalamanJadwalUI();
    }

    public List<Jadwal> getJadwal() {
        try {
            return databaseProvider.getAllJadwal();
        } catch (SQLException e) {
            e.printStackTrace();
            HalamanJadwalUI.showPesanError();
            return null;
        }
    }
}
