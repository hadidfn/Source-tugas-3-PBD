
import java.io.*;
import java.util.*;

public class Menu {
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    public void tampilkanMenu() {
        System.out.println("\n=== DAFTAR MENU RESTORAN ===");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMenu.get(i).tampilMenu();
        }
    }

    public MenuItem getItem(int index) throws Exception {
        if (index < 0 || index >= daftarMenu.size())
            throw new Exception("Menu tidak ditemukan!");
        return daftarMenu.get(index);
    }

    // ================== SAVE MENU KE FILE ==================
    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter("menu.txt");
        for (MenuItem item : daftarMenu) {
            fw.write(item.toString() + "\n");
        }
        fw.close();
    }

    // ================== LOAD MENU DARI FILE ==================
    public void loadFromFile() throws IOException {
        File file = new File("menu.txt");
        if (!file.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(";");

            String nama = data[0];
            double harga = Double.parseDouble(data[1]);
            String kategori = data[2];
            String tipe = data[3];

            switch (tipe) {
                case "MAKANAN":
                    daftarMenu.add(new Makanan(nama, harga, data[4]));
                    break;
                case "MINUMAN":
                    daftarMenu.add(new Minuman(nama, harga, data[4]));
                    break;
                case "DISKON":
                    daftarMenu.add(new Diskon(nama, harga, Double.parseDouble(data[4])));
                    break;
            }
        }
        br.close();
    }
}
