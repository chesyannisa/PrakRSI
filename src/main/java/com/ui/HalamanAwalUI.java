package src.main.java.com.ui;

import javax.swing.*;
// import java.awt.*; // Removed unused import
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanAwalUI {
    public HalamanAwalUI() {
        JFrame frame = new JFrame("Halaman Awal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.setBounds(100, 80, 165, 25);
        panel.add(forgotPasswordButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MemeriksaData()
                // checkData()
                // verifikasiAkun()
                // TampilkanPasswordLama()
            }
        });
    }
}
