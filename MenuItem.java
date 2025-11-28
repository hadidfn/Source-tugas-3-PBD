
public abstract class MenuItem {
    protected String nama;
    protected double harga;
    protected String kategori;

    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getKategori() { return kategori; }

    public abstract void tampilMenu();

    @Override
    public String toString() {
        return nama + ";" + harga + ";" + kategori;
    }
}
