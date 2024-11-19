package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import src.main.java.com.controllers.RegisterController;
import src.main.java.com.controllers.LoginController;
import src.main.java.com.models.RegisterLogin;

public class HalamanRegisterUI extends JFrame {
    private JTextField namaLengkapField;
    private JTextField tglLahirField;
    private JTextField namaIbuField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField konfirmasiPasswordField;
    private JRadioButton masyarakatButton;
    private JRadioButton pengelolaButton;
    private ButtonGroup roleGroup;
    private JButton registerButton;
    private RegisterLogin registerLogin;

    public HalamanRegisterUI(){
        // Konfigurasi Frame
        setTitle("Form Registrasi");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        registerLogin = new RegisterLogin();

        // Gambar di bagian atas
        ImageIcon originalIcon = new ImageIcon("src\\main\\resources\\logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(230, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // Panel Form (Tengah)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(225, 235, 215)); // Warna hijau muda seperti di prototipe
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tambahkan elemen ke form
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Nama Lengkap:"), gbc);

        gbc.gridx = 1;
        namaLengkapField = new JTextField(20);
        formPanel.add(namaLengkapField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Tanggal Lahir (yyyy-mm-dd):"), gbc);

        gbc.gridx = 1;
        tglLahirField = new JTextField(20);
        formPanel.add(tglLahirField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Nama Lengkap Ibu:"), gbc);

        gbc.gridx = 1;
        namaIbuField = new JTextField(20);
        formPanel.add(namaIbuField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Konfirmasi Password:"), gbc);

        gbc.gridx = 1;
        konfirmasiPasswordField = new JPasswordField(20);
        formPanel.add(konfirmasiPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Daftar Sebagai?"), gbc);

        gbc.gridx = 1;
        JPanel rolePanel = new JPanel();
        masyarakatButton = new JRadioButton("Masyarakat Umum");
        pengelolaButton = new JRadioButton("Pengelola Sampah");
        roleGroup = new ButtonGroup();
        roleGroup.add(masyarakatButton);
        roleGroup.add(pengelolaButton);
        rolePanel.add(masyarakatButton);
        rolePanel.add(pengelolaButton);
        formPanel.add(rolePanel, gbc);

        // Tambahkan Tombol
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        RoundedButton registerButton = new RoundedButton("Register", 30);
        registerButton.setBackground(new Color(166, 179, 125)); // Warna tombol hijau
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Nunito", Font.BOLD, 16)); // Font tombol
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendaftaranUser();
            }
        });
        formPanel.add(registerButton, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Footer (Login)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel = new JLabel("Sudah punya akun? ");
        RoundedButton loginButton = new RoundedButton("Login", 10);
        loginButton.setForeground(new Color(166, 179, 125));
        loginButton.setContentAreaFilled(false);
        footerPanel.add(footerLabel);
        footerPanel.add(loginButton);
        add(footerPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HalamanLoginUI(null);
                dispose();
            }
        });

        setVisible(true);
    }

    private void pendaftaranUser() {
        // Ambil data dari form
        String namaLengkap = namaLengkapField.getText();
        LocalDate tglLahir = LocalDate.parse(tglLahirField.getText());
        String namaIbu = namaIbuField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String konfirmasiPassword = new String(konfirmasiPasswordField.getPassword());
        String roleUser = masyarakatButton.isSelected() ? "Masyarakat" : "Pengelola";

        if (!password.equals(konfirmasiPassword)) {
            RegisterController registerController = new RegisterController();
            registerController.tampilkanPesanErrorKonfirmasi();
            return;
        } else {
            MenyimpanData(namaLengkap, tglLahir, namaIbu, username, password, roleUser);
            RegisterController registerController = new RegisterController();
            registerController.tampilkanPesanSuksesRegistrasi();
            LoginController loginController = new LoginController();
            loginController.tampilkanHalamanLogin();
        }
    }

    public void MenyimpanData(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String Password, String roleUser) {
        RegisterController registerController = new RegisterController();
        registerController.InsertData(namaLengkap, tglLahir, namaIbu, username, Password, roleUser);
    }

    public static void pesanErrorKonfirmasi() {
        JOptionPane.showMessageDialog(null, "Password tidak cocok! Registrasi gagal.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void pesanSuksesRegistrasi() {
        JOptionPane.showMessageDialog(null, "Registrasi berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
}
