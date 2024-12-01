package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URI;
import src.main.java.com.controllers.TipsController;
import src.main.java.com.models.Tips;

public class HalamanTipsUI {
    private TipsController tipsController;

    public HalamanTipsUI() {
        tipsController = new TipsController();

        // Membuat frame
        JFrame frame = new JFrame("ResikinAE: Tips & Trik Ramah Lingkungan");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Bagian atas (Logo dan Judul)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(203, 215, 176));
        topPanel.setPreferredSize(new Dimension(0, 100));

        // Logo di kiri atas
        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        JButton logoButton = new JButton(scaledLogoIcon);
        logoButton.setBorderPainted(false);
        logoButton.setFocusPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoButton.addActionListener(e -> {
            new HalamanUtamaUI();
            frame.dispose();
        });

        topPanel.add(logoButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Tips & Trik Ramah Lingkungan");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel artikelPanel = new JPanel();
        artikelPanel.setLayout(new BoxLayout(artikelPanel, BoxLayout.Y_AXIS));
        artikelPanel.setBackground(new Color(203, 215, 176));

        for (int i = 1; i <= 10; i++) {
            final int artikelId = i;
            Tips tips = tipsController.getTipsById(artikelId);
            if (tips != null) {
                // Menggunakan gambar dari parameter 'gambar' di kelas Tips
                artikelPanel.add(createButtonWithLabel(tips.getGambar(), tips.getJudul(), e -> openURL(tips.getUrl())));
            } else {
                artikelPanel.add(createButtonWithLabel("src\\main\\resources\\images\\tipsntrik.png", "Artikel belum ada", e -> tipsController.tampilkanPesanError()));
            }
            artikelPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        }
        

        JScrollPane scrollPane = new JScrollPane(artikelPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel createButtonWithLabel(String iconPath, String labelText, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(203, 215, 176));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton button = createImageButton(iconPath, 350, 150, actionListener);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Nunito", Font.BOLD, 18));
        label.setForeground(new Color(83, 53, 74));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(label);

        return panel;
    }

    private JButton createImageButton(String iconPath, int width, int height, ActionListener actionListener) {
        ImageIcon originalIcon = new ImageIcon(iconPath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(scaledIcon);
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(width, height));
        button.addActionListener(actionListener);
        return button;
    }

    private void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membuka URL: " + e.getMessage());
        }
    // Constructor untuk menampilkan detail tips
    public HalamanTipsUI(Tips tips) {
        // Membuat frame
        JFrame frame = new JFrame("ResikinAE: Detail Tips");
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

        // Menambahkan fungsi klik pada logo
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipsController.tampilkanHalamanTips(); 
                frame.dispose(); 
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // Judul di tengah
        JLabel titleLabel = new JLabel(tips.getJudul());
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Panel untuk detail artikel
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setBackground(new Color(203, 215, 176));

        JLabel penulisLabel = new JLabel("Penulis: " + tips.getPenulis());
        penulisLabel.setFont(new Font("Nunito", Font.PLAIN, 18));
        penulisLabel.setForeground(new Color(83, 53, 74));
        penulisLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea isiArea = new JTextArea(tips.getIsi());
        isiArea.setFont(new Font("Nunito", Font.PLAIN, 16));
        isiArea.setForeground(new Color(83, 53, 74));
        isiArea.setLineWrap(true);
        isiArea.setWrapStyleWord(true);
        isiArea.setEditable(false);
        isiArea.setBackground(new Color(203, 215, 176));
        isiArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailPanel.add(penulisLabel);
        detailPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Jarak kecil antara penulis dan isi
        detailPanel.add(isiArea);

        // Membuat JScrollPane untuk membungkus detailPanel
        JScrollPane scrollPane = new JScrollPane(detailPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Tambahkan panel ke frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tampilkan frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HalamanTipsUI();
    }
}
