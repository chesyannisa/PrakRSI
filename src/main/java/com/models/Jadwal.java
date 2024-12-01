package src.main.java.com.models;

public class Jadwal {
    private int id;
    private String judul;
    private String tanggal;
    private String waktu;
    private String alamat;
    private String kategori;
    private String petugas;
    private String pathGambar;

    public Jadwal(int id, String judul, String tanggal, String waktu, String alamat, String kategori, String petugas, String pathGambar) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.alamat = alamat;
        this.kategori = kategori;
        this.petugas = petugas;
        this.pathGambar = pathGambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getPathGambar() {
        return pathGambar;
    }

    public void setPathGambar(String pathGambar) {
        this.pathGambar = pathGambar;
    }
}
