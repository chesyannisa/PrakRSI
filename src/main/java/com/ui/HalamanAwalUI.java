package src.main.java.com.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.main.java.com.controllers.LoginController;
import src.main.java.com.controllers.RegisterController;

public class HalamanAwalUI {
    public HalamanAwalUI() {
        // Membuat frame utama
        JFrame frame = new JFrame("ResikinAE");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Atur layout menggunakan GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar elemen

        // Membuat label untuk logo
        JLabel imageLabel = new JLabel(new ImageIcon("src\\main\\resources\\images\\logo.png"));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Membuat label "Selamat Datang!"
        JLabel titleLabel = new JLabel("Selamat Datang!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Ukuran dan font
        titleLabel.setForeground(new Color(166, 179, 125));

        // Membuat tombol Register
        RoundedButton registerButton = new RoundedButton("Register", 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHalamanRegister();
                frame.dispose();
            }
        });

        // Membuat tombol Login
        RoundedButton loginButton = new RoundedButton("Login", 30);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHalamanLogin();
                frame.dispose();
            }
        });

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Tombol berada di tengah
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        // Tambahkan komponen ke frame menggunakan GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(imageLabel, gbc); // Logo di tengah atas

        gbc.gridy = 1; // Posisi label "Selamat Datang!" di bawah logo
        frame.add(titleLabel, gbc);

        gbc.gridy = 2; // Tombol berada di bawah label "Selamat Datang!"
        frame.add(buttonPanel, gbc);

        // Tampilkan frame
        frame.setVisible(true);
    }

    // Menampilkan halaman login
    public void showHalamanLogin() {
        LoginController loginController = new LoginController();
        loginController.tampilkanHalamanLogin();
    }

    // Menampilkan halaman register
    public void showHalamanRegister() {
        RegisterController registerController = new RegisterController();
        registerController.tampilkanHalamanRegister();
    }
}