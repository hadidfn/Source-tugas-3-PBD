
public class Minuman extends MenuItem {
    private String jenis;

    public Minuman(String nama, double harga, String jenis) {
        super(nama, harga, "Minuman");
        this.jenis = jenis;
    }

    @Override
    public void tampilMenu() {
        System.out.println("[Minuman] " + nama + " - Rp" + harga + " (" + jenis + ")");
    }

    @Override
    public String toString() {
        return super.toString() + ";MINUMAN;" + jenis;
    }
}
