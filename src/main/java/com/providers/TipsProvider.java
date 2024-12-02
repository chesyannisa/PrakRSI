package src.main.java.com.providers;

import src.main.java.com.models.Tips;
import java.util.ArrayList;
import java.util.List;

public class TipsProvider {
    public Tips getTipsById(int id) {
        List<Tips> tipsList = getAllTips();
        for (Tips tips : tipsList) {
            if (tips.getId() == id) {
                return tips;
            }
        }
        return null;
    }

    public List<Tips> getAllTips() {
        List<Tips> tipsList = new ArrayList<>();
        tipsList.add(new Tips(1, "Memulai Gaya Hidup Ramah Lingkungan dan Manfaatnya", "Rheem", "src\\main\\resources\\images\\art1.png", "https://rheem.id/blog/gaya-hidup-ramah-lingkungan/"));
        tipsList.add(new Tips(2, "Mari Kelola Sampah Dengan Bijak Mulai Hari Ini", "Citarum Harum Juara", "src\\main\\resources\\images\\art2.png", "https://citarumharum.jabarprov.go.id/mari-kelola-sampah-dengan-bijak-mulai-hari-ini/"));
        tipsList.add(new Tips(3, "Mengenal Sustainable Living: Contoh, Tips, dan Manfaatnya", "Prudential", "src\\main\\resources\\images\\art3.png", "https://www.prudential.co.id/id/pulse/article/sustainable-living/"));
        tipsList.add(new Tips(4, "5 Cara Mudah Mengelola Sampah di Rumah dengan Mudah", "Axa", "src\\main\\resources\\images\\art4.png", "https://axa.co.id/-/5-cara-mudah-mengelola-sampah-di-rumah-dengan-mudah"));
        tipsList.add(new Tips(5, "9 Manfaat Gaya Hidup Berkelanjutan", "Katadata", "src\\main\\resources\\images\\art5.png", "https://katadata.co.id/lifestyle/varia/6571d0e2d08c3/9-manfaat-gaya-hidup-berkelanjutan"));
        tipsList.add(new Tips(6, "5 Kebiasaan Ramah Lingkungan yang Baik untuk Diterapkan", "Waste4Change", "src\\main\\resources\\images\\art6.png", "https://waste4change.com/blog/5-kebiasaan-ramah-lingkungan-yang-baik-untuk-diterapkan/"));
        return tipsList;
    }
}