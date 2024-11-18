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

        // Panel untuk tombol fitur
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30)); // Posisi tombol di tengah dengan jarak
        buttonPanel.setBackground(new Color(203, 215, 176));

        // Tombol Tips & Trik
        RoundedButton tipsButton = createFeatureButton("Tips & Trik", "src\\main\\resources\\tipsntrik.png");
        tipsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigasi ke halaman Tips & Trik
                System.out.println("Tips & Trik button clicked");
            }
        });

        // Tombol Jadwal
        RoundedButton scheduleButton = createFeatureButton("Jadwal", "src\\main\\resources\\jadwal.png");
        scheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigasi ke halaman Jadwal
                System.out.println("Jadwal button clicked");
            }
        });

        // Tombol Profil
        RoundedButton profileButton = createFeatureButton("Profil", "src\\main\\resources\\profil.png");
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigasi ke halaman Profil
                System.out.println("Profil button clicked");
            }
        });

        // Menambahkan tombol ke panel
        buttonPanel.add(tipsButton);
        buttonPanel.add(scheduleButton);
        buttonPanel.add(profileButton);

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

    // Membuat tombol fitur dengan ikon
    private RoundedButton createFeatureButton(String text, String iconPath) {
        RoundedButton button = new RoundedButton(text, 30);
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(83, 53, 74));
        button.setFont(new Font("Nunito", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon(iconPath)); // Tambahkan ikon
        button.setHorizontalTextPosition(SwingConstants.CENTER); // Teks di bawah ikon
        button.setVerticalTextPosition(SwingConstants.BOTTOM); // Teks di bawah ikon
        button.setPreferredSize(new Dimension(150, 150)); // Ukuran tombol
        return button;
    }

    public static void main(String[] args) {
        new HalamanUtamaUI();
    }
}