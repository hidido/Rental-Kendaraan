import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Kendaraan;
import model.Mobil;
import model.Motor;
import utils.ErrorHandler;

public class Main {
    private final List<Kendaraan> kendaraanTersedia = new ArrayList<>();
    private final List<Kendaraan> kendaraanDisewa = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    // Constructor
    public Main() {
        // Inisialisasi kendaraan yang tersedia
        kendaraanTersedia.add(new Mobil("Toyota", "Avanza", 1500));
        kendaraanTersedia.add(new Motor("Yamaha", "NMAX", 250));
        kendaraanTersedia.add(new Mobil("Honda", "Civic", 1800));
        kendaraanTersedia.add(new Motor("Honda", "Vario", 150));
    }

    // Menampilkan daftar kendaraan yang tersedia
    public void tampilkanKendaraanTersedia() {
        System.out.println("\n>>> Daftar Kendaraan Tersedia <<<");
        if (kendaraanTersedia.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang tersedia.");
        } else {
            for (int i = 0; i < kendaraanTersedia.size(); i++) {
                Kendaraan k = kendaraanTersedia.get(i);
                System.out.println((i + 1) + ". " + k.getNama() + " (" + k.getJenis() + ")");
            }
        }
    }

    // Menambah kendaraan yang disewa
    public void tambahSewa() {
        tampilkanKendaraanTersedia();
        System.out.print("\nPilih nomor kendaraan untuk disewa: ");
        int pilih;

        try {
            pilih = input.nextInt();
            input.nextLine(); // Consume newline
        } catch (Exception e) {
            ErrorHandler.tampilkanError("Input tidak valid! Harap masukkan angka.");
            input.nextLine(); // Clear input
            return;
        }

        if (pilih < 1 || pilih > kendaraanTersedia.size()) {
            ErrorHandler.tampilkanError("Kendaraan tidak valid.");
            return;
        }

        // Memindahkan kendaraan ke daftar disewa
        Kendaraan kendaraan = kendaraanTersedia.get(pilih - 1);
        kendaraanTersedia.remove(kendaraan);
        kendaraanDisewa.add(kendaraan);

        // Menambahkan informasi sewa ke kendaraan
        kendaraan.setStatusSewa(true);
        kendaraan.setKodeSewa(generateKodeSewa());
        kendaraan.setTglSewa(System.currentTimeMillis());
        kendaraan.setPenyewa("Penyewa A");

        System.out.println("Kendaraan berhasil disewa!");
    }

    // Metode untuk menghasilkan kode sewa
    private String generateKodeSewa() {
        return "SEWA" + System.currentTimeMillis();
    }

    // Menampilkan kendaraan yang sedang disewa
    public void tampilkanKendaraanDisewa() {
        System.out.println("\n>>> Daftar Kendaraan yang Disewa <<<");
        if (kendaraanDisewa.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang sedang disewa.");
        } else {
            for (int i = 0; i < kendaraanDisewa.size(); i++) {
                Kendaraan k = kendaraanDisewa.get(i);
                System.out.println((i + 1) + ". " + k.getNama() + " (" + k.getJenis() + ") - Kode Sewa: " + k.getKodeSewa());
            }
        }
    }

    public static void main(String[] args) {
        Main program = new Main(); // Inisialisasi objek
    
        int pilihan = -1;
        do {
            System.out.println("\n>>> Menu Utama <<<");
            System.out.println("1. Lihat kendaraan tersedia");
            System.out.println("2. Tambah sewa");
            System.out.println("3. Tampilkan kendaraan disewa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
    
            try {
                pilihan = program.input.nextInt(); // Gunakan Scanner yang sudah ada di kelas
                program.input.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                program.input.nextLine(); // Clear invalid input
                continue;
            }
    
            switch (pilihan) {
                case 1 -> program.tampilkanKendaraanTersedia();
                case 2 -> program.tambahSewa();
                case 3 -> program.tampilkanKendaraanDisewa();
                case 0 -> System.out.println("Terima kasih telah menggunakan sistem rental kendaraan!");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    
        program.input.close(); // Tutup Scanner di akhir program
    }
}
