package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanUtamaUI {

    public HalamanUtamaUI() {
        // Membuat frame utama
        JFrame frame = new JFrame("ResikinAE");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Atur layout utama
        frame.setLayout(new BorderLayout());

        // Panel untuk bagian atas (logo dan judul)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.WHITE);

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon("src\\main\\resources\\logo.png"));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Judul
        JLabel titleLabel = new JLabel("Selamat datang di");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 24));
        titleLabel.setForeground(new Color(83, 53, 74)); // Warna judul
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Jarak
        topPanel.add(titleLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Jarak
        topPanel.add(logoLabel);

        // Panel untuk bagian bawah (fitur)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(203, 215, 176)); // Warna latar belakang
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JLabel instructionLabel = new JLabel("Silahkan Pilih Fitur yang Diinginkan");
        instructionLabel.setFont(new Font("Nunito", Font.BOLD, 18));
        instructionLabel.setForeground(new Color(83, 53, 74));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel untuk tombol fitur dan label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 30, 10)); // 2 baris (ikon dan label), 3 kolom
        buttonPanel.setBackground(new Color(203, 215, 176));

        // Tombol Tips & Trik
        RoundedButton tipsButton = createRoundedIconButton("src\\main\\resources\\tipsntrik.png");
        JLabel tipsLabel = createFeatureLabel("Tips & Trik");
        buttonPanel.add(tipsButton);
        buttonPanel.add(tipsLabel);

        // Tombol Jadwal
        RoundedButton scheduleButton = createRoundedIconButton("src\\main\\resources\\jadwal.png");
        JLabel scheduleLabel = createFeatureLabel("Jadwal");
        buttonPanel.add(scheduleButton);
        buttonPanel.add(scheduleLabel);

        // Tombol Profil
        RoundedButton profileButton = createRoundedIconButton("src\\main\\resources\\profil.png");
        JLabel profileLabel = createFeatureLabel("Profil");
        buttonPanel.add(profileButton);
        buttonPanel.add(profileLabel);

        // Menambahkan elemen ke bottomPanel
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bottomPanel.add(instructionLabel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bottomPanel.add(buttonPanel);

        // Tambahkan panel ke frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);

        // Tampilkan frame
        frame.setVisible(true);
    }

    // Membuat tombol rounded hanya dengan ikon
    private RoundedButton createRoundedIconButton(String iconPath) {
        RoundedButton button = new RoundedButton("", 30); // Tombol tanpa teks
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setIcon(new ImageIcon(iconPath)); // Tambahkan ikon
        button.setPreferredSize(new Dimension(100, 100)); // Ukuran tombol
        return button;
    }

    // Membuat label untuk teks di bawah tombol
    private JLabel createFeatureLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Nunito", Font.BOLD, 16));
        label.setForeground(new Color(83, 53, 74));
        label.setHorizontalAlignment(SwingConstants.CENTER); // Tengah
        return label;
    }

    public static void main(String[] args) {
        new HalamanUtamaUI();
    }
}
