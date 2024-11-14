package src.main.java.com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanAwalUI {
        public HalamanAwalUI() {
            JFrame frame = new JFrame("Halaman Awal");
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    HalamanRegisterUI halamanRegisterUI = new HalamanRegisterUI(null);
                    frame.dispose();
                }
            });

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    HalamanLoginUI halamanLoginUI = new HalamanLoginUI(null);
                    frame.dispose();
                }
            });

            // Add buttons to the frame
            frame.add(registerButton);
            frame.add(loginButton);

            // Display the frame
            frame.setVisible(true);
        }
}