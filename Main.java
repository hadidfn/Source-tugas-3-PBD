
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        Pesanan pesanan = new Pesanan();

        try { menu.loadFromFile(); } catch (Exception e) {}

        int pilih;

        while (true) {
            System.out.println("\n=== PROGRAM RESTORAN ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Tampilkan Struk dari File");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = in.nextInt();
            in.nextLine();

            switch (pilih) {

                case 1 -> {
                    System.out.println("\n1. Makanan\n2. Minuman\n3. Diskon");
                    System.out.print("Pilih kategori: ");
                    int kat = in.nextInt(); in.nextLine();

                    System.out.print("Nama: ");
                    String nama = in.nextLine();
                    System.out.print("Harga: ");
                    double harga = in.nextDouble(); in.nextLine();

                    if (kat == 1) {
                        System.out.print("Jenis Makanan: ");
                        menu.tambahMenu(new Makanan(nama, harga, in.nextLine()));
                    } else if (kat == 2) {
                        System.out.print("Jenis Minuman: ");
                        menu.tambahMenu(new Minuman(nama, harga, in.nextLine()));
                    } else {
                        System.out.print("Potongan (%): ");
                        menu.tambahMenu(new Diskon(nama, harga, in.nextDouble()));
                    }

                    try { menu.saveToFile(); } catch (Exception e) {}
                }

                case 2 -> menu.tampilkanMenu();

                case 3 -> {
                    menu.tampilkanMenu();

                    System.out.println("\nMasukkan pesanan dalam format:");
                    System.out.println("nomor_menu,qty");
                    System.out.println("Contoh: 1,2  (menu 1 dibeli 2x)");
                    System.out.println("Ketik 0 jika selesai.\n");

                    while (true) {
                        System.out.print("Input: ");
                        String input = in.nextLine();

                        if (input.equals("0")) break;

                        try {
                            String[] parts = input.split(",");
                            int no = Integer.parseInt(parts[0]);
                            int qty = Integer.parseInt(parts[1]);

                            pesanan.tambahPesanan(menu.getItem(no - 1), qty);

                        } catch (Exception e) {
                            System.out.println("Format salah!");
                        }
                    }

                    pesanan.tampilkanPesanan();
                    System.out.println("TOTAL: Rp" + pesanan.hitungTotal());

                    try { pesanan.saveStruk(); } catch (Exception e) {}
                }

                case 4 -> {
                    try { pesanan.loadStruk(); } catch (Exception e) {}
                }

                case 5 -> {
                    System.out.println("Keluar...");
                    return;
                }
            }
        }
    }
}
