//Nama : REISYA NAZWA ANINDYA
//NIM : 2309106099
//PRODI : INFORMATIKA C'23
//MATKUL : PB0

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KopiKenangan {

    public static void main(String[] args) {
        KedaiKopi kenangan = new KedaiKopi("Kopi Kenangan Senja");
        kenangan.mulaiPemesanan();
    }
}

// Kelas Produk Kopi
class ProdukKopi {
    private String nama;
    private String ukuran;
    private double harga;
    private int stok;
    private String deskripsi;
    private boolean isTopping;

    // Konstruktor
    public ProdukKopi(String nama, String ukuran, double harga, int stok, String deskripsi, boolean isTopping) {
        this.nama = nama;
        this.ukuran = ukuran;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.isTopping = isTopping;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter untuk isTopping
    public boolean isTopping() {
        return isTopping;
   }
 
   public void setTopping(boolean topping) {
        isTopping = topping;
   }

    // Metode untuk menampilkan detail produk dengan perulangan
    public void tampilkanDetail() {
        System.out.println("--- Detail Produk ---");
        String[] detailLabels = {"Nama", "Ukuran", "Harga", "Stok", "Deskripsi"};
        String[] detailValues = {nama, ukuran, String.valueOf(harga), String.valueOf(stok), deskripsi};

        for (int i = 0; i < detailLabels.length; i++) {
            System.out.println(detailLabels[i] + ": " + detailValues[i]);
            // Tambahan perulangan sederhana untuk demonstrasi
            for (int j = 0; j < 1; j++) {
                //System.out.println("  Iterasi tambahan untuk " + detailLabels[i]); // Agar Tidak Menggangu Tampilan
            }
        }
    }
}

class ItemPesanan {
    private ProdukKopi produk;
    private int jumlah;
  
    public ItemPesanan(ProdukKopi produk, int jumlah) {
     this.produk = produk;
     this.jumlah = jumlah;
    }
  
    public ProdukKopi getProduk() {
     return produk;
    }
  
    public int getJumlah() {
     return jumlah;
    }
  
    public void setJumlah(int jumlah) {
     this.jumlah = jumlah;
    }
   }
   
   
// Kelas Pelanggan
class Pelanggan {
    private String nama;
    private String nomorTelepon;
    private String alamat;
    private int poinLoyalitas;

    // Konstruktor
    public Pelanggan(String nama, String nomorTelepon, String alamat) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
        this.poinLoyalitas = 0; // Inisialisasi poin loyalitas
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getPoinLoyalitas() {
        return poinLoyalitas;
    }

    public void setPoinLoyalitas(int poinLoyalitas) {
        this.poinLoyalitas = poinLoyalitas;
    }

     // Metode untuk menampilkan info pelanggan dengan perulangan
 public void tampilkanInfo() {
    System.out.println("--- Info Pelanggan ---");
    String[] infoLabels = { "Nama Pelanggan", "Nomor Telepon", "Alamat", "Poin Loyalitas" };
    String[] infoValues = { nama, nomorTelepon, alamat, String.valueOf(poinLoyalitas) };
  
    for (int i = 0; i < infoLabels.length; i++) {
     System.out.println(infoLabels[i] + ": " + infoValues[i]);
     // Tambahan perulangan sederhana untuk demonstrasi
     for (int j = 0; j < 1; j++) {
      // System.out.println(" Iterasi tambahan untuk " + infoLabels[i]); // Agar
      // Tidak Menggangu Tampilan
     }
    }
   }  
}

// Kelas Admin
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean cekPassword(String password) {
        return this.password.equals(password);
    }
}

// Kelas Transaksi
class Transaksi {
    private Pelanggan pelanggan;
    private List<ItemPesanan> itemPesanan;
    private double totalHarga;
    private String metodePembayaran;
    private boolean isSelesai;

    public void tampilkanStruk() {
        System.out.println("\n--- Struk Pembelian ---");
        System.out.println("Kedai Kopi Kenangan Senja");

        // Tambahkan kode untuk mendapatkan tanggal dan waktu saat ini
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Tanggal: " + formattedDateTime);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("------------------------");

        for (ItemPesanan item : itemPesanan) {
            System.out.printf("%-20s x%d Rp %.2f\n", item.getProduk().getNama(), item.getJumlah(), item.getProduk().getHarga() * item.getJumlah());
        }

        System.out.println("------------------------");
        System.out.printf("Total: Rp %.2f\n", totalHarga);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status: " + (isSelesai ? "Selesai" : "Belum Selesai"));
        System.out.println("------------------------");
        System.out.println("Terima kasih atas kunjungan Anda!");
    }

    // Konstruktor
    public Transaksi(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
        this.itemPesanan = new ArrayList<>();
        this.totalHarga = 0.0;
        this.metodePembayaran = "Belum Dipilih";
        this.isSelesai = false;
    }

