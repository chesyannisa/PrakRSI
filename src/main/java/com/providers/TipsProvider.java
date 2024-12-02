package src.main.java.com.providers;

import src.main.java.com.models.Tips;

public class TipsProvider {
    public Tips getTipsById(int id) {
        // Contoh data
        if (id == 1) return new Tips(1, "Memulai Gaya Hidup Ramah Lingkungan dan Manfaatnya", "Rheem", "src\\main\\resources\\images\\art1.png", "https://rheem.id/blog/gaya-hidup-ramah-lingkungan/");
        if (id == 2) return new Tips(2, "Mari Kelola Sampah Dengan Bijak Mulai Hari Ini", "Citarum Harum Juara", "src\\main\\resources\\images\\art2.png", "https://citarumharum.jabarprov.go.id/mari-kelola-sampah-dengan-bijak-mulai-hari-ini/");
        if (id == 3) return new Tips(3, "Mengenal Sustainable Living: Contoh, Tips, dan Manfaatnya", "Prudential", "src\\\\main\\\\resources\\\\images\\\\art3.png","https://www.prudential.co.id/id/pulse/article/sustainable-living/");
        if (id == 4) return new Tips(4, "5 Cara Mudah Mengelola Sampah di Rumah dengan Mudah", "Axa", "src\\\\\\\\main\\\\\\\\resources\\\\\\\\images\\\\\\\\art4.png", "https://axa.co.id/-/5-cara-mudah-mengelola-sampah-di-rumah-dengan-mudah");
        if (id == 5) return new Tips(5, "9 Manfaat Gaya Hidup Berkelanjutan", "Katadata", "src\\main\\resources\\images\\art5.png", "https://katadata.co.id/lifestyle/varia/6571d0e2d08c3/9-manfaat-gaya-hidup-berkelanjutan");
        if (id == 6) return new Tips(6, "5 Kebiasaan Ramah Lingkungan yang Baik untuk Diterapkan", "Waste4Change", "src\\main\\resources\\images\\art6.png", "https://waste4change.com/blog/5-kebiasaan-ramah-lingkungan-yang-baik-untuk-diterapkan/");
        return null;
    }
}
