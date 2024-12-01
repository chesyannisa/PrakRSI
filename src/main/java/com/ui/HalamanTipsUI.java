package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.main.java.com.controllers.TipsController;
import src.main.java.com.models.Tips;

public class HalamanTipsUI {
    private TipsController tipsController;

    public HalamanTipsUI() {
        tipsController = new TipsController();

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

        // Panel untuk daftar artikel (scrollable)
        JPanel artikelPanel = new JPanel();
        artikelPanel.setLayout(new BoxLayout(artikelPanel, BoxLayout.Y_AXIS));
        artikelPanel.setBackground(new Color(203, 215, 176));

        // Tambahkan beberapa artikel ke dalam artikelPanel
        for (int i = 1; i <= 10; i++) {
            final int artikelId = i;
            Tips tips = tipsController.getTipsById(artikelId);
            if (tips != null) {
                artikelPanel.add(createButtonWithLabel("src\\main\\resources\\images\\tipsntrik.png", tips.getJudul(), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showTips(artikelId);
                        JOptionPane.showMessageDialog(null, "Artikel dibuka!");
                    }
                }));
                
            } else {
                artikelPanel.add((createButtonWithLabel("src\\main\\resources\\images\\tipsntrik.png", "Artikel tidak ditemukan", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showPesanError();
                    }
                })));
            }
            artikelPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Jarak antar artikel
        }

        // Membuat JScrollPane untuk membungkus artikelPanel
        JScrollPane scrollPane = new JScrollPane(artikelPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Kecepatan scroll

        // Tambahkan panel ke frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tampilkan frame
        frame.setVisible(true);
    }

    // Membuat tombol fitur dengan teks di bawahnya
    private JPanel createButtonWithLabel(String iconPath, String labelText, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(203, 215, 176));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margin kecil

        JButton button = createImageButton(iconPath, 350, 150, actionListener);
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

    // Method untuk menampilkan tips
    private void showTips(int tipsId) {
        TipsController tipsController = new TipsController();
        tipsController.tampilkanTips(tipsId);
    }

    // Method untuk menampilkan pesan error
    private void showPesanError() {
        tipsController.tampilkanPesanError();
    }

    // Controller untuk menampilkan halaman tips
    public HalamanTipsUI(Tips tips) {
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
        JLabel titleLabel = new JLabel(tips.getJudul());
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Penulis artikel
        JLabel authorLabel = new JLabel("Penulis: " + tips.getPenulis());
        authorLabel.setFont(new Font("Nunito", Font.PLAIN, 18));
        authorLabel.setForeground(new Color(83, 53, 74));
        authorLabel.setHorizontalAlignment(JLabel.CENTER);
        authorLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        bottomPanel.setBackground(new Color(203, 215, 176));

        RoundedButton backButton = new RoundedButton("Back", 30);
        backButton.setForeground(new Color(83, 53, 74));

        // ActionListener untuk tombol "Back"
        backButton.addActionListener(e -> {
            new HalamanUtamaUI(); // Ganti dengan halaman utama Anda
            frame.dispose();
        });
        bottomPanel.add(backButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Konten artikel
        JTextArea contentArea = new JTextArea(tips.getIsi());
        contentArea.setFont(new Font("Nunito", Font.PLAIN, 18));
        contentArea.setForeground(new Color(83, 53, 74));
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setEditable(false);
        contentArea.setBackground(new Color(203, 215, 176));
        contentArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane contentScrollPane = new JScrollPane(contentArea);
        contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(contentScrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HalamanTipsUI();
        Tips tips = new Tips(1, "Judul Artikel", "Penulis","Isi", "url");
    }
}
