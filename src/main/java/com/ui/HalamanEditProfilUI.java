package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanEditProfilUI {

    public HalamanEditProfilUI() {
        JFrame frame = new JFrame("ResikinAE: Edit Profile");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Bagian atas (Logo dan Judul)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(203, 215, 176));
        topPanel.setPreferredSize(new Dimension(0, 200));

        // Logo di kiri atas
        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png"); // Path logo
        Image logoImage = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH); // Atur ukuran logo
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(35, 20, 10, 10)); // Padding untuk logo

        // Judul di tengah
        JLabel titleLabel = new JLabel("Edit Profil");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        // Bagian tengah: form edit profil
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(225, 235, 215)); // Warna hijau lembut
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Nama Lengkap
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Lengkap:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Input Tanggal Lahir
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        JTextField birthDateField = new JTextField(20);
        formPanel.add(birthDateField, gbc);

        // Input Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Kata Sandi:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Input Nomor Telepon
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("No Telepon:"), gbc);

        gbc.gridx = 1;
        JTextField phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);

        // Tombol Simpan
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        RoundedButton saveButton = new RoundedButton("Simpan", 30);
        saveButton.setBackground(new Color(166, 179, 125)); // Warna hijau lembut
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setFont(new Font("Nunito", Font.BOLD, 16));
        formPanel.add(saveButton, gbc);

        // Tombol Batal
        gbc.gridy = 5;
        RoundedButton cancelButton = new RoundedButton("Batal", 30);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setFont(new Font("Nunito", Font.BOLD, 16));
        formPanel.add(cancelButton, gbc);

        frame.add(formPanel, BorderLayout.CENTER);



        // Aksi tombol Batal
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanProfilUI(); // Kembali ke halaman profil
                frame.dispose();
            }
        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HalamanEditProfilUI();
    }
}
