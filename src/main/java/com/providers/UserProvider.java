package src.main.java.com.providers;

import src.main.java.com.models.User;
import java.time.LocalDate;

public class UserProvider {
    Object[][] dataPengguna = {
        {"John Doe", LocalDate.of(1990, 5, 20), "Jane Doe", "johndoe", "password123", "Masyarakat"},
        {"Alice Smith", LocalDate.of(1985, 10, 15), "Mary Smith", "alices", "mypassword", "Pengelola"},
        {"Bob Brown", LocalDate.of(1995, 7, 8), "Emily Brown", "bobb", "securepass", "Masyarakat"},
        {"Charlie Johnson", LocalDate.of(1992, 3, 12), "Laura Johnson", "charliej", "passw0rd", "Pengelola"},
        {"Diana Prince", LocalDate.of(1988, 11, 25), "Steve Prince", "dianap", "wonderwoman", "Masyarakat"},
        {"Eve Adams", LocalDate.of(1993, 2, 28), "Adam Adams", "evea", "evesecret", "Pengelola"},
        {"Frank White", LocalDate.of(1987, 6, 30), "Nancy White", "frankw", "whitepass", "Masyarakat"},
        {"George King", LocalDate.of(1991, 4, 22), "Martha King", "georgek", "kingpass", "Pengelola"},
        {"Hannah Scott", LocalDate.of(1989, 9, 19), "Michael Scott", "hannahs", "scottpass", "Masyarakat"},
        {"User", LocalDate.of(0, 0, 0), "User", "user", "password", "Masyarakat"}
    };

    public User getUserByUsername(String username) {
        for (Object[] user : dataPengguna) {
            if (user[3].equals(username)) {
                return new User((String) user[0], (LocalDate) user[1], (String) user[2], (String) user[3], (String) user[4], (String) user[5]);
            }
        }
        return null;
    }
}
