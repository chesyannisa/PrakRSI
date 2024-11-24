package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.main.java.com.controllers.ProfileController;
import src.main.java.com.models.User;

public class HalamanTipsUI {

    public HalamanTipsUI(){
    // Membuat frame
    JFrame frame = new JFrame("ResikinAE: Tips & Trik Ramah Lingkungan");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    // Bagian atas (Logo dan Judul)
    JPanel topPanel = new JPanel(new BorderLayout());
    topPanel.setBackground(new Color(203, 215, 176));
    topPanel.setPreferredSize(new Dimension(0, 100));

    // Logo di kiri atas
    ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png"); // Path logo
    Image logoImage = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH); // Atur ukuran logo
    JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
    logoLabel.setHorizontalAlignment(JLabel.LEFT);
    logoLabel.setBorder(BorderFactory.createEmptyBorder(35, 20, 10, 10)); // Padding untuk logo

    // Judul di tengah
    JLabel titleLabel = new JLabel("Tips & Trik Ramah Lingkungan");
    titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
    titleLabel.setForeground(new Color(83, 53, 74));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

    topPanel.add(logoLabel, BorderLayout.WEST);
    topPanel.add(titleLabel, BorderLayout.CENTER);
    
    // Panel untuk bagian bawah (fitur)
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(new Color(203, 215, 176)); // Warna latar belakang
    bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

    // Panel untuk tombol fitur
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0)); // Jarak horizontal: 100px, vertikal: 0px
    buttonPanel.setBackground(new Color(203, 215, 176));

    // Membuat panel untuk setiap tombol dan teks dengan ActionListener
    buttonPanel.add(createButtonWithLabel("src\\\\main\\\\resources\\\\images\\\\tipsntrik.png", "Artikel 1", new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Menutup frame saat ini
            // JadwalController jadwalController = new JadwalController();
            // jadwalController.tampilkanHalamanJadwal();
        }
    }));

    buttonPanel.add(createButtonWithLabel("src\\main\\resources\\images\\tipsntrik.png", "Artikel 2", new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Menutup frame saat ini
            //TipsController tipsController = new TipsController();
            //tipsController.tampilkanHalamanTips();
        }
    }));

    buttonPanel.add(createButtonWithLabel("src\\main\\resources\\images\\tipsntrik.png", "Artikel 3", new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Menutup frame saat ini
            //TipsController tipsController = new TipsController();
            //tipsController.tampilkanHalamanTips();
        }
    }));

    // Menambahkan elemen ke bottomPanel
    bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    // bottomPanel.add(instructionLabel);
    bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    bottomPanel.add(buttonPanel);

    // Tambahkan panel ke frame
    frame.add(topPanel, BorderLayout.NORTH);
    frame.add(bottomPanel, BorderLayout.CENTER);

    // Tampilkan frame
    frame.setVisible(true);

    }

    // Membuat tombol fitur dengan teks di bawahnya
    private JPanel createButtonWithLabel(String iconPath, String labelText, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(203, 215, 176));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margin kecil

        JButton button = createImageButton(iconPath, 100, 100, actionListener);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Nunito", Font.BOLD, 18));
        label.setForeground(new Color(83, 53, 74));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Jarak kecil antara tombol dan label
        panel.add(label);

        return panel;
    }
  
    // Membuat tombol fitur dengan ikon
    private JButton createImageButton(String iconPath, int width, int height, ActionListener actionListener) {
        ImageIcon originalIcon = new ImageIcon(iconPath); // Muat gambar asli
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Ubah ukuran gambar
        ImageIcon scaledIcon = new ImageIcon(scaledImage); // Buat ikon baru dari gambar yang sudah diubah ukurannya

        JButton button = new JButton(scaledIcon); // Gunakan ikon baru untuk tombol
        button.setBorderPainted(false); // Menghapus border tombol
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false); // Menghapus highlight ketika tombol dipilih
        button.setPreferredSize(new Dimension(width, height)); // Atur ukuran tombol sesuai gambar
        button.addActionListener(actionListener); // Tambahkan ActionListener untuk menangkap klik tombol
        return button;
    }





    public static void main(String[] args) {
        new HalamanTipsUI();
    }
}
