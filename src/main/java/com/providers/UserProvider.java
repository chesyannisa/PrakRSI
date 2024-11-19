package src.main.java.com.providers;

import src.main.java.com.models.User;
import java.time.LocalDate;

public class UserProvider {
    Object[][] dataPengguna;

    public UserProvider() {
        dataPengguna = new Object[100][6];
        dataPengguna[0] = new Object[]{"user", LocalDate.of(2000, 1, 1), "user", "user", "password", "Pengelola Sampah"};
    }

    public User getUserByUsername(String username) {
        for (Object[] user : dataPengguna) {
            if (user[3] != null && user[3].equals(username)) {
                return new User((String) user[0], (LocalDate) user[1], (String) user[2], (String) user[3], (String) user[4], (String) user[5]);
            }
        }
        return null;
    }

    public User getUserByNamaLengkap(String namaLengkap, LocalDate tglLahir, String namaIbu) {
        for (Object[] user : dataPengguna) {
            if (user[0] != null && user[1] != null && user[2] != null && user[0].equals(namaLengkap) && user[1].equals(tglLahir) && user[2].equals(namaIbu)) {
                return new User((String) user[0], (LocalDate) user[1], (String) user[2], (String) user[3], (String) user[4], (String) user[5]);
            }
        }
        return null;
    }

    public void addUser(User user) {
        for (int i = 0; i < dataPengguna.length; i++) {
            if (dataPengguna[i][0] == null) {
                dataPengguna[i] = new Object[]{user.getnamaLengkap(), user.gettglLahir(), user.getnamaIbu(), user.getUsername(), user.getPassword(), user.getRoleUser()};
                break;
            }
        }
    }
}
