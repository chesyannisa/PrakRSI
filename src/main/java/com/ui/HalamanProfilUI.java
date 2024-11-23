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

        // Bagian atas (Logo dan Judul)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(203, 215, 176));
        topPanel.setPreferredSize(new Dimension(0, 100));

        // Logo di kiri atas
        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png"); // Path logo
        Image logoImage = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH); // Atur ukuran logo
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(35, 20, 10, 10)); // Padding untuk logo

        // Judul di tengah
        JLabel titleLabel = new JLabel("Profil");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Bagian tengah (Konten Profil)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(203, 215, 176));


        // Label "USER MASYARAKAT"
        JLabel userTypeLabel = new JLabel("USER MASYARAKAT");
        userTypeLabel.setFont(new Font("Nunito", Font.BOLD, 18));
        userTypeLabel.setForeground(new Color(83, 53, 74));
        userTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel untuk data pengguna (diperkecil)
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(4, 1, 5, 5));
        userInfoPanel.setBackground(Color.WHITE);
        userInfoPanel.setPreferredSize(new Dimension(400, 150)); // Ukuran diperkecil
        userInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        userInfoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tambahkan data pengguna
        addUserInfoRow(userInfoPanel, "Nama Lengkap     :", "*nama dari register*");
        addUserInfoRow(userInfoPanel, "Username             :", "*username dari register*");
        addUserInfoRow(userInfoPanel, "Kata Sandi            :", "********");
        addUserInfoRow(userInfoPanel, "Nomor Telepon    :", "-");

        // Bagian bawah (Tombol)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
        bottomPanel.setBackground(new Color(203, 215, 176));

        RoundedButton editButton = new RoundedButton ("Edit Profil",30);
        editButton.setForeground(new Color(83, 53, 74));
        RoundedButton backButton = new RoundedButton ("Back", 30);
        backButton.setForeground(new Color(83, 53, 74));


        // ActionListener untuk tombol
        editButton.addActionListener(e -> {
            showHalamanEditProfil();
            JOptionPane.showMessageDialog(frame, "Edit Profil clicked!");
        });

        backButton.addActionListener(e -> {
            new HalamanUtamaUI();
            frame.dispose();
        });
        
        bottomPanel.add(editButton);
        bottomPanel.add(backButton);

        // Menambahkan semua komponen ke frame
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Jarak
        centerPanel.add(userTypeLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Jarak
        centerPanel.add(userInfoPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Metode untuk menambahkan baris informasi pengguna
    private void addUserInfoRow(JPanel panel, String labelText, String valueText) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        rowPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        JLabel value = new JLabel(valueText);
        setLabelStyle(label, value);

        rowPanel.add(label);
        rowPanel.add(value);

        panel.add(rowPanel);
    }

    // Metode untuk mengatur gaya label
    private void setLabelStyle(JLabel label, JLabel value) {
        label.setFont(new Font("Nunito", Font.BOLD, 14));
        value.setFont(new Font("Nunito", Font.PLAIN, 14));
        label.setForeground(new Color(83, 53, 74));
        value.setForeground(new Color(83, 53, 74));
    }

    // Metode untuk mengatur gaya tombol
    private void setButtonStyle(JButton button) {
        button.setFont(new Font("Nunito", Font.BOLD, 14));
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

    public static void main(String[] args) {
        new HalamanProfilUI();
    }
}
