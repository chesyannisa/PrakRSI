package src.main.java.com.models;

public class Tips {
    private int id;
    private String judul;
    private String penulis;
    private String isi;

    public Tips(int id, String judul, String penulis, String isi) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.isi = isi;
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

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
