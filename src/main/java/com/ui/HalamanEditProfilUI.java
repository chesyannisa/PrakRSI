package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

import src.main.java.com.controllers.ProfileController;
import src.main.java.com.models.User;

public class HalamanEditProfilUI {
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField phoneField;

    public HalamanEditProfilUI(String username) {
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
        Image logoImage = logoIcon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH); // Atur ukuran logo
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
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Nama Lengkap
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Lengkap:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Input Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        // Input Kata Sandi
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Kata Sandi:"), gbc);

        gbc.gridx = 1;
        passwordField = new JTextField(20);
        formPanel.add(passwordField, gbc);

        // Input Nomor Telepon
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("No Telepon:"), gbc);

        gbc.gridx = 1;
        phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);

        // Fetch and set user data
        ProfileController profileController = new ProfileController();
        User user = profileController.getUserData(username);
        if (user != null) {
            nameField.setText(user.getNamaLengkap());
            usernameField.setText(user.getUsername());
            passwordField.setText(user.getPassword());
            phoneField.setText(user.getNoTelp());
        }

        // Panel untuk Tombol
        JPanel ButtonPanel = new JPanel(new GridBagLayout());
        ButtonPanel.setBackground(new Color(225, 235, 215)); // Warna hijau lembut
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 120, 0)); // Margin atas dan bawah

        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.insets = new Insets(10, 0, 10, 0); // Spasi vertikal antar tombol
        gbcButton.gridx = 0;
        gbcButton.anchor = GridBagConstraints.CENTER; // Posisi tombol di tengah

        Dimension buttonSize = new Dimension(150, 30); // Ukuran tombol seragam

        // Tombol Simpan
        gbcButton.gridy = 0; // Baris pertama
        RoundedButton saveButton = new RoundedButton("Simpan", 30);
        saveButton.setBackground(new Color(166, 179, 125)); // Warna hijau lembut
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setFont(new Font("Nunito", Font.BOLD, 16));
        saveButton.setPreferredSize(buttonSize); // Ukuran seragam
        ButtonPanel.add(saveButton, gbcButton);

        // Tambahkan ActionListener ke tombol Simpan
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpanProfil(nameField.getText(), null, null, usernameField.getText(), passwordField.getText(), null, phoneField.getText());
            }
        });

        // Tombol Back
        gbcButton.gridy = 1; // Baris kedua
        RoundedButton cancelButton = new RoundedButton("Back", 30);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setFont(new Font("Nunito", Font.BOLD, 16));
        cancelButton.setPreferredSize(buttonSize); // Ukuran seragam
        ButtonPanel.add(cancelButton, gbcButton);

        // Aksi tombol Back
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Menambahkan panel ke frame
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(ButtonPanel, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    // Metode SimpanProfil
    private void SimpanProfil(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser, String noTelp) {
        User updatedUser = new User(namaLengkap, tglLahir, null, username, password, null, noTelp);
        
        ProfileController profilController = new ProfileController();
        try {
            profilController.updateUser(updatedUser);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            pesanError();
        }
    }

    // Menampilkan pesan error
    public static void pesanError() {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data", "Error", JOptionPane.ERROR_MESSAGE);
    }
}