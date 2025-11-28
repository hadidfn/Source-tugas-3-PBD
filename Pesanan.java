
import java.io.*;
import java.util.*;

public class Pesanan {

    private static class ItemQty {
        MenuItem item;
        int qty;

        ItemQty(MenuItem item, int qty) {
            this.item = item;
            this.qty = qty;
        }
    }

    private ArrayList<ItemQty> listPesanan = new ArrayList<>();

    public void tambahPesanan(MenuItem item, int qty) {
        listPesanan.add(new ItemQty(item, qty));
    }

    public void tampilkanPesanan() {
        System.out.println("\n=== PESANAN ANDA ===");
        for (ItemQty iq : listPesanan) {
            System.out.println(iq.item.getNama() + " x" + iq.qty + " = Rp" + (iq.item.getHarga() * iq.qty));
        }
    }

    public double hitungTotal() {
        double total = 0;

        for (ItemQty iq : listPesanan) {
            if (!(iq.item instanceof Diskon))
                total += iq.item.getHarga() * iq.qty;
        }

        for (ItemQty iq : listPesanan) {
            if (iq.item instanceof Diskon)
                total -= total * (((Diskon) iq.item).getPotongan() / 100);
        }

        return total;
    }

    public void saveStruk() throws IOException {
        FileWriter fw = new FileWriter("struk.txt");

        fw.write("=== STRUK PESANAN ===\n");
        for (ItemQty iq : listPesanan) {
            fw.write(iq.item.getNama() + " x" + iq.qty + " = Rp" + (iq.item.getHarga() * iq.qty) + "\n");
        }
        fw.write("\nTOTAL: Rp" + hitungTotal());
        fw.close();
    }

    public void loadStruk() throws IOException {
        File file = new File("struk.txt");
        if (!file.exists()) {
            System.out.println("Belum ada struk tersimpan.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        System.out.println("\n=== STRUK DARI FILE ===");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
