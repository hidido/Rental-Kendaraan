package model;

public abstract class Kendaraan {
    protected String merk;
    protected String nama;
    protected int kapasitasMesin;
    protected boolean statusSewa;
    protected String penyewa;
    protected long tglSewa;
    protected long tglKembali;
    protected String kodeSewa;

    public void setTglSewa(long tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getKodeSewa() {
        return kodeSewa;
    }

    public void setKodeSewa(String kodeSewa) {
        this.kodeSewa = kodeSewa;
    }


    public Kendaraan(String merk, String nama, int kapasitasMesin) {
        this.merk = merk;
        this.nama = nama;
        this.kapasitasMesin = kapasitasMesin;
        this.statusSewa = false;
    }

    public abstract String getJenis();

    public String getNama() {
        return nama;
    }

    public void setStatusSewa(boolean statusSewa) {
        this.statusSewa = statusSewa;
    }

    public void setPenyewa(String penyewa) {
        this.penyewa = penyewa;
    }

    public boolean isStatusSewa() {
        return statusSewa;
    }

    public String getPenyewa() {
        return penyewa;
    }

    public long getTglSewa() {
        return tglSewa;
    }

    public long getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(long tglKembali) {
        this.tglKembali = tglKembali;
    }

    public void tampilkanInfo() {
        System.out.println("Merk: " + merk + ", Nama: " + nama + ", Kapasitas Mesin: " + kapasitasMesin + " cc");
    }
}
