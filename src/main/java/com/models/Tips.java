package src.main.java.com.models;

public class Tips {
    private int id;
    private String judul;
    private String penulis;
    private String gambar; // URL atau path gambar
    private String url;

    public Tips(int id, String judul, String penulis, String gambar, String url) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.gambar = gambar;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getGambar() {
        return gambar;
    }

    public String getUrl() {
        return url;
    }
}
