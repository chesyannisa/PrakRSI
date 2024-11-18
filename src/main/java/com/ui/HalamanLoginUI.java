package src.main.java.com.ui;

import src.main.java.com.models.RegisterLogin;
import src.main.java.com.ui.LupaPasswordUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanLoginUI {
    private RegisterLogin registerLogin;

    public HalamanLoginUI(RegisterLogin registerLogin) {
        this.registerLogin = registerLogin;

        // Membuat frame utama
        JFrame frame = new JFrame("ResikinAE: Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // Bagian atas: logo dan judul
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon("logo.png"); 
        Image scaledLogo = logoIcon.getImage().getScaledInstance(230, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo), SwingConstants.CENTER);
        headerPanel.add(logoLabel, BorderLayout.NORTH);

        frame.add(headerPanel, BorderLayout.NORTH);

        // Bagian tengah: form login
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(225, 235, 215)); // Warna hijau lembut
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Input Kata Sandi
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Kata Sandi:"), gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Lupa Sandi
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JButton forgotPasswordButton = new JButton("Lupa Sandi?");
        forgotPasswordButton.setForeground(new Color(166, 179, 125));
        forgotPasswordButton.setContentAreaFilled(true);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setFont(new Font("Nunito", Font.BOLD, 12));
        formPanel.add(forgotPasswordButton, gbc);

        // Tombol Login
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        RoundedButton loginButton = new RoundedButton("Login", 30);
        loginButton.setBackground(new Color(166, 179, 125)); // Warna hijau lembut
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Nunito", Font.BOLD, 16));
        formPanel.add(loginButton, gbc);

        frame.add(formPanel, BorderLayout.CENTER);

        // Bagian bawah: link register

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel = new JLabel("Belum punya akun? ");
        RoundedButton registerButton = new RoundedButton("Register", 10);
        registerButton.setForeground(new Color(166, 179, 125));
        registerButton.setContentAreaFilled(false);
        footerPanel.add(footerLabel);
        footerPanel.add(registerButton);
        frame.add(footerPanel, BorderLayout.SOUTH);
        

        // Action listeners

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Nunito", Font.PLAIN, 12));
        backButton.setBounds(10, 120, 80, 25);
        backButton.setBackground(new Color(166, 179, 125));
        frame.add(backButton);

        // Aksi tombol Login

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                registerLogin.login(email, password); // Proses login
            }
        });

        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LupaPasswordUI(registerLogin); // Membuka halaman lupa password
                frame.dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanRegisterUI(); // Membuka halaman register
                frame.dispose();
            }
        });

        // Aksi tombol Back
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanAwalUI(); // Kembali ke halaman awal
                frame.dispose(); // Menutup frame saat ini
            }
        });

        frame.setVisible(true);
    }
}
