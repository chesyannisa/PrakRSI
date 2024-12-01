package src.main.java.com.providers;

import src.main.java.com.models.Tips;

import java.util.ArrayList;
import java.util.List;

public class TipsProvider {
    private static List<Tips> tipsList = new ArrayList<>();

    static {
        tipsList.add(new Tips(1, "Cara Mengelola Sampah Rumah Tangga", "Dewi Lestari", 
            "Mengelola sampah rumah tangga dengan baik sangat penting untuk menjaga kebersihan lingkungan. " +
            "Beberapa tips untuk mengelola sampah rumah tangga termasuk memisahkan sampah organik dan anorganik, " +
            "menggunakan kantong sampah yang ramah lingkungan, dan mendaur ulang barang-barang yang bisa didaur ulang."));

        tipsList.add(new Tips(2, "Manfaat Daur Ulang Sampah", "Budi Santoso", 
            "Daur ulang sampah memiliki banyak manfaat, termasuk mengurangi jumlah sampah yang berakhir di tempat pembuangan akhir, " +
            "menghemat sumber daya alam, dan mengurangi polusi. " +
            "Dengan mendaur ulang, kita juga bisa mengurangi penggunaan energi dan emisi gas rumah kaca."));

        tipsList.add(new Tips(3, "Cara Membuat Kompos dari Sampah Organik", "Siti Aminah", 
            "Membuat kompos dari sampah organik adalah cara yang efektif untuk mengurangi sampah dan menghasilkan pupuk alami. " +
            "Beberapa langkah untuk membuat kompos termasuk mengumpulkan sampah organik seperti sisa makanan dan daun kering, " +
            "menyusun lapisan sampah organik dan tanah, serta menjaga kelembaban dan aerasi kompos."));

        tipsList.add(new Tips(4, "Mengurangi Penggunaan Plastik", "Andi Wijaya", 
            "Mengurangi penggunaan plastik adalah langkah penting untuk menjaga lingkungan. " +
            "Beberapa cara untuk mengurangi penggunaan plastik termasuk membawa tas belanja sendiri, " +
            "menggunakan botol minum yang dapat diisi ulang, dan menghindari produk yang dikemas dengan plastik sekali pakai."));

        tipsList.add(new Tips(5, "Cara Menghemat Energi di Rumah", "Rina Fitriani", "Menghemat energi di rumah " +
            "bukan hanya baik untuk lingkungan, tetapi juga dapat mengurangi tagihan listrik. " +
            "Beberapa tips untuk menghemat energi di rumah termasuk mematikan peralatan listrik saat tidak digunakan, " +
            "menggunakan lampu hemat energi, dan memasang panel surya untuk menghasilkan listrik sendiri."));

        tipsList.add(new Tips(6, "Memanfaatkan Air Hujan untuk Kebutuhan Rumah Tangga", "Dian Purnama", "Memanfaatkan air hujan " +
            "adalah cara yang ramah lingkungan dan hemat biaya untuk memenuhi kebutuhan air di rumah tangga. " +
            "Beberapa cara untuk memanfaatkan air hujan termasuk memasang bak penampungan air hujan, " +
            "menggunakan air hujan untuk menyiram tanaman, dan membersihkan halaman."));
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