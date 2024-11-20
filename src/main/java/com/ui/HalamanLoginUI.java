package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.main.java.com.controllers.LoginController;
import src.main.java.com.models.RegisterLogin;

public class HalamanLoginUI {
    private RegisterLogin registerLogin;
    private JFrame frame;

    public HalamanLoginUI(RegisterLogin registerLogin) {
        this.registerLogin = registerLogin;

        frame = new JFrame("ResikinAE: Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // Bagian atas: logo dan judul
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo.png"); 
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

        // Input Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        JTextField usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

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
        forgotPasswordButton.setContentAreaFilled(false);
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
        
        // Aksi tombol Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                MemeriksaData(username, password);
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

            frame.setVisible(true);
    }
        
    // Memeriksa data login
    private void MemeriksaData(String username, String password) {
        LoginController loginController = new LoginController();
        if (loginController.checkUsernamePassword(username, password)) {
            showHalamanUtama();
            frame.dispose();
        } else {
            loginController.tampilkanPesanError();
        }
    }

    // Menampilkan halaman utama
    public void showHalamanUtama() {
        new HalamanUtamaUI();
    }

    // Menampilkan pesan error
    public static void pesanError() {
        JOptionPane.showMessageDialog(null, "Username atau kata sandi salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
    }
}
