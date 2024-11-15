package src.main.java.com.ui;

import src.main.java.com.models.RegisterLogin;
import src.main.java.com.ui.LupaPasswordUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanLoginUI {
    public RegisterLogin registerLogin;
    
    public HalamanLoginUI (RegisterLogin registerLogin) {
        this.registerLogin = registerLogin;

        // Membuat frame untuk login
        JFrame frame = new JFrame("ResikinAE: Login");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Komponen
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 20, 80, 25);
        frame.add(labelUsername);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        frame.add(usernameField);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 50, 80, 25);
        frame.add(labelPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Nunito", Font.PLAIN, 12));
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.setBackground(new Color(166, 179, 125));
        frame.add(loginButton);

        JButton forgotPasswordButton = new JButton("Lupa Password");
        forgotPasswordButton.setForeground(Color.WHITE);
        forgotPasswordButton.setFont(new Font("Nunito", Font.PLAIN, 12));
        forgotPasswordButton.setBounds(100, 80, 150, 25);
        forgotPasswordButton.setBackground(new Color(166, 179, 125));
        frame.add(forgotPasswordButton);

        // Aksi tombol Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                registerLogin.login(username, password); // Modifikasi untuk memanggil metode login dengan parameter
            }
        });

        // Aksi tombol Lupa Password
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LupaPasswordUI(registerLogin); // Membuka GUI untuk lupa password
                frame.dispose(); // Menutup frame login
            }
        });

        frame.setVisible(true);
    }
}