    // Getter dan Setter
    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public List<ItemPesanan> getItemPesanan() {
        return itemPesanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public boolean isSelesai() {
        return isSelesai;
    }

    public void setSelesai(boolean selesai) {
        isSelesai = selesai;
    }

    // Metode untuk menambahkan item pesanan
    public void tambahItemPesanan(ProdukKopi produk, int jumlah) {
        ItemPesanan item = new ItemPesanan(produk, jumlah);
        itemPesanan.add(item);
        totalHarga += produk.getHarga() * jumlah;
    }

    // Metode untuk mengurangi total harga
    public void kurangiTotalHarga(double jumlah) {
        this.totalHarga -= jumlah;
    }

    // Metode untuk menghapus item pesanan
    public void hapusItemPesanan(int index) {
        if (index >= 0 && index < itemPesanan.size()) {
            ItemPesanan item = itemPesanan.remove(index);
            totalHarga -= item.getProduk().getHarga() * item.getJumlah();
        }
    }

    // Metode untuk menampilkan detail transaksi dengan perulangan
    public void tampilkanDetail() {
        System.out.println("--- Detail Transaksi ---");
        pelanggan.tampilkanInfo();
        System.out.println("--- Item Pesanan ---");
        if (itemPesanan.isEmpty()) {
         System.out.println("Belum ada pesanan.");
        } else {
         for (int i = 0; i < itemPesanan.size(); i++) {
          ItemPesanan item = itemPesanan.get(i);
          System.out.println((i + 1) + ". " + item.getProduk().getNama() + " (" + item.getJumlah() + " x Rp"
            + item.getProduk().getHarga() + ")");
         }
        }
        System.out.println("Total Harga: Rp" + totalHarga);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status: " + (isSelesai ? "Selesai" : "Belum Selesai"));
       }     
 

    // Metode untuk memproses pembayaran dengan perulangan
    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran...");
        // Simulasikan proses pembayaran
        int attempts = 3; // Jumlah percobaan pembayaran
        for (int i = 0; i < attempts; i++) {
            System.out.println("Percobaan pembayaran ke-" + (i + 1));
            try {
                Thread.sleep(1000); // Menunggu 1 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pembayaran berhasil!");
        isSelesai = true;
    }
}

 class KedaiKopi {
    private String namaKedai;
    private List<ProdukKopi> daftarMenu;
    private Scanner scanner;
    private List<Transaksi> daftarTransaksi;
    private List<Admin> daftarAdmin;
    private Admin adminLogin;
    private List<ProdukKopi> daftarTopping;
  
    // Konstruktor
    public KedaiKopi(String namaKedai) {
     this.namaKedai = namaKedai;
     this.daftarMenu = new ArrayList<>();
     this.scanner = new Scanner(System.in);
     this.daftarTransaksi = new ArrayList<>();
     this.daftarAdmin = new ArrayList<>();
     this.adminLogin = null;
     this.daftarTopping = new ArrayList<>();
  
     // Inisialisasi menu dan admin
     inisialisasiMenu();
     inisialisasiAdmin();

     // Inisialisasi topping
     inisialisasidaftarTopping();
    }
    private void inisialisasidaftarTopping() {
        daftarTopping.add(new ProdukKopi("Grass Jelly (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Boba (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Oreo (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Marie Regal (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Coconut Jelly (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Espresso (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
        daftarTopping.add(new ProdukKopi("Gula Aren (Topping)", "Topping", 6000, 50, "Tambahan topping untuk kopi.", true));
    }    
    
    private void tampilkanTopping() {
        System.out.println("\n--- Daftar Topping ---");
        if (daftarTopping.isEmpty()) {
            System.out.println("Tidak ada topping yang tersedia.");
        } else {
            for (ProdukKopi produk : daftarTopping) {
                System.out.println(produk.getNama() + " - Rp" + produk.getHarga());
            }
        }
    }

    private ProdukKopi cariTopping(String nama) {
        for (ProdukKopi produk : daftarTopping) {
            if (produk.getNama().equalsIgnoreCase(nama)) {
                return produk;
            }
        }
        return null; // Jika topping tidak ditemukan
    }

    // Metode untuk inisialisasi menu
 private void inisialisasiMenu() {
    // 1. Menu Kopi Kenangan Mantan
    daftarMenu.add(new ProdukKopi("Kopi Kenangan", "Reguler", 18000, 50, "Kenangan manis yang sudah tidak ada.", false));
    daftarMenu.add(new ProdukKopi("Kopi Kenangan", "Large", 24000, 50, "Kenangan manis yang sudah tidak ada.", false));
    daftarMenu.add(new ProdukKopi("Dua Shot Iced", "Reguler", 22000, 50, "Kopi dengan dua shot espresso.", false));
    daftarMenu.add(new ProdukKopi("Dua Shot Iced", "Large", 28000, 50, "Kopi dengan dua shot espresso.", false));
  
    // 2. Menu Kopi Kenangan Masa Lalu
    daftarMenu.add(new ProdukKopi("Americano", "Reguler", 15000, 50, "Terlalu pahit untuk dikenang.", false));
    daftarMenu.add(new ProdukKopi("Americano", "Large", 18000, 50, "Terlalu pahit untuk dikenang.", false));
    daftarMenu.add(new ProdukKopi("Kopi Kelapa", "Reguler", 19000, 50, "Kopi Kelapa (Kemana Lagi Pacar?).", false));
    daftarMenu.add(new ProdukKopi("Kopi Kelapa", "Large", 25000, 50, "Kopi Kelapa (Kemana Lagi Pacar?).", false));
  
    // 3. Menu Kopi Kenangan Antara Dilema dan Galau (Andi Lau)
    daftarMenu.add(new ProdukKopi("Teh Tarik + Espresso", "Reguler", 18000, 50, "Perpaduan kopi pahit dan teh yang menyegarkan.",
      false));
    daftarMenu.add(new ProdukKopi("Teh Tarik + Espresso", "Large", 24000, 50, "Perpaduan kopi pahit dan teh yang menyegarkan.", false));
  
    // 4. Menu Kopi Kenangan Mantan Menikah
    daftarMenu.add(new ProdukKopi("Cappuccino", "Reguler", 18000, 50, "Kopi klasik yang nikmat.", false));
    daftarMenu.add(new ProdukKopi("Cappuccino", "Large", 21000, 50, "Kopi klasik yang nikmat.", false));
    daftarMenu.add(new ProdukKopi("Caramel Latte", "Reguler", 24000, 50, "Latte dengan karamel yang lezat.", false));
    daftarMenu.add(new ProdukKopi("Caramel Latte", "Large", 32000, 50, "Latte dengan karamel yang lezat.", false));
    daftarMenu.add(new ProdukKopi("Flat White", "Reguler", 18000, 50, "Kopi dengan susu yang lembut.", false));
    daftarMenu.add(new ProdukKopi("Flat White", "Large", 21000, 50, "Kopi dengan susu yang lembut.", false));
    daftarMenu.add(new ProdukKopi("Hazelnut Latte", "Reguler", 24000, 50, "Latte dengan hazelnut yang menggoda.", false));
    daftarMenu.add(new ProdukKopi("Hazelnut Latte", "Large", 32000, 50, "Latte dengan hazelnut yang menggoda.", false));
    daftarMenu.add(new ProdukKopi("Latte", "Reguler", 18000, 50, "Kopi susu klasik.", false));
    daftarMenu.add(new ProdukKopi("Latte", "Large", 21000, 50, "Kopi susu klasik.", false));
    daftarMenu.add(new ProdukKopi("Marie Regal", "Reguler", 34000, 50, "Kopi dengan topping Marie Regal.", false));
    daftarMenu.add(new ProdukKopi("Marie Regal", "Large", 40000, 50, "Kopi dengan topping Marie Regal.", false));
    daftarMenu.add(new ProdukKopi("Oreo Latte", "Reguler", 18000, 50, "Latte dengan Oreo.", false));
    daftarMenu.add(new ProdukKopi("Oreo Latte", "Large", 21000, 50, "Latte dengan Oreo.", false));
    daftarMenu.add(new ProdukKopi("Pandan Latte", "Reguler", 24000, 50, "Latte dengan pandan.", false));
    daftarMenu.add(new ProdukKopi("Pandan Latte", "Large", 32000, 50, "Latte dengan pandan.", false));
    daftarMenu.add(new ProdukKopi("Tiramisu Latte", "Reguler", 24000, 50, "Latte dengan tiramisu.", false));
    daftarMenu.add(new ProdukKopi("Tiramisu Latte", "Large", 32000, 50, "Latte dengan tiramisu.", false));
    daftarMenu.add(new ProdukKopi("Vanilla Latte", "Reguler", 24000, 50, "Latte dengan vanilla.", false));
    daftarMenu.add(new ProdukKopi("Vanilla Latte", "Large", 32000, 50, "Latte dengan vanilla.", false));
    daftarMenu.add(new ProdukKopi("Kopi Klasik", "Reguler", 15000, 50, "Kopi Klasik.", false));
    daftarMenu.add(new ProdukKopi("Kopi Klasik", "Large", 20000, 50, "Kopi Klasik.", false));
    daftarMenu.add(new ProdukKopi("Spanish Latte", "Reguler", 24000, 50, "Spanish Latte.", false));
    daftarMenu.add(new ProdukKopi("Spanish Latte", "Large", 32000, 50, "Spanish Latte.", false));
    daftarMenu.add(new ProdukKopi("Salted Caramel Macchiato", "Reguler", 28000, 50, "Salted Caramel Macchiato.", false));
    daftarMenu.add(new ProdukKopi("Salted Caramel Macchiato", "Large", 36000, 50, "Salted Caramel Macchiato.", false));
    daftarMenu.add(new ProdukKopi("Mocha Latte", "Reguler", 28000, 50, "Mocha Latte.", false));
    daftarMenu.add(new ProdukKopi("Mocha Latte", "Large", 38000, 50, "Mocha Latte.", false));
  
    // 5. Menu Kopi Kenangan Minuman Selingkuhan (Non-Kopi)
    daftarMenu.add(new ProdukKopi("Coklat Pelarian", "Reguler", 24000, 50, "Karena kopi tidak selalu setia.", false));
    daftarMenu.add(new ProdukKopi("Coklat Pelarian", "Large", 34000, 50, "Karena kopi tidak selalu setia.", false));
    daftarMenu.add(new ProdukKopi("Coklat Pisang", "Reguler", 27000, 50, "Coklat Pisang.", false));
    daftarMenu.add(new ProdukKopi("Coklat Pisang", "Large", 34000, 50, "Coklat Pisang.", false));
    daftarMenu.add(new ProdukKopi("Marie Regal Shake", "Reguler", 29000, 50, "Marie Regal Shake.", false));
    daftarMenu.add(new ProdukKopi("Marie Regal Shake", "Large", 40000, 50, "Marie Regal Shake.", false));
    daftarMenu.add(new ProdukKopi("Milo Dinosaurus", "Reguler", 20000, 50, "Milo Dinosaurus.", false));
    daftarMenu.add(new ProdukKopi("Milo Dinosaurus", "Large", 26000, 50, "Milo Dinosaurus.", false));
    daftarMenu.add(new ProdukKopi("Oreo Shake", "Reguler", 29000, 50, "Oreo Cookies & Cream Shake.", false));
    daftarMenu.add(new ProdukKopi("Oreo Shake", "Large", 40000, 50, "Oreo Cookies & Cream Shake.", false));
    daftarMenu.add(new ProdukKopi("Susu Boba Gula Aren", "Reguler", 20000, 50, "Susu Boba Gula Aren.", false));
    daftarMenu.add(new ProdukKopi("Susu Boba Gula Aren", "Large", 29000, 50, "Susu Boba Gula Aren.", false));
    daftarMenu.add(new ProdukKopi("Thai Tea", "Large", 18000, 50, "Thai Tea.", false));
    daftarMenu.add(new ProdukKopi("Thai Green Tea", "Large", 18000, 50, "Thai Green Tea.", false));
    daftarMenu.add(new ProdukKopi("100% Cokelat", "Reguler", 24000, 50, "100% Cokelat.", false));
    daftarMenu.add(new ProdukKopi("100% Cokelat", "Large", 34000, 50, "Karena kopi tidak selalu setia.", false));
    daftarMenu.add(new ProdukKopi("Susu Grass Jelly Gula Aren", "Reguler", 20000, 50, "Susu Grass Jelly Gula Aren.", false));
    daftarMenu.add(new ProdukKopi("Susu Grass Jelly Gula Aren", "Large", 29000, 50, "Susu Grass Jelly Gula Aren.", false));
    daftarMenu.add(new ProdukKopi("Air Mineral", "-", 9000, 50, "Air Mineral.", false));
  
    // 6. Menu Kopi Kenangan Teh Nostalgia
    daftarMenu.add(new ProdukKopi("Es Teh Bunga Melati", "Reguler", 15000, 50, "Sedingin sifatnya sekarang.", false));
    daftarMenu.add(new ProdukKopi("Es Teh Bunga Melati", "Large", 18000, 50, "Sedingin sifatnya sekarang.", false));
  
    // 7. Menu Kopi Kenangan Teh Susu Kenangan Indah
    daftarMenu.add(new ProdukKopi("Hojicha Latte", "Reguler", 24000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Hojicha Latte", "Large", 29000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Kenangan Matcha", "Reguler", 24000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Kenangan Matcha", "Large", 29000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Teh Tarik Ulur", "Reguler", 18000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Teh Tarik Ulur", "Large", 23000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Milk Tea Boba", "Reguler", 20000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Milk Tea Grass Jelly", "Reguler", 20000, 50, "Semua akan indah pada waktunya.", false));
    daftarMenu.add(new ProdukKopi("Milk Tea Grass Jelly", "Large", 29000, 50, "Semua akan indah pada waktunya.", false));
  
    // 8. Menu Seliter Kenangan
    daftarMenu.add(new ProdukKopi("Hazelnut Latte (1L)", "Liter", 90000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Caramel Latte (1L)", "Liter", 90000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Vanilla Latte (1L)", "Liter", 90000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Americano (1L)", "Liter", 90000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Latte (1L)", "Liter", 75000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Thai Tea (1L)", "Liter", 75000, 50, "Untuk dinikmati bersama.", false));
    daftarMenu.add(new ProdukKopi("Kopi Kenangan (1L)", "Liter", 85000, 50, "Untuk dinikmati bersama.", false));
  
   }

    // Metode untuk inisialisasi admin
    private void inisialisasiAdmin() {
        daftarAdmin.add(new Admin("admin", "admin123"));
    }

// Metode utama untuk memulai pemesanan
public void mulaiPemesanan() {
    while (true) {
        System.out.println("Selamat datang di " + namaKedai + "!");
        System.out.println("Pilih opsi:");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Lanjut sebagai Pelanggan");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan: ");
        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                if (loginAdmin()) {
                    menuAdmin();
                } else {
                    System.out.println("Login admin gagal.");
                }
                break;
            case "2":
                mulaiSebagaiPelanggan();
                break;
            case "3":
                System.out.println("Terima kasih telah berkunjung!");
                return; // Keluar dari metode mulaiPemesanan
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }
}

// Metode untuk login admin
private boolean loginAdmin() {
    int kesempatan = 3; // Memberikan 3 kesempatan login

    while (kesempatan > 0) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        boolean usernameValid = false;
        for (Admin admin : daftarAdmin) {
            if (admin.getUsername().equals(username)) {
                usernameValid = true;
                if (admin.cekPassword(password)) {
                    adminLogin = admin;
                    System.out.println("Login admin berhasil!");
                    return true;
                } else {
                    System.out.println("Login gagal. Password salah.");
                    break;
                }
            }
        }

        if (!usernameValid) {
            System.out.println("Login gagal. Username tidak ditemukan.");
        }

        kesempatan--; // Mengurangi kesempatan login
        System.out.println("Kesempatan mencoba: " + kesempatan);
    }

    System.out.println("Anda telah melebihi batas percobaan login.");
    return false; // Jika kesempatan habis, login gagal
}

 // Metode untuk menambah admin baru
 private void tambahAdminBaru() {
    System.out.print("Masukkan username admin baru: ");
    String usernameBaru = scanner.nextLine();
    if (usernameBaru.trim().isEmpty()) {
     System.out.println("Username tidak boleh kosong.");
     return;
    }
  
    System.out.print("Masukkan password admin baru: ");
    String passwordBaru = scanner.nextLine();
    if (passwordBaru.trim().isEmpty()) {
     System.out.println("Password tidak boleh kosong.");
     return;
    }
  
    // Membuat admin baru
    Admin adminBaru = new Admin(usernameBaru, passwordBaru);
  
    // Menambahkan admin baru ke daftar admin
    daftarAdmin.add(adminBaru);
  
    System.out.println("Admin baru berhasil ditambahkan!");
   }
  
// Metode untuk menampilkan menu admin
private void menuAdmin() {
    while (adminLogin != null) {
        System.out.println("\n--- Menu Admin ---");
        System.out.println("Selamat datang, " + adminLogin.getUsername() + "!");
        System.out.println("1. Kelola Menu");
        System.out.println("2. Lihat Daftar Transaksi");
        System.out.println("3. Tambah Admin Baru"); // Opsi untuk menambah admin baru
        System.out.println("4. Logout");
        System.out.print("Masukkan pilihan: ");
        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                kelolaMenu();
                break;
            case "2":
                lihatDaftarTransaksi(); // Memanggil metode untuk lihat daftar transaksi
                break;
            case "3":
                tambahAdminBaru(); // Memanggil metode tambahAdminBaru
                break;
            case "4":
                adminLogin = null;
                System.out.println("Logout berhasil.");
                return; // Kembali ke menu utama
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }
}

// Metode untuk menampilkan daftar transaksi
private void lihatDaftarTransaksi() {
    System.out.println("\n--- Daftar Transaksi ---");
    if (daftarTransaksi.isEmpty()) {
        System.out.println("Belum ada transaksi.");
    } else {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            Transaksi transaksi = daftarTransaksi.get(i);
            System.out.println("Transaksi #" + (i + 1));
            transaksi.tampilkanDetail();
            System.out.println("--------------------");
        }
    }
}

  
   // Metode untuk mengelola menu (tambah, hapus)
   private void kelolaMenu() {
    while (true) {
     System.out.println("\n--- Kelola Menu ---");
     System.out.println("1. Tambah Menu");
     System.out.println("2. Hapus Menu");
     System.out.println("3. Kembali ke Menu Admin");
     System.out.print("Masukkan pilihan: ");
     String pilihan = scanner.nextLine();
  
     switch (pilihan) {
      case "1":
       tambahMenuBaruAdmin(); // Memanggil metode tambahMenuBaru
       break;
      case "2":
       hapusMenu(); // Memanggil metode hapusMenu
       break;
      case "3":
       return; // Kembali ke menu admin
      default:
       System.out.println("Pilihan tidak valid. Silakan coba lagi.");
     }
    }
   }
  
   // Metode untuk menambah menu baru
   private void tambahMenuBaruAdmin() {
    System.out.print("Masukkan nama menu baru: ");
    String namaMenuBaru = scanner.nextLine();
    if (namaMenuBaru == null || namaMenuBaru.trim().isEmpty()) {
     System.out.println("Nama menu tidak boleh kosong.");
     return;
    }
  
    System.out.print("Masukkan ukuran (Reguler/Large): ");
    String ukuranMenuBaru = scanner.nextLine();
    if (!ukuranMenuBaru.equalsIgnoreCase("Reguler") && !ukuranMenuBaru.equalsIgnoreCase("Large")) {
     System.out.println("Ukuran tidak valid. Menu tidak ditambahkan.");
     return;
    }
  
    double hargaMenuBaru = 0;
    boolean hargaValid = false;
    while (!hargaValid) {
     System.out.print("Masukkan harga: ");
     try {
      hargaMenuBaru = scanner.nextDouble();
      scanner.nextLine(); // Membersihkan newline
      if (hargaMenuBaru > 0) {
       hargaValid = true;
      } else {
       System.out.println("Harga harus lebih dari 0. Silakan coba lagi.");
      }
     } catch (InputMismatchException e) {
      System.out.println("Harga tidak valid. Masukkan angka.");
      scanner.nextLine(); // Membersihkan input yang salah
      // hargaValid tetap false, sehingga loop akan berlanjut
     }
    }
  
    int stokMenuBaru = 0;
    boolean stokValid = false;
    while (!stokValid) {
     System.out.print("Masukkan stok: ");
     try {
      stokMenuBaru = scanner.nextInt();
      scanner.nextLine(); // Membersihkan newline
      if (stokMenuBaru >= 0) {
       stokValid = true;
      } else {
       System.out.println("Stok harus 0 atau lebih. Silakan coba lagi.");
      }
     } catch (InputMismatchException e) {
      System.out.println("Stok tidak valid. Masukkan angka.");
      scanner.nextLine(); // Membersihkan input yang salah
      // stokValid tetap false, sehingga loop akan berlanjut
     }
    }
  
    System.out.print("Masukkan deskripsi: ");
    String deskripsiMenuBaru = scanner.nextLine();
    if (deskripsiMenuBaru == null || deskripsiMenuBaru.trim().isEmpty()) {
     System.out.println("Deskripsi tidak valid. Menu tidak ditambahkan.");
     return;
    }
  
    ProdukKopi menuBaru = new ProdukKopi(namaMenuBaru, ukuranMenuBaru, hargaMenuBaru, stokMenuBaru, deskripsiMenuBaru, false);
    daftarMenu.add(menuBaru);   
  
    System.out.println("Menu baru berhasil ditambahkan!");
   }

   // Metode untuk memulai sebagai pelanggan
    private void mulaiSebagaiPelanggan() {
        System.out.println("Selamat datang sebagai pelanggan!");

        // Input data pelanggan dengan perulangan tanpa henti
        String namaPelanggan = inputNamaPelanggan();
        String nomorTelepon = inputNomorTelepon();
        String alamatPelanggan = inputAlamatPelanggan();

        Pelanggan pelanggan = new Pelanggan(namaPelanggan, nomorTelepon, alamatPelanggan);

        // Membuat transaksi baru
        Transaksi transaksi = new Transaksi(pelanggan);

        // Perulangan utama untuk pemesanan tanpa henti
        while (true) {
            // Menampilkan menu dan memberikan opsi tambahan
            System.out.println("\nPilih opsi:");
            System.out.println("1. Tambah pesanan");
            System.out.println("2. Hapus pesanan");
            System.out.println("3. Lihat detail pesanan");
            System.out.println("4. Bayar");
            System.out.println("5. Keluar");

            String pilihan = inputPilihanMenu();

            switch (pilihan) {
                case "1":
                    tambahPesanan(transaksi);
                    break;
                case "2":
                    hapusPesanan(transaksi);
                    break;
                case "3":
                    transaksi.tampilkanDetail();
                    break;
                case "4":
                    prosesPembayaran(transaksi);
                    break;
                case "5":
                    System.out.println("Terima kasih atas kunjungan Anda! Sampai jumpa di " + namaKedai + ".");
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tambahPesanan(Transaksi transaksi) {
        tampilkanMenu(); // Tampilkan menu utama
        while (true) {
            System.out.print("Masukkan nama menu yang ingin dipesan (atau 'kembali' untuk kembali): ");
            String namaMenu = scanner.nextLine();
    
            if (namaMenu.equalsIgnoreCase("kembali")) {
                break; // Kembali ke menu pelanggan
            }
    
            ProdukKopi produkPilihan = null;
            String ukuran = "";
    
            while (true) {
                System.out.print("Masukkan ukuran (Reguler/Large): ");
                ukuran = scanner.nextLine();
    
                if (!ukuran.equalsIgnoreCase("Reguler") && !ukuran.equalsIgnoreCase("Large")) {
                    System.out.println("Ukuran tidak valid. Silakan coba lagi (Reguler/Large).");
                    continue;
                }
    
                produkPilihan = cariProduk(namaMenu, ukuran);
                if (produkPilihan != null) {
                    break;
                } else {
                    System.out.println("Menu atau ukuran tidak valid. Silakan coba lagi.");
                    break;
                }
            }
    
            if (produkPilihan == null) {
                continue;
            }
    
            // Memeriksa stok
            if (produkPilihan.getStok() <= 0) {
                System.out.println("Maaf, stok " + produkPilihan.getNama() + " " + produkPilihan.getUkuran()
                        + " sedang habis.");
                continue;
            }
    
            // Meminta jumlah yang ingin dipesan
            int jumlah = 0;
            while (true) {
                System.out.print("Masukkan jumlah yang ingin dipesan: ");
                try {
                    jumlah = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline setelah membaca integer
                    if (jumlah <= 0) {
                        System.out.println("Jumlah harus lebih dari 0. Silakan coba lagi.");
                        continue;
                    }
                    if (jumlah > produkPilihan.getStok()) {
                        System.out.println("Maaf, jumlah yang dipesan melebihi stok yang tersedia. Stok saat ini: "
                                + produkPilihan.getStok());
                        continue;
                    }
                    break; // Keluar dari loop jika jumlah valid
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Masukkan angka.");
                    scanner.nextLine(); // Membersihkan input yang salah
                }
            }
    
            // Menambahkan pesanan dan mengurangi stok
            transaksi.tambahItemPesanan(produkPilihan, jumlah);
            produkPilihan.setStok(produkPilihan.getStok() - jumlah);
            System.out.println(jumlah + " " + produkPilihan.getNama() + " " + produkPilihan.getUkuran()
                    + " berhasil ditambahkan ke pesanan.");
    
            // Menawarkan topping
            System.out.print("Apakah Anda ingin menambahkan topping? (y/n): ");
            String pilihTopping = scanner.nextLine();
            if (pilihTopping.equalsIgnoreCase("y")) {
                tampilkanTopping(); // Menampilkan daftar topping
                System.out.print("Masukkan nama topping yang ingin ditambahkan (ketik 'tidak' jika tidak ingin): ");
                String namaTopping = scanner.nextLine();
    
                if (!namaTopping.equalsIgnoreCase("tidak")) {
                    System.out.print("Masukkan jumlah topping yang ingin ditambahkan: ");
                    int jumlahTopping = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline setelah membaca integer
    
                    ProdukKopi toppingPilihan = cariTopping(namaTopping);
    
                    if (toppingPilihan != null) {
                        // Menambahkan topping ke pesanan
                        transaksi.tambahItemPesanan(toppingPilihan, jumlahTopping);
                        toppingPilihan.setStok(toppingPilihan.getStok() - jumlahTopping);
                        System.out.println(jumlahTopping + " " + toppingPilihan.getNama() + " berhasil ditambahkan ke pesanan.");
                    } else {
                        System.out.println("Topping tidak ditemukan.");
                    }
                }
            }
        }
    }
    
// Metode untuk mencari produk berdasarkan nama dan ukuran
private ProdukKopi cariProduk(String nama, String ukuran) {
    for (ProdukKopi produk : daftarMenu) {
        if (produk.getNama().equalsIgnoreCase(nama) && produk.getUkuran().equalsIgnoreCase(ukuran)) {
            return produk;
        }
    }
    return null; // Jika tidak ditemukan
}


    // Metode untuk menghapus pesanan
private void hapusPesanan(Transaksi transaksi) {
    if (transaksi.getItemPesanan().isEmpty()) {
        System.out.println("Belum ada pesanan untuk dihapus.");
        return;
    }

    System.out.println("Daftar Pesanan:");
    List<ItemPesanan> itemPesanan = transaksi.getItemPesanan();
    for (int i = 0; i < itemPesanan.size(); i++) {
        ItemPesanan item = itemPesanan.get(i);
        System.out.println((i + 1) + ". " + item.getProduk().getNama() + " (" + item.getJumlah() + " x Rp" + item.getProduk().getHarga() + ")");
    }

    System.out.print("Masukkan nomor pesanan yang ingin dihapus: ");
    int nomorPesanan = 0;
    try {
        nomorPesanan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
    } catch (InputMismatchException e) {
        System.out.println("Input tidak valid. Masukkan angka.");
        scanner.nextLine(); // Membersihkan input yang salah
        return;
    }

    if (nomorPesanan <= 0 || nomorPesanan > itemPesanan.size()) {
        System.out.println("Nomor pesanan tidak valid.");
        return;
    }

    ItemPesanan itemYangAkanDihapus = itemPesanan.get(nomorPesanan - 1);
    int jumlahTersedia = itemYangAkanDihapus.getJumlah();

    System.out.print("Masukkan jumlah yang ingin dihapus (maksimal " + jumlahTersedia + "): ");
    int jumlahYangAkanDihapus = 0;
    try {
        jumlahYangAkanDihapus = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
    } catch (InputMismatchException e) {
        System.out.println("Input tidak valid. Masukkan angka.");
        scanner.nextLine(); // Membersihkan input yang salah
        return;
    }

    if (jumlahYangAkanDihapus <= 0 || jumlahYangAkanDihapus > jumlahTersedia) {
        System.out.println("Jumlah tidak valid. Masukkan jumlah antara 1 dan " + jumlahTersedia + ".");
        return;
    }

    // Menghapus sebagian item
    if (jumlahYangAkanDihapus < jumlahTersedia) {
        // Mengurangi jumlah item yang ada
        itemYangAkanDihapus.setJumlah(itemYangAkanDihapus.getJumlah() - jumlahYangAkanDihapus);
        transaksi.kurangiTotalHarga(itemYangAkanDihapus.getProduk().getHarga() * jumlahYangAkanDihapus); // Perbaikan disini
        System.out.println(jumlahYangAkanDihapus + " " + itemYangAkanDihapus.getProduk().getNama() + " berhasil dihapus dari pesanan.");
    } else {
        transaksi.kurangiTotalHarga(itemYangAkanDihapus.getProduk().getHarga() * itemYangAkanDihapus.getJumlah()); // dan juga disini
        // Menghapus seluruh item
        itemPesanan.remove(nomorPesanan - 1);
        System.out.println("Pesanan berhasil dihapus.");
    }
}

// Metode untuk menampilkan menu
private void tampilkanMenu() {
    System.out.println("\n--- Menu Kopi ---");
    System.out.printf("%-45s %-10s %-10s\n", "Nama Produk", "Reguler", "Large");
    System.out.println("--------------------------------------------------------------------------------");

    for (int i = 0; i < daftarMenu.size(); i += 2) {
        String namaProduk = daftarMenu.get(i).getNama();
        double hargaReguler = daftarMenu.get(i).getHarga();
        double hargaLarge = (i + 1 < daftarMenu.size()) ? daftarMenu.get(i + 1).getHarga() : 0;

        System.out.printf("%-45s", namaProduk);
        System.out.printf("Rp%-9.0f ", hargaReguler);
        if (hargaLarge > 0) {
            System.out.printf("Rp%-9.0f\n", hargaLarge);
        } else {
            System.out.println();
        }
    }

    System.out.println("--------------------------------------------------------------------------------");
    //System.out.println((daftarMenu.size() / 2) + 1 + ". Kembali"); // Baris ini dihapus
}

 // Metode untuk memproses pembayaran
 private void prosesPembayaran(Transaksi transaksi) {
    if (transaksi.getItemPesanan().isEmpty()) {
        System.out.println("Tidak ada pesanan yang perlu dibayar.");
        return;
    }

    transaksi.tampilkanDetail();

    System.out.println("\nPilih metode pembayaran:");
    System.out.println("1. Tunai");
    System.out.println("2. Kartu Kredit");
    System.out.println("3. E-wallet");

    System.out.print("Masukkan nomor metode pembayaran: ");
    String metodePembayaran = inputMetodePembayaran();

    switch (metodePembayaran) {
        case "1":
            transaksi.setMetodePembayaran("Tunai");
            break;
        case "2":
            transaksi.setMetodePembayaran("Kartu Kredit");
            pilihBankKartuKredit(transaksi); // Memilih bank kartu kredit
            break;
        case "3":
            transaksi.setMetodePembayaran("E-wallet");
            pilihEWallet(transaksi); // Memilih E-wallet
            break;
        default:
            System.out.println("Metode pembayaran tidak valid.");
            return;
    }

    transaksi.prosesPembayaran();
    System.out.println("Pembayaran berhasil!");
    daftarTransaksi.add(transaksi); // Menambahkan transaksi ke daftar transaksi
}

// Metode untuk memilih bank kartu kredit
private void pilihBankKartuKredit(Transaksi transaksi) {
    System.out.println("\nPilih bank kartu kredit (masukkan kode):");
    System.out.println("1. Bank Mandiri");
    System.out.println("2. Bank Rakyat Indonesia (BRI)");
    System.out.println("3. Bank Central Asia (BCA)");
    System.out.println("4. Bank Negara Indonesia (BNI)");
    System.out.println("5. Bank CIMB Niaga");
    System.out.println("6. Bank Danamon");
    System.out.println("7. Bank Panin");
    System.out.println("8. Bank OCBC NISP");
    System.out.println("9. Bank Maybank Indonesia");
    System.out.println("10. Bank Permata");
    System.out.println("11. Bank Mega");
    System.out.println("12. Bank BTPN");
    System.out.println("13. Bank Bukopin");
    System.out.println("14. Bank DBS Indonesia");
    System.out.println("15. Bank HSBC Indonesia");
    System.out.println("16. Bank Commonwealth");
    System.out.println("17. Bank ANZ Indonesia");
    System.out.println("18. Bank UOB Indonesia");
    System.out.println("19. Bank Shinhan Indonesia");
    System.out.println("20. Bank Woori Saudara");
    System.out.println("21. Bank Syariah Indonesia (BSI)");
    System.out.println("22. Bank Muamalat Indonesia");
    System.out.println("23. Bank Mega Syariah");
    System.out.println("24. Panin Dubai Syariah Bank");
    System.out.println("25. Bank BCA Syariah");
    System.out.println("26. Bank Bukopin Syariah");
    System.out.println("27. Bank Victoria Syariah");
    System.out.println("28. Bank Jabar Banten Syariah (BJBS)");
    System.out.println("29. Bank Aceh Syariah");
    System.out.println("30. Bank NTB Syariah");
    System.out.println("31. Bank DKI");
    System.out.println("32. Bank Jabar Banten (BJB)");
    System.out.println("33. Bank Jatim (Bank Jawa Timur)");
    System.out.println("34. Bank Jateng (Bank Jawa Tengah)");
    System.out.println("35. Bank DIY (Bank Daerah Istimewa Yogyakarta)");
    System.out.println("36. Bank Sumut (Bank Sumatera Utara)");
    System.out.println("37. Bank Sumsel Babel (Bank Sumatera Selatan dan Bangka Belitung)");
    System.out.println("38. Bank Nagari (Bank Sumatera Barat)");
    System.out.println("39. Bank Riau Kepri (Bank Riau dan Kepulauan Riau)");
    System.out.println("40. Bank Kalsel (Bank Kalimantan Selatan)");
    System.out.println("41. Bank Kaltim (Bank Kalimantan Timur)");
    System.out.println("42. Bank Kalbar (Bank Kalimantan Barat)");
    System.out.println("43. Bank Sulselbar (Bank Sulawesi Selatan dan Barat)");
    System.out.println("44. Bank Sultra (Bank Sulawesi Tenggara)");
    System.out.println("45. Bank Sulteng (Bank Sulawesi Tengah)");
    System.out.println("46. Bank SulutGo (Bank Sulawesi Utara)");
    System.out.println("47. Bank Papua");
    System.out.println("48. Bank Maluku Malut (Bank Maluku dan Maluku Utara)");
    System.out.println("49. Bank NTT (Bank Nusa Tenggara Timur)");
    System.out.println("50. Bank Bengkulu");
    System.out.println("51. Bank Lampung");
    System.out.println("52. Bank BPD Bali");
    System.out.println("53. Bank NTB (Bank Nusa Tenggara Barat)");
    System.out.println("54. Citibank Indonesia");
    System.out.println("55. Standard Chartered Bank Indonesia");
    System.out.println("56. Deutsche Bank Indonesia");
    System.out.println("57. Bank of China (Hong Kong) Limited");
    System.out.println("58. Mizuho Bank Indonesia");
    System.out.println("59. Bank of America Indonesia");
    System.out.println("60. J.P. Morgan Chase Bank Indonesia");
    System.out.println("61. Rabobank International Indonesia");
    System.out.println("62. Bank Jago");
    System.out.println("63. Bank Neo Commerce");
    System.out.println("64. Bank Aladin Syariah");
    System.out.println("65. Bank Seabank Indonesia");
    System.out.println("66. Bank KB Bukopin (digital banking)");
    System.out.println("67. Bank BCA Digital");
    System.out.println("68. Bank Digital BRI (BRImo)");
    System.out.println("69. Bank Syariah Indonesia Digital (BSI Mobile)");
    System.out.println("70. Bank Tabungan Negara (BTN)");
    System.out.println("71. Bank Ekspor Indonesia");
    System.out.println("72. Bank Pembangunan Daerah (BPD)");
    System.out.println("73. Bank Hana Indonesia");
    System.out.println("74. Bank Mestika Dharma");
    System.out.println("75. Bank Mayapada");
    System.out.println("76. Bank Artos Indonesia");
    System.out.println("77. Bank SBI Indonesia");
    System.out.println("78. Bank Ganesha");
    System.out.println("79. Bank Maspion");

    System.out.print("Masukkan kode bank: ");
    String kodeBank = scanner.nextLine();

    String namaBank = "";
    switch (kodeBank) {
        case "1":
            namaBank = "Bank Mandiri";
            break;
        case "2":
            namaBank = "Bank Rakyat Indonesia (BRI)";
            break;
        case "3":
            namaBank = "Bank Central Asia (BCA)";
            break;
        case "4":
            namaBank = "Bank Negara Indonesia (BNI)";
            break;
        case "5":
            namaBank = "Bank CIMB Niaga";
            break;
        case "6":
            namaBank = "Bank Danamon";
            break;
        case "7":
            namaBank = "Bank Panin";
            break;
        case "8":
            namaBank = "Bank OCBC NISP";
            break;
        case "9":
            namaBank = "Bank Maybank Indonesia";
            break;
        case "10":
            namaBank = "Bank Permata";
            break;
        case "11":
            namaBank = "Bank Mega";
            break;
        case "12":
            namaBank = "Bank BTPN";
            break;
        case "13":
            namaBank = "Bank Bukopin";
            break;
        case "14":
            namaBank = "Bank DBS Indonesia";
            break;
        case "15":
            namaBank = "Bank HSBC Indonesia";
            break;
        case "16":
            namaBank = "Bank Commonwealth";
            break;
        case "17":
            namaBank = "Bank ANZ Indonesia";
        case "18":
            namaBank = "Bank UOB Indonesia";
            break;
        case "19":
            namaBank = "Bank Shinhan Indonesia";
            break;
        case "20":
            namaBank = "Bank Woori Saudara";
            break;
        case "21":
            namaBank = "Bank Syariah Indonesia (BSI)";
            break;
        case "22":
            namaBank = "Bank Muamalat Indonesia";
            break;
        case "23":
            namaBank = "Bank Mega Syariah";
            break;
        case "24":
            namaBank = "Panin Dubai Syariah Bank";
            break;
        case "25":
            namaBank = "Bank BCA Syariah";
            break;
        case "26":
            namaBank = "Bank Bukopin Syariah";
            break;
        case "27":
            namaBank = "Bank Victoria Syariah";
            break;
        case "28":
            namaBank = "Bank Jabar Banten Syariah (BJBS)";
            break;
        case "29":
            namaBank = "Bank Aceh Syariah";
            break;
        case "30":
            namaBank = "Bank NTB Syariah";
            break;
        case "31":
            namaBank = "Bank DKI";
            break;
        case "32":
            namaBank = "Bank Jabar Banten (BJB)";
            break;
        case "33":
            namaBank = "Bank Jatim (Bank Jawa Timur)";
            break;
        case "34":
            namaBank = "Bank Jateng (Bank Jawa Tengah)";
        case "35":
            namaBank = "Bank DIY (Bank Daerah Istimewa Yogyakarta)";
            break;
        case "36":
            namaBank = "Bank Sumut (Bank Sumatera Utara)";
            break;
        case "37":
            namaBank = "Bank Sumsel Babel (Bank Sumatera Selatan dan Bangka Belitung)";
            break;
        case "38":
            namaBank = "Bank Nagari (Bank Sumatera Barat)";
            break;
        case "39":
            namaBank = "Bank Riau Kepri (Bank Riau dan Kepulauan Riau)";
            break;
        case "40":
            namaBank = "Bank Kalsel (Bank Kalimantan Selatan)";
            break;
        case "41":
            namaBank = "Bank Kaltim (Bank Kalimantan Timur)";
            break;
        case "42":
            namaBank = "Bank Kalbar (Bank Kalimantan Barat)";
            break;
        case "43":
            namaBank = "Bank Sulselbar (Bank Sulawesi Selatan dan Barat)";
            break;
        case "44":
            namaBank = "Bank Sultra (Bank Sulawesi Tenggara)";
            break;
        case "45":
            namaBank = "Bank Sulteng (Bank Sulawesi Tengah)";
            break;
        case "46":
            namaBank = "Bank SulutGo (Bank Sulawesi Utara)";
            break;
        case "47":
            namaBank = "Bank Papua";
            break;
        case "48":
            namaBank = "Bank Maluku Malut (Bank Maluku dan Maluku Utara)";
            break;
        case "49":
            namaBank = "Bank NTT (Bank Nusa Tenggara Timur)";
            break;
        case "50":
            namaBank = "Bank Bengkulu";
            break;
        case "51":
            namaBank = "Bank Lampung";
            break;
        case "52":
            namaBank = "Bank BPD Bali";
            break;
        case "53":
            namaBank = "Bank NTB (Bank Nusa Tenggara Barat)";
            break;
        case "54":
            namaBank = "Citibank Indonesia";
            break;
        case "55":
            namaBank = "Standard Chartered Bank Indonesia";
            break;
        case "56":
            namaBank = "Deutsche Bank Indonesia";
            break;
        case "57":
            namaBank = "Bank of China (Hong Kong) Limited";
            break;
        case "58":
            namaBank = "Mizuho Bank Indonesia";
            break;
        case "59":
            namaBank = "Bank of America Indonesia";
            break;
        case "60":
            namaBank = "J.P. Morgan Chase Bank Indonesia";
            break;
        case "61":
            namaBank = "Rabobank International Indonesia";
            break;
        case "62":
            namaBank = "Bank Jago";
            break;
        case "63":
            namaBank = "Bank Neo Commerce";
            break;
        case "64":
            namaBank = "Bank Aladin Syariah";
            break;
        case "65":
            namaBank = "Bank Seabank Indonesia";
            break;
        case "66":
            namaBank = "Bank KB Bukopin (digital banking)";
            break;
        case "67":
            namaBank = "Bank BCA Digital";
            break;
        case "68":
            namaBank = "Bank Digital BRI (BRImo)";
            break;
        case "69":
            namaBank = "Bank Syariah Indonesia Digital (BSI Mobile)";
            break;
        case "70":
            namaBank = "Bank Tabungan Negara (BTN)";
            break;
        case "71":
            namaBank = "Bank Ekspor Indonesia";
        case "72":
            namaBank = "Bank Pembangunan Daerah (BPD)";
            break;
        case "73":
            namaBank = "Bank Hana Indonesia";
            break;
        case "74":
            namaBank = "Bank Mestika Dharma";
            break;
        case "75":
            namaBank = "Bank Mayapada";
            break;
        case "76":
            namaBank = "Bank Artos Indonesia";
            break;
        case "77":
            namaBank = "Bank SBI Indonesia";
            break;
        case "78":
            namaBank = "Bank Ganesha";
            break;
        case "79":
            namaBank = "Bank Maspion";
            break;

        default:
            System.out.println("Kode bank tidak valid.");
            return;
    }

    transaksi.setMetodePembayaran("Kartu Kredit (" + namaBank + ")");
}

 // Metode untuk memilih E-wallet
 private void pilihEWallet(Transaksi transaksi) {
    System.out.println("\nPilih E-wallet (masukkan kode):");
    System.out.println("1. GoPay");
    System.out.println("2. OVO");
    System.out.println("3. DANA");
    System.out.println("4. ShopeePay");
    System.out.println("5. LinkAja");
    System.out.println("6. Jenius");
    System.out.println("7. Sakuku");
    System.out.println("8. DOKU");
    System.out.println("9. PayTren");
    System.out.println("10. iSaku");
    System.out.println("11. Tapp");
    System.out.println("12. Octo Mobile");
    System.out.println("13. BRIZZI");
    System.out.println("14. Flip");
    System.out.println("15. GrabKios");
    System.out.println("16. PonselPay");
    System.out.println("17. EMoney");
    System.out.println("18. Flazz");
    System.out.println("19. TapCash");

    System.out.print("Masukkan kode E-wallet: ");
    String nomorEWallet = scanner.nextLine();

    String namaEWallet = "";
    switch (nomorEWallet) {
        case "1":
            namaEWallet = "GoPay";
            break;
        case "2":
            namaEWallet = "OVO";
            break;
        case "3":
            namaEWallet = "DANA";
            break;
        case "4":
            namaEWallet = "ShopeePay";
            break;
        case "5":
            namaEWallet = "LinkAja";
            break;
        case "6":
            namaEWallet = "Jenius";
            break;
        case "7":
            namaEWallet = "Sakuku";
            break;
        case "8":
            namaEWallet = "DOKU";
            break;
        case "9":
            namaEWallet = "PayTren";
            break;
        case "10":
            namaEWallet = "iSaku";
            break;
        case "11":
            namaEWallet = "Tapp";
            break;
        case "12":
            namaEWallet = "Octo Mobile";
            break;
        case "13":
            namaEWallet = "BRIZZI";
            break;
        case "14":
            namaEWallet = "Flip";
            break;
        case "15":
            namaEWallet = "GrabKios";
            break;
        case "16":
            namaEWallet = "PonselPay";
            break;
        case "17":
            namaEWallet = "EMoney";
            break;
        case "18":
            namaEWallet = "Flazz";
            break;
        case "19":
            namaEWallet = "TapCash";
            break;
        default:
            System.out.println("Kode E-wallet tidak valid.");
            return;
    }

    transaksi.setMetodePembayaran("E-wallet (" + namaEWallet + ")");
}


    // Metode untuk input nama pelanggan dengan validasi
    private String inputNamaPelanggan() {
        String nama;
        while (true) {
            System.out.print("Masukkan nama pelanggan: ");
            nama = scanner.nextLine();
            if (nama != null && !nama.isEmpty()) {
                break; // Keluar dari loop jika input valid
            } else {
                System.out.println("Nama tidak boleh kosong. Silakan coba lagi.");
            }
        }
        return nama;
    }

    // Metode untuk input nomor telepon dengan validasi
    private String inputNomorTelepon() {
        String nomorTelepon;
        while (true) {
            System.out.print("Masukkan nomor telepon: ");
            nomorTelepon = scanner.nextLine();
            if (nomorTelepon != null && nomorTelepon.matches("[0-9]+")) {
                break; // Keluar dari loop jika input valid (hanya angka)
            } else {
                System.out.println("Nomor telepon tidak valid. Harus berupa angka. Silakan coba lagi.");
            }
        }
        return nomorTelepon;
    }

    // Metode untuk input alamat pelanggan dengan validasi
    private String inputAlamatPelanggan() {
        String alamat;
        while (true) {
            System.out.print("Masukkan alamat pelanggan: ");
            alamat = scanner.nextLine();
            if (alamat != null && !alamat.isEmpty()) {
                break; // Keluar dari loop jika input valid
            } else {
                System.out.println("Alamat tidak boleh kosong. Silakan coba lagi.");
            }
        }
        return alamat;
    }

    // Metode untuk input pilihan menu dengan validasi
    private String inputPilihanMenu() {
        String pilihan;
        while (true) {
            System.out.print("Masukkan pilihan (1-5): ");
            pilihan = scanner.nextLine();
            if (pilihan != null && pilihan.matches("[1-5]")) {
                break; // Keluar dari loop jika input valid (angka 1-5)
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        return pilihan;
    }

    // Metode untuk input metode pembayaran dengan validasi
    private String inputMetodePembayaran() {
        String metode;
        while (true) {
            System.out.print("Masukkan nomor metode pembayaran (1-3): ");
            metode = scanner.nextLine();
            if (metode != null && metode.matches("[1-3]")) {
                break; // Keluar dari loop jika input valid (angka 1-3)
            } else {
                System.out.println("Metode pembayaran tidak valid. Silakan coba lagi.");
            }
        }
        return metode;
    }

    // Metode untuk menghapus menu
    private void hapusMenu() {
        tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin dihapus: ");
        int nomorMenu = 0;
        try {
            nomorMenu = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.nextLine(); // Discard invalid input
            return;
        }

        if (nomorMenu <= 0 || nomorMenu > daftarMenu.size()) {
            System.out.println("Nomor menu tidak valid.");
            return;
        }

        daftarMenu.remove(nomorMenu - 1);
        System.out.println("Menu berhasil dihapus.");
    }
}