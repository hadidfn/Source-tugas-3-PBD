
public class Makanan extends MenuItem {
    private String jenis;

    public Makanan(String nama, double harga, String jenis) {
        super(nama, harga, "Makanan");
        this.jenis = jenis;
    }

    @Override
    public void tampilMenu() {
        System.out.println("[Makanan] " + nama + " - Rp" + harga + " (" + jenis + ")");
    }

    @Override
    public String toString() {
        return super.toString() + ";MAKANAN;" + jenis;
    }
}
