package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.List;

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

        List<Tips> tipsList = tipsController.getAllTips();

        for (Tips tips : tipsList) {
            JPanel panel = createButtonWithLabel(tips.getGambar(), tips.getJudul(), e -> bukaTips(tips.getUrl()));
            artikelPanel.add(panel);
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

    private void bukaTips(String url) {
        tipsController.openURL(url);
    }

    public static void main(String[] args) {
        new HalamanTipsUI();
    }
}
