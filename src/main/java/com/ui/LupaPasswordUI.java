package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import src.main.java.com.controllers.LoginController;
import src.main.java.com.models.RegisterLogin;

public class LupaPasswordUI {
    public RegisterLogin registerLogin;
    public JFrame frame;

    public LupaPasswordUI(RegisterLogin registerLogin) {
        this.registerLogin = registerLogin;

        // Membuat frame untuk lupa password
        frame = new JFrame("Resikin AE: Lupa Password");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama dengan GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(225, 235, 215)); // Warna latar belakang

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL; // Komponen memenuhi lebar sel
        gbc.anchor = GridBagConstraints.CENTER;

        // Komponen Form
        JLabel labelNamaLengkap = new JLabel("Nama Lengkap:");
        labelNamaLengkap.setFont(new Font("Nunito", Font.BOLD, 14));
        gbc.gridx = 0; // Kolom pertama
        gbc.gridy = 0; // Baris pertama
        panel.add(labelNamaLengkap, gbc);

        JTextField namaField = new JTextField(20);
        gbc.gridx = 1; // Kolom kedua
        gbc.gridy = 0; // Baris pertama
        panel.add(namaField, gbc);

        JLabel labelTglLahir = new JLabel("Tanggal Lahir (yyyy-MM-dd):");
        labelTglLahir.setFont(new Font("Nunito", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelTglLahir, gbc);

        JTextField tglLahirField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tglLahirField, gbc);

        JLabel labelNamaIbu = new JLabel("Nama Ibu:");
        labelNamaIbu.setFont(new Font("Nunito", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelNamaIbu, gbc);

        JTextField namaIbuField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(namaIbuField, gbc);

        JButton verifyButton = new JButton("Verifikasi");
        verifyButton.setBackground(new Color(166, 179, 125));
        verifyButton.setFont(new Font("Nunito", Font.PLAIN, 12));
        verifyButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(verifyButton, gbc);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(166, 179, 125));
        backButton.setFont(new Font("Nunito", Font.PLAIN, 12));
        backButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(backButton, gbc);

        // Tambahkan panel ke frame
        frame.add(panel);

        // Aksi tombol Verifikasi
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaLengkap = namaField.getText();
                    String tglLahirInput = tglLahirField.getText();
                    LocalDate tglLahir = LocalDate.parse(tglLahirInput); // Parsing tanggal
                    String namaIbu = namaIbuField.getText();
                    MemeriksaData(namaLengkap, tglLahir, namaIbu);

                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aksi tombol Back
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanLoginUI(registerLogin); // Kembali ke halaman login
                frame.dispose(); // Menutup frame saat ini
            }
        });

        // Atur ukuran dan tampilkan frame
        frame.setVisible(true);
    }

    // Memeriksa data yang dimasukkan
    private void MemeriksaData(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        LoginController loginController = new LoginController();
        if (loginController.checkData(namaLengkap, tglLahir, namaIbu)) {
            loginController.tampilkanPesanSuksesLupa(namaLengkap, tglLahir, namaIbu);
            showHalamanUtama();
            frame.dispose();
        } else {
            loginController.tampilkanPesanErrorLupa();
        }
    }

    // Menampilkan pesan error
    public static void pesanError() {
        JOptionPane.showMessageDialog(null, "Data yang dimasukkan tidak valid. Silakan coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Menampilkan halaman utama
    public void showHalamanUtama() {
        new HalamanUtamaUI();
    }

    // Menampilkan pesan sukses
    public static void pesanSukses(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        LoginController loginController = new LoginController();
        String username = loginController.getUsername(namaLengkap, tglLahir, namaIbu);
        String password = loginController.getPassword(namaLengkap, tglLahir, namaIbu);
        JOptionPane.showMessageDialog(null, "Username Anda: " + username + "\nPassword Anda: " + password, "Informasi Akun", JOptionPane.INFORMATION_MESSAGE);
    }
}