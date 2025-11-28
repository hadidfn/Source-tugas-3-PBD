
public class Diskon extends MenuItem {
    private double potongan;

    public Diskon(String nama, double harga, double potongan) {
        super(nama, harga, "Diskon");
        this.potongan = potongan;
    }

    public double getPotongan() { return potongan; }

    @Override
    public void tampilMenu() {
        System.out.println("[Diskon] " + nama + " - Potongan: " + potongan + "%");
    }

    @Override
    public String toString() {
        return super.toString() + ";DISKON;" + potongan;
    }
}
