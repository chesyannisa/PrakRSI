package src.main.java.com.ui;

import src.main.java.com.models.RegisterLogin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class LupaPasswordUI {
    public RegisterLogin registerLogin;

    public LupaPasswordUI (RegisterLogin registerLogin) {
        this.registerLogin = registerLogin;

        // Membuat frame untuk lupa password
        JFrame frame = new JFrame("Lupa Password");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Komponen
        JLabel labelNamaLengkap = new JLabel("Nama Lengkap:");
        labelNamaLengkap.setBounds(10, 20, 120, 25);
        frame.add(labelNamaLengkap);

        JTextField namaField = new JTextField();
        namaField.setBounds(130, 20, 150, 25);
        frame.add(namaField);

        JLabel labelTglLahir = new JLabel("Tanggal Lahir:");
        labelTglLahir.setBounds(10, 60, 120, 25);
        frame.add(labelTglLahir);

        JTextField tglLahirField = new JTextField();
        tglLahirField.setBounds(130, 60, 150, 25);
        frame.add(tglLahirField);

        JLabel labelNamaIbu = new JLabel("Nama Ibu:");
        labelNamaIbu.setBounds(10, 100, 120, 25);
        frame.add(labelNamaIbu);

        JTextField namaIbuField = new JTextField();
        namaIbuField.setBounds(130, 100, 150, 25);
        frame.add(namaIbuField);

        JButton verifyButton = new JButton("Verifikasi");
        verifyButton.setBounds(10, 140, 120, 25);
        frame.add(verifyButton);

        // Aksi tombol Verifikasi
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String namaLengkap = namaField.getText();
                String tglLahirInput = tglLahirField.getText();
                LocalDate tglLahir = LocalDate.parse(tglLahirInput); // Parsing tanggal
                String namaIbu = namaIbuField.getText();

                // Panggil metode lupaPassword di RegisterLogin
                registerLogin.lupaPassword(namaLengkap, tglLahir, namaIbu);
                frame.dispose(); // Menutup frame lupa password
            }   catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.");
            }
            }
        });

        frame.setVisible(true);
    }
}
