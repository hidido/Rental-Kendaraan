package model;

public class Motor extends Kendaraan {
    public Motor(String merk, String nama, int kapasitasMesin) {
        super(merk, nama, kapasitasMesin);
    }

    @Override
    public String getJenis() {
        return "Motor";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Motor " + nama + " dengan kapasitas " + kapasitasMesin + " cc.");
    }
}
