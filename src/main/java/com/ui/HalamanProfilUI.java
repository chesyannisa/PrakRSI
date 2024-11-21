package src.main.java.com.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.main.java.com.controllers.ProfileController;

public class HalamanProfilUI {

    public HalamanProfilUI() {
        // Membuat frame
        JFrame frame = new JFrame("ResikinAE: Profile");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(203, 215, 176));

        // Bagian atas (Logo dan Judul)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(239, 234, 221));

        JLabel logoLabel = new JLabel(new ImageIcon("src\\main\\resources\\images\\logo.png")); // Logo
        logoLabel.setHorizontalAlignment(JLabel.LEFT);

        JLabel titleLabel = new JLabel("Profil");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Bagian tengah (Konten Profil)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(203, 215, 176));

        // Foto profil
        JLabel profilePictureLabel = new JLabel(new ImageIcon("src\\main\\resources\\images\\profile_picture.png")); // Placeholder gambar
        profilePictureLabel.setPreferredSize(new Dimension(100, 100));
        profilePictureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label "USER MASYARAKAT"
        JLabel userTypeLabel = new JLabel("USER MASYARAKAT");
        userTypeLabel.setFont(new Font("Nunito", Font.BOLD, 18));
        userTypeLabel.setForeground(new Color(83, 53, 74));
        userTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel untuk data pengguna
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(4, 2, 10, 10));
        userInfoPanel.setBackground(Color.WHITE);
        userInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel namaLabel = new JLabel("Nama Lengkap :");
        JLabel namaValue = new JLabel("*nama dari register*");
        JLabel usernameLabel = new JLabel("Username :");
        JLabel usernameValue = new JLabel("*username dari register*");
        JLabel passwordLabel = new JLabel("Kata Sandi :");
        JLabel passwordValue = new JLabel("********");
        JLabel phoneLabel = new JLabel("Nomor Telepon :");
        JLabel phoneValue = new JLabel("-");

        setLabelStyle(namaLabel, namaValue);
        setLabelStyle(usernameLabel, usernameValue);
        setLabelStyle(passwordLabel, passwordValue);
        setLabelStyle(phoneLabel, phoneValue);

        userInfoPanel.add(namaLabel);
        userInfoPanel.add(namaValue);
        userInfoPanel.add(usernameLabel);
        userInfoPanel.add(usernameValue);
        userInfoPanel.add(passwordLabel);
        userInfoPanel.add(passwordValue);
        userInfoPanel.add(phoneLabel);
        userInfoPanel.add(phoneValue);

        // Bagian bawah (Tombol)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        bottomPanel.setBackground(new Color(203, 215, 176));

        JButton editButton = new JButton("Edit Profil");
        JButton backButton = new JButton("Back");

        setButtonStyle(editButton);
        setButtonStyle(backButton);

        // ActionListener untuk tombol
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHalamanEditProfil(); // Menampilkan halaman edit profil
                JOptionPane.showMessageDialog(frame, "Edit Profil clicked!");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanUtamaUI(); // Kembali ke halaman utama
                frame.dispose(); // Menutup halaman profil
            }
        });

        bottomPanel.add(editButton);
        bottomPanel.add(backButton);

        // Menambahkan semua komponen ke frame
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Jarak
        centerPanel.add(profilePictureLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Jarak
        centerPanel.add(userTypeLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Jarak
        centerPanel.add(userInfoPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Metode untuk mengatur gaya label
    private void setLabelStyle(JLabel label, JLabel value) {
        label.setFont(new Font("Nunito", Font.BOLD, 16));
        value.setFont(new Font("Nunito", Font.PLAIN, 16));
        label.setForeground(new Color(83, 53, 74));
        value.setForeground(new Color(83, 53, 74));
    }

    // Metode untuk mengatur gaya tombol
    private void setButtonStyle(JButton button) {
        button.setFont(new Font("Nunito", Font.BOLD, 16));
        button.setBackground(new Color(239, 234, 221));
        button.setForeground(new Color(83, 53, 74));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(83, 53, 74)));
    }

    // Metode untuk menampilkan halaman edit profil
    private void showHalamanEditProfil() {
        ProfileController profilController = new ProfileController();
        profilController.tampilkanHalamanEditProfil();
    }
}
