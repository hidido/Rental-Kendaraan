package controller;

import model.Kendaraan;
import model.Mobil;
import model.Motor;
import utils.ErrorHandler;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KendaraanController {
    private View view;
    private List<Kendaraan> kendaraanTersedia = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public KendaraanController(View view) {
        // Inisialisasi kendaraan yang tersedia
        kendaraanTersedia.add(new Mobil("Toyota", "Avanza", 1500));
        kendaraanTersedia.add(new Motor("Yamaha", "NMAX", 250));
        kendaraanTersedia.add(new Mobil("Honda", "Civic", 1800));
        kendaraanTersedia.add(new Motor("Honda", "Vario", 150));
    }

    public void tampilkanKendaraanTersedia() {
        view.tampilkanPesan("\n>>> Daftar Kendaraan Tersedia <<<");
        if (kendaraanTersedia.isEmpty()) {
            view.tampilkanPesan("Tidak ada kendaraan yang tersedia.");
        } else {
            for (int i = 0; i < kendaraanTersedia.size(); i++) {
                Kendaraan k = kendaraanTersedia.get(i);
                System.out.println((i + 1) + ". " + k.getNama() + " (" + k.getJenis() + ")");
            }
        }
    }

    public void tambahSewa() {
        tampilkanKendaraanTersedia();
        view.tampilkanPesan("\nPilih nomor kendaraan untuk disewa: ");
        int pilih = input.nextInt();
        input.nextLine(); // Consume newline
        if (pilih < 1 || pilih > kendaraanTersedia.size()) {
            ErrorHandler.tampilkanError("Kendaraan tidak valid.");
            return;
        }
        Kendaraan kendaraanDisewa = kendaraanTersedia.get(pilih - 1);
        kendaraanTersedia.remove(kendaraanDisewa);
        kendaraanDisewa.setStatusSewa(true);
        kendaraanDisewa.setKodeSewa(generateKodeSewa());
        kendaraanDisewa.setTglSewa(System.currentTimeMillis());
        kendaraanDisewa.setTglKembali(0);
        kendaraanDisewa.setPenyewa("Penyewa A");

        kendaraanDisewa.setStatusSewa(true);
        kendaraanDisewa.setTglKembali(0);
        kendaraanDisewa.setPenyewa("Penyewa A");
        view.tampilkanPesan("Kendaraan berhasil disewa!");
    }

    private String generateKodeSewa(){
        return "SEWA" + System.currentTimeMillis();
    }
}
