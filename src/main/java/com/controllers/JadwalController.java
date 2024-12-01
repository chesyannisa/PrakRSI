package src.main.java.com.controllers;

import javax.swing.JOptionPane;

import src.main.java.com.providers.DatabaseProvider;
import src.main.java.com.ui.HalamanJadwalUI;

public class JadwalController {
    private DatabaseProvider databaseProvider;
    
    public JadwalController()   {
        this.databaseProvider = new DatabaseProvider();
    }

    public void tampilkanHalamanJadwal() {
        new HalamanJadwalUI();
    }}
