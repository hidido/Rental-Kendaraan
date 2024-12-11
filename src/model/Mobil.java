package model;

public class Mobil extends Kendaraan {
    public Mobil(String merk, String nama, int kapasitasMesin) {
        super(merk, nama, kapasitasMesin);
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mobil " + nama + " dengan kapasitas " + kapasitasMesin + " cc.");
    }
}
