package src.main.java.com.models;
import java.time.LocalDate;

public class User {
    private String namaLengkap;
    private LocalDate tglLahir;
    private String namaIbu;
    private String username;
    private String password;
    private String roleUser;

    // Constructor
    public User(String namaLengkap, LocalDate tglLahir, String namaIbu, String username, String password, String roleUser) {
        this.namaLengkap = namaLengkap;
        this.tglLahir = tglLahir;
        this.namaIbu = namaIbu;
        this.username = username;
        this.password = password;
        this.roleUser = roleUser;
    
    }

    // Getter dan Setter untuk namaLengkap
    public String getnamaLengkap() {
        return namaLengkap;
    }

    public void setnamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    // Getter dan Setter untuk tglLahir
    public LocalDate gettglLahir() {
        return tglLahir;
    }

    public void settglLahir(LocalDate tglLahir) {
        this.tglLahir = tglLahir;
    }

    // Getter dan Setter untuk namaIbu
    public String getnamaIbu() {
        return namaIbu;
    }

    public void setnamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    // Getter dan Setter untuk username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter dan Setter untuk password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleUser(){
        return roleUser;
    }
    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }
}
