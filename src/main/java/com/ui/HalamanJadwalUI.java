package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HalamanJadwalUI {

    public HalamanJadwalUI() {
        // Membuat frame
        JFrame frame = new JFrame("ResikinAE: Jadwal");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Bagian atas (Logo dan Judul)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(203, 215, 176));
        topPanel.setPreferredSize(new Dimension(0, 100));

        // Logo di kiri atas
        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png"); // Ganti path logo
        Image logoImage = logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        // Menambahkan fungsi klik pada logo
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HalamanUtamaUI(); // Navigasi ke Halaman Utama
                frame.dispose(); // Menutup halaman jadwal
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ubah kursor menjadi tangan
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Kembalikan kursor ke default
            }
        });

        // Judul di tengah
        JLabel titleLabel = new JLabel("Jadwal");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 36));
        titleLabel.setForeground(new Color(83, 53, 74));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Bagian tengah (Scroll Panel untuk Jadwal)
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new GridLayout(0, 2, 20, 20)); // Layout grid untuk 2 kolom
        schedulePanel.setBackground(new Color(234, 242, 227));
        schedulePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Padding untuk keseluruhan panel

        // Menambahkan item jadwal ke panel
        for (int i = 0; i < 10; i++) {
            schedulePanel.add(createScheduleCard(frame));
        }

        // Membungkus schedulePanel dengan JScrollPane
        JScrollPane scrollPane = new JScrollPane(schedulePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Kecepatan scroll

        // Menambahkan komponen ke frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Metode untuk membuat kartu jadwal
    private JPanel createScheduleCard(JFrame parentFrame) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 215, 176), 10),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Judul jadwal
        JLabel titleLabel = new JLabel("TPA Lorem Ipsum");
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 18));
        titleLabel.setForeground(new Color(83, 53, 74));

        // Informasi jadwal
        JLabel dateLabel = new JLabel("Senin, 23 November 2004");
        dateLabel.setFont(new Font("Nunito", Font.PLAIN, 14));
        dateLabel.setForeground(new Color(83, 53, 74));

        JLabel timeLabel = new JLabel("08.00 WIB");
        timeLabel.setFont(new Font("Nunito", Font.PLAIN, 14));
        timeLabel.setForeground(new Color(83, 53, 74));

        // Gambar jadwal
        ImageIcon scheduleImageIcon = new ImageIcon("src\\main\\resources\\images\\tpa1.png"); // Ganti path gambar
        Image scheduleImage = scheduleImageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Atur ukuran gambar
        JLabel scheduleImageLabel = new JLabel(new ImageIcon(scheduleImage));

        // Tombol detail
        JButton detailButton = new JButton("Detail");
        detailButton.setBackground(new Color(203, 215, 176));
        detailButton.setForeground(new Color(83, 53, 74));
        detailButton.setFocusPainted(false);
        detailButton.setFont(new Font("Nunito", Font.BOLD, 14));
        detailButton.addActionListener(e -> showDetailDialog(parentFrame));

        // Panel atas untuk teks
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        textPanel.add(titleLabel);
        textPanel.add(dateLabel);
        textPanel.add(timeLabel);

        // Menambahkan komponen ke cardPanel
        cardPanel.add(textPanel, BorderLayout.NORTH);
        cardPanel.add(scheduleImageLabel, BorderLayout.CENTER);
        cardPanel.add(detailButton, BorderLayout.SOUTH);

        return cardPanel;
    }

    // Metode untuk menampilkan dialog detail
    private void showDetailDialog(JFrame parentFrame) {
        JDialog detailDialog = new JDialog(parentFrame, "Detail Informasi", true);
        detailDialog.setSize(400, 300);
        detailDialog.setLayout(new BorderLayout());
        detailDialog.setLocationRelativeTo(parentFrame);

        // Konten dialog
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(239, 234, 221));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Menambahkan informasi detail
        contentPanel.add(new JLabel("Hari dan Jam: Senin, 23 November 2023, 16:00 WIB"));
        contentPanel.add(new JLabel("Nama Pusat Daur Ulang: TPA Lorem Ipsum"));
        contentPanel.add(new JLabel("Alamat: Jl. Raya X No.4, Malang"));
        contentPanel.add(new JLabel("Kategori: Umum"));
        contentPanel.add(new JLabel("Nama Petugas: P.A Gusman, Sdr. Fadli, ..."));

        // Tombol tutup
        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> detailDialog.dispose());
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        detailDialog.add(contentPanel, BorderLayout.CENTER);
        detailDialog.add(closeButton, BorderLayout.SOUTH);

        detailDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new HalamanJadwalUI();
    }
}
