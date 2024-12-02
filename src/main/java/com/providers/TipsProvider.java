package src.main.java.com.providers;

import src.main.java.com.models.Tips;

public class TipsProvider {
    public Tips getTipsById(int id) {
        // Contoh data
        if (id == 1) return new Tips(1, "Memulai Gaya Hidup Ramah Lingkungan dan Manfaatnya", "Rheem", "src\\main\\resources\\images\\art1.png", "https://rheem.id/blog/gaya-hidup-ramah-lingkungan/");
        if (id == 2) return new Tips(2, "Mari Kelola Sampah Dengan Bijak Mulai Hari Ini", "Citarum Harum Juara", "src\\main\\resources\\images\\art2.png", "https://citarumharum.jabarprov.go.id/mari-kelola-sampah-dengan-bijak-mulai-hari-ini/");
        return null;
    }
}
