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
        JButton tipsButton = createImageButton("src\\main\\resources\\tipsntrik.png",100,100);
        tipsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Tips & Trik button clicked");
        }
        });

        JButton scheduleButton = createImageButton("src\\main\\resources\\jadwal.png",100,100);
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Jadwal button clicked");
            }
        });


        // Tombol Profil
        JButton profileButton = createImageButton("src\\main\\resources\\profil.png",100, 100);
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Profil button clicked");
            }
        });

        // Menambahkan tombol ke panel
        buttonPanel.add(scheduleButton);
        buttonPanel.add(tipsButton);
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
    private JButton createImageButton(String iconPath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(iconPath); // Muat gambar asli
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Ubah ukuran gambar
        ImageIcon scaledIcon = new ImageIcon(scaledImage); // Buat ikon baru dari gambar yang sudah diubah ukurannya
    
        JButton button = new JButton(scaledIcon); // Gunakan ikon baru untuk tombol
        button.setBorderPainted(false); // Menghapus border tombol
        button.setBackground(Color.WHITE);
        button.setFocusPainted(true); // Menghapus highlight ketika tombol dipilih
        button.setPreferredSize(new Dimension(width, height)); // Atur ukuran tombol sesuai gambar
        return button;
    }
}