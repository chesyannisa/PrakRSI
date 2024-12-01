package src.main.java.com.providers;

import src.main.java.com.models.Tips;

import java.util.ArrayList;
import java.util.List;

public class TipsProvider {
    private static List<Tips> tipsList = new ArrayList<>();

    static {
        tipsList.add(new Tips(1, "Judul Tips 1", "Penulis 1", "Isi Tips 1", "url1"));
        tipsList.add(new Tips(2, "Judul Tips 2", "Penulis 2", "Isi Tips 2", "url2"));
        tipsList.add(new Tips(3, "Judul Tips 3", "Penulis 3", "Isi Tips 3", "url3"));
        tipsList.add(new Tips(4, "Judul Tips 4", "Penulis 4", "Isi Tips 4", "url4"));
        tipsList.add(new Tips(5, "Judul Tips 5", "Penulis 5", "Isi Tips 5", "url5"));
    }

    public List<Tips> getAllTips() {
        return tipsList;
    }

    public Tips getTips(int id) {
        for (Tips tips : tipsList) {
            if (tips.getId() == id) {
                return tips;
            }
        }
        return null;
    }
}