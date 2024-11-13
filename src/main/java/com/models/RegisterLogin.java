package src.main.java.com.models;
import java.time.LocalDate;
import src.main.java.com.ui.LupaPasswordUI;

public class RegisterLogin {
    private User dataUser;
    public void setUserData(User user) {
        this.dataUser = user;
    }
    public User getUserData() {
        return this.dataUser;
    }

    public void login(String usn, String pw) {
        // Cek username dan password
        if (dataUser != null && dataUser.getUsername().equals(usn) && dataUser.getPassword().equals(pw)) {
            System.out.println("Login berhasil! Selamat datang kembali " + dataUser.getnamaLengkap());
        } else {
            System.out.println("Username atau password salah!");
            //panggil GUI lupa password
            new LupaPasswordUI(this); //buka GUI lupapassword
        }
    }
    public void lupaPassword (String nmL, LocalDate tglLahirCheck, String nmI) {

        // Cek data pribadi
        if (dataUser.getnamaLengkap().equals(nmL) && 
            dataUser.gettglLahir().equals(tglLahirCheck) && 
            dataUser.getnamaIbu().equals(nmI)) {
            // Jika cocok, tampilkan password
            System.out.println("Password Anda adalah: " + dataUser.getPassword());
            System.out.println("Login berhasil! Selamat datang kembali " + dataUser.getnamaLengkap());
        } else {
            System.out.println("Verifikasi akun gagal. Data pribadi tidak cocok.");
        }
    }
}
