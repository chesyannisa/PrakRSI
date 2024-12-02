package src.main.java.com.ui;

import src.main.java.com.models.Jadwal;
import src.main.java.com.controllers.JadwalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class HalamanJadwalUI {

    private JadwalController jadwalController;

    public HalamanJadwalUI() {
        jadwalController = new JadwalController();

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
        ImageIcon logoIcon = new ImageIcon("src\\main\\resources\\images\\logo1.png");
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
                logoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        JPanel jadwalPanel = new JPanel();
        jadwalPanel.setLayout(new GridLayout(0, 2, 20, 20));
        jadwalPanel.setBackground(new Color(234, 242, 227));
        jadwalPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Fetch data jadwal from controller
        List<Jadwal> jadwals = getJadwal();

        // Tambahkan kartu ke panel
        if (jadwals != null && !jadwals.isEmpty()) {
            for (Jadwal jadwal : jadwals) {
                jadwalPanel.add(createJadwalCard(frame, jadwal));
            }
        } else {
            JLabel noDataLabel = new JLabel("Tidak ada jadwal tersedia.");
            noDataLabel.setFont(new Font("Nunito", Font.BOLD, 18));
            noDataLabel.setForeground(new Color(83, 53, 74));
            noDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jadwalPanel.add(noDataLabel);
        }

        // Scroll panel
        JScrollPane scrollPane = new JScrollPane(jadwalPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Tambahkan komponen ke frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tampilkan frame
        frame.setVisible(true);
    }

    // Membuat kartu jadwal
    private JPanel createJadwalCard(JFrame parentFrame, Jadwal jadwal) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 215, 176), 10),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Judul jadwal
        JLabel titleLabel = new JLabel(jadwal.getJudul());
        titleLabel.setFont(new Font("Nunito", Font.BOLD, 18));
        titleLabel.setForeground(new Color(83, 53, 74));

        // Informasi jadwal
        JLabel dateLabel = new JLabel(jadwal.getTanggal());
        dateLabel.setFont(new Font("Nunito", Font.PLAIN, 14));
        dateLabel.setForeground(new Color(83, 53, 74));

        JLabel timeLabel = new JLabel(jadwal.getWaktu());
        timeLabel.setFont(new Font("Nunito", Font.PLAIN, 14));
        timeLabel.setForeground(new Color(83, 53, 74));

        // Gambar jadwal
        ImageIcon jadwalImageIcon = new ImageIcon(jadwal.getPathGambar());
        Image jadwalImage = jadwalImageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        JLabel jadwalImageLabel = new JLabel(new ImageIcon(jadwalImage));

        // Tombol detail
        JButton detailButton = new JButton("Detail");
        detailButton.setBackground(new Color(203, 215, 176));
        detailButton.setForeground(new Color(83, 53, 74));
        detailButton.setFocusPainted(false);
        detailButton.setFont(new Font("Nunito", Font.BOLD, 14));
        detailButton.addActionListener(e -> showDetailDialog(parentFrame, jadwal));

        // Panel atas untuk teks
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        textPanel.add(titleLabel);
        textPanel.add(dateLabel);
        textPanel.add(timeLabel);

        cardPanel.add(textPanel, BorderLayout.NORTH);
        cardPanel.add(jadwalImageLabel, BorderLayout.CENTER);
        cardPanel.add(detailButton, BorderLayout.SOUTH);

        return cardPanel;
    }

    // Menampilkan detail dialog
    private void showDetailDialog(JFrame parentFrame, Jadwal jadwal) {
        JDialog detailDialog = new JDialog(parentFrame, "Detail Informasi", true);
        detailDialog.setSize(400, 300);
        detailDialog.setLayout(new BorderLayout());
        detailDialog.setLocationRelativeTo(parentFrame);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(239, 234, 221));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contentPanel.add(new JLabel("Hari dan Jam: " + jadwal.getTanggal() + ", " + jadwal.getWaktu()));
        contentPanel.add(new JLabel("Nama Pusat Daur Ulang: " + jadwal.getJudul()));
        contentPanel.add(new JLabel("Alamat: " + jadwal.getAlamat()));
        contentPanel.add(new JLabel("Kategori: " + jadwal.getKategori()));
        contentPanel.add(new JLabel("Nama Petugas: " + jadwal.getPetugas()));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> detailDialog.dispose());

        detailDialog.add(contentPanel, BorderLayout.CENTER);
        detailDialog.add(closeButton, BorderLayout.SOUTH);

        detailDialog.setVisible(true);
    }

    // Mendapatkan data jadwal dari controller
    private List<Jadwal> getJadwal() {
        try {
            return jadwalController.getJadwal();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list if an error occurs
        }
    }

    // Menampilkan pesan error
    public static void showPesanError() {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data dari database", "Error", JOptionPane.ERROR_MESSAGE);
    }
}