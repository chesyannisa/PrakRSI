package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanAwalUI {
        public HalamanAwalUI() {
            JFrame frame = new JFrame("ResikinAE");
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setLayout(new BorderLayout());
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel imageLabel = new JLabel(new ImageIcon("src\\main\\resources\\logo.png"));
            imageLabel.setForeground(Color.WHITE);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Gambar di tengah
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);
            

            RoundedButton registerButton = new RoundedButton("Register", 30);
            registerButton.setBackground(new Color(166, 179, 125)); // Warna latar belakang tombol
            registerButton.setForeground(Color.WHITE); // Warna teks tombol
            registerButton.setFont(new Font("Nunito", Font.BOLD, 16)); // Font tombol
            registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HalamanRegisterUI halamanRegisterUI = new HalamanRegisterUI();
                frame.dispose();
            }
            });

            RoundedButton loginButton = new RoundedButton("Login", 30);
            loginButton.setBackground(new Color(166, 179, 125)); // Warna latar belakang tombol
            loginButton.setForeground(Color.WHITE); // Warna teks tombol
            loginButton.setFont(new Font("Nunito", Font.BOLD, 16)); // Font tombol
            loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HalamanLoginUI halamanLoginUI = new HalamanLoginUI(null);
                frame.dispose();
            }
            });
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Posisi tengah dengan jarak antar tombol
            buttonPanel.setBackground(Color.WHITE); // Warna latar belakang panel
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 200))); // Jarak sebelum tombol pertama
            buttonPanel.add(registerButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 200))); // Jarak antara tombol
            buttonPanel.add(loginButton);


            JLabel titleLabel = new JLabel("Selamat Datang!", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Nunito", Font.BOLD, 20));
            titleLabel.setForeground(new Color(166, 179, 125));
            titleLabel.setBounds(550, 250, 200, 40);

            // Add buttons to the frame
            frame.add(imageLabel, BorderLayout.NORTH);
            frame.add(titleLabel);
            frame.add(buttonPanel, BorderLayout.CENTER);


            // Display the frame
            frame.setVisible(true);
        }
}