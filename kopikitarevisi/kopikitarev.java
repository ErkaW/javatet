package kopikitarevisi;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class kopikitarev {
    // Deklarasi variabel
    /* Tanggal dan Waktu */
    static String tanggal = "";
    static int jam = 0;
    static int menit = 0;
    static int detik = 0;
    /* Menu Kopi yang Dijual */
    static int totalKopi = 10;
    static int[] idKopi = {1,2,3,4,5,6,7,8,9,10};
    static String[] namaKopi = {
        "Americano",
        "Black Coffee",
        "Original Coffee",
        "Maqiato\t",
        "Coco Maqiato",
        "Vanilla Latte",
        "Hazelnut Latte",
        "Coffee Latte",
        "Capuccino",
        "Kopi Tubruk"
    };
    static int[] hargaKopi = {
        13000,
        13000,
        13000,
        13000,
        13000,
        15000,
        15000,
        13000,
        13000,
        6000
    };
    static int[] stokKopi = {
        25,
        25,
        25,
        25,
        25,
        25,
        25,
        25,
        25,
        25
    };
    /* Statistika Toko */
    static int[] idKopiTerjual = new int[100];
    static int[] jumlahKopiTerjual = new int[100];
    static int[] totalHargaKopiTerjual = new int[100];
    static int totalKopiTerjual = 0;
    static int totalPendapatan = 0;
    static int totalPengeluaran = 0;
    static int totalKeuntungan = 0;
    static int totalStok = 0;
    static int sisaStok = 0;
    /* Data Pelanggan */
    static int[] idPelanggan = new int[100];
    static String[] namaPelanggan = new String[100];
    static int totalPelanggan = 0;
    /* List Pesanan */
    static int[] idKopiDipesan = new int[100];
    static int[] jumlahKopiDipesan = new int[100];
    static int[] totalHargaKopiDipesan = new int[100];
    static int totalPesanan = 0;
    /* Pesanan Kopi */
    static int[] idKopiPesanan = new int[100];
    static int[] jumlahKopiPesanan = new int[100];
    static String[] namaKopiPesanan = new String[100];
    static int[] hargaKopiPesanan = new int[100];
    /* Checkout Pesanan */
    static int totalHargaPesanan = 0;
    static int uangBayar = 0;
    static int uangKembalian = 0;
    /* Edit Pesanan */
    static int idKopiEdit = 0;
    static int jumlahKopiEdit = 0;
    static int totalHargaKopiEdit = 0;

    // Method untuk mebersihkan layar
    public static void bersihkanLayar() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
    // Method untuk menampilkan tanggal dan waktu saat ini
    static void systemtime() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String waktu = sdf.format(date);
        tanggal = waktu.substring(0, 10);
        jam = Integer.parseInt(waktu.substring(11, 13));
        menit = Integer.parseInt(waktu.substring(14, 16));
        detik = Integer.parseInt(waktu.substring(17, 19));
    }
    // Method untuk menampilkan header aplikasi
    static void header() {
        System.out.println("==========================================");
        System.out.println("Kopi Kita");
        System.out.println("==========================================");
        System.out.println("Tanggal : " + tanggal + "\t" 
                        + "Waktu : " + jam + ":" + menit + ":" + detik);
        System.out.println("==========================================");
    }
    // Method untuk menampilkan menu data pelanggan
    static void menuDataPelanggan() {
        System.out.println("==========================================");
        System.out.println("Data Pelanggan");
        System.out.println("==========================================");
        System.out.println("ID\tNama Pelanggan");
        for (int i = 0; i < totalPelanggan; i++) {
            System.out.println(idPelanggan[i] + "\t" + namaPelanggan[i]);
        }
        System.out.println("==========================================");
    }
    // Method untuk menampilkan opsi edit data pelanggan
    static void menuEditDataPelanggan() {
        System.out.println("==========================================");
        System.out.println("Edit Data Pelanggan");
        System.out.println("==========================================");
        System.out.println("1. Tambah Data Pelanggan");
        System.out.println("2. Edit Data Pelanggan");
        System.out.println("3. Hapus Data Pelanggan");
        System.out.println("4. Kembali");
        System.out.println("==========================================");
    }
    // Method untuk memilih opsi edit data pelanggan
    static void pilihEditDataPelanggan() {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih Opsi : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                tambahDataPelanggan();
                break;
            case 2:
                editDataPelanggan();
                break;
            case 3:
                hapusDataPelanggan();
                break;
            case 4:
                menuUtama();
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }
    // Method untuk menambah data pelanggan
    static void tambahDataPelanggan() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Tambah Data Pelanggan");
        System.out.println("==========================================");
        System.out.print("ID Pelanggan : ");
        idPelanggan[totalPelanggan] = input.nextInt();
        System.out.print("Nama Pelanggan : ");
        namaPelanggan[totalPelanggan] = input.next();
        totalPelanggan++;
        System.out.println("==========================================");
        System.out.println("Data Pelanggan Berhasil Ditambahkan");
        System.out.println("==========================================");
    }
    // Method untuk mengedit data pelanggan
    static void editDataPelanggan() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Edit Data Pelanggan");
        System.out.println("==========================================");
        System.out.print("ID Pelanggan : ");
        int idPelangganEdit = input.nextInt();
        for (int i = 0; i < totalPelanggan; i++) {
            if (idPelanggan[i] == idPelangganEdit) {
                System.out.print("Nama Pelanggan : ");
                namaPelanggan[i] = input.next();
                System.out.println("==========================================");
                System.out.println("Data Pelanggan Berhasil Diubah");
                System.out.println("==========================================");
                break;
            }
        }
    }
    // Method untuk menghapus data pelanggan
    static void hapusDataPelanggan() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Hapus Data Pelanggan");
        System.out.println("==========================================");
        System.out.print("ID Pelanggan : ");
        int idPelangganHapus = input.nextInt();
        for (int i = 0; i < totalPelanggan; i++) {
            if (idPelanggan[i] == idPelangganHapus) {
                for (int j = i; j < totalPelanggan; j++) {
                    idPelanggan[j] = idPelanggan[j + 1];
                    namaPelanggan[j] = namaPelanggan[j + 1];
                }
                totalPelanggan--;
                System.out.println("==========================================");
                System.out.println("Data Pelanggan Berhasil Dihapus");
                System.out.println("==========================================");
                break;
            }
        }
    }
    // Method untuk menampilkan opsi transaksi kopi
    static void menuTransaksiKopi() {
        System.out.println("==========================================");
        System.out.println("Transaksi Kopi");
        System.out.println("==========================================");
        System.out.println("1. Pesan Kopi");
        System.out.println("2. Edit Pesanan");
        System.out.println("3. Checkout Pesanan");
        System.out.println("4. Kembali");
        System.out.println("==========================================");
    }
    // Method untuk memilih opsi transaksi kopi
    static void pilihmenuTransaksiKopi() {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih Opsi : ");
        int pilihTransaksiKopi = input.nextInt();
        switch (pilihTransaksiKopi) {
            case 1:
                menuPesanKopi();
                break;
            case 2:
                mainmenuEditPesanan();
                break;
            case 3:
                mainmenuCheckoutPesanan();
                break;
            case 4:
                break;
            default:
                System.out.println("==========================================");
                System.out.println("Opsi Tidak Tersedia");
                System.out.println("==========================================");
                break;
        }
    }
    // Method untuk menampilkan menu kopi
    static void menuPesanKopi() {
        System.out.println("==========================================");
        System.out.println("Menu Kopi");
        System.out.println("==========================================");
        System.out.println("ID\tNama Kopi\t\tHarga");
        for (int i = 1; i <= totalKopi; i++) {
            System.out.println(idKopi[i] + "\t" + namaKopi[i] + "\t\t" + hargaKopi[i]);
        }
        System.out.println("==========================================");
    }
    // Method untuk menambah pesanan kopi
    static void tambahPesananKopi() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Pesan Kopi");
        System.out.println("==========================================");
        System.out.print("ID Kopi : ");
        int idKopiPesan = input.nextInt();
        System.out.print("Jumlah Pesanan : ");
        int jumlahPesanan = input.nextInt();
        for (int i = 0; i < totalKopi; i++) {
            if (idKopi[i] == idKopiPesan) {
                idKopiPesanan[totalPesanan] = idKopiPesan;
                namaKopiPesanan[totalPesanan] = namaKopi[i];
                hargaKopiPesanan[totalPesanan] = hargaKopi[i];
                jumlahKopiPesanan[totalPesanan] = jumlahPesanan;
                totalPesanan++;
                System.out.println("==========================================");
                System.out.println("Pesanan Berhasil Ditambahkan");
                System.out.println("==========================================");
                break;
            }
        }
    }
    // Method untuk menampilkan menu edit pesanan
    static void menuUtamaEditPesanan() {
        menuEditPesanan();
        pilihEditPesanan();
    }
    // Method untuk menampilkan opsi edit pesanan
    static void menuEditPesanan() {
        System.out.println("==========================================");
        System.out.println("Edit Pesanan");
        System.out.println("==========================================");
        System.out.println("1. Edit Jumlah Pesanan");
        System.out.println("2. Hapus Pesanan");
        System.out.println("3. Kembali");
        System.out.println("==========================================");
    }
    // Method untuk memilih opsi edit pesanan
    static void pilihEditPesanan() {
        Scanner input = new Scanner(System.in);
        menuEditPesanan();
        System.out.print("Pilih Opsi : ");
        int pilihOpsi = input.nextInt();
        switch (pilihOpsi) {
            case 1:
                editJumlahPesananKopi();
                break;
            case 2:
                hapusPesananKopi();
                break;
            case 3:
                break;
            default:
                System.out.println("==========================================");
                System.out.println("Opsi Tidak Tersedia");
                System.out.println("==========================================");
                break;
        }
    }
    // Method untuk menampilkan pesanan kopi
    static void tampilPesananKopi() {
        System.out.println("==========================================");
        System.out.println("Pesanan Kopi");
        System.out.println("==========================================");
        System.out.println("ID\tNama Kopi\t\tHarga\tJumlah\tTotal");
        for (int i = 0; i < totalPesanan; i++) {
            int totalHarga = hargaKopiPesanan[i] * jumlahKopiPesanan[i];
            System.out.println(idKopiPesanan[i] + "\t" + namaKopiPesanan[i] + "\t\t" + hargaKopiPesanan[i] + "\t" + jumlahKopiPesanan[i] + "\t" + totalHarga);
        }
        System.out.println("==========================================");
    }
    // Method untuk menghapus pesanan kopi
    static void hapusPesananKopi() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Hapus Pesanan Kopi");
        System.out.println("==========================================");
        System.out.print("ID Kopi : ");
        int idKopiHapus = input.nextInt();
        for (int i = 0; i < totalPesanan; i++) {
            if (idKopiPesanan[i] == idKopiHapus) {
                for (int j = i; j < totalPesanan; j++) {
                    idKopiPesanan[j] = idKopiPesanan[j + 1];
                    namaKopiPesanan[j] = namaKopiPesanan[j + 1];
                    hargaKopiPesanan[j] = hargaKopiPesanan[j + 1];
                    jumlahKopiPesanan[j] = jumlahKopiPesanan[j + 1];
                }
                totalPesanan--;
                System.out.println("==========================================");
                System.out.println("Pesanan Berhasil Dihapus");
                System.out.println("==========================================");
                break;
            }
        }
    }
    // Method untuk mengedit pesanan kopi
    static void editJumlahPesananKopi() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Edit Pesanan Kopi");
        System.out.println("==========================================");
        System.out.print("ID Kopi : ");
        int idKopiEdit = input.nextInt();
        for (int i = 0; i < totalPesanan; i++) {
            if (idKopiPesanan[i] == idKopiEdit) {
                System.out.print("Jumlah Pesanan : ");
                int jumlahPesanan = input.nextInt();
                jumlahKopiPesanan[i] = jumlahPesanan;
                System.out.println("==========================================");
                System.out.println("Pesanan Berhasil Diedit");
                System.out.println("==========================================");
                break;
            }
        }
    }
    // Method untuk menampilkan menu checkout
    static void menuCheckout() {
        System.out.println("==========================================");
        System.out.println("Checkout Pesanan");
        System.out.println("==========================================");
        System.out.println("1. Bayar");
        System.out.println("2. Kembali");
        System.out.println("==========================================");
    }
    // Method untuk memilih menu checkout
    static void pilihMenuCheckout() {
        Scanner input = new Scanner(System.in);
        menuCheckout();
        System.out.print("Pilih Menu : ");
        int pilihMenuCheckout = input.nextInt();
        switch (pilihMenuCheckout) {
            case 1:
                bayarPesanan();
                break;
            case 2:
                break;
            default:
                System.out.println("==========================================");
                System.out.println("Menu Tidak Tersedia");
                System.out.println("==========================================");
                break;
        }
    }
    // Method untuk membayar pesanan
    static void bayarPesanan() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Bayar Pesanan");
        System.out.println("==========================================");
        System.out.print("Jumlah Uang : ");
        int jumlahUang = input.nextInt();
        int totalHarga = 0;
        for (int i = 0; i < totalPesanan; i++) {
            totalHarga += hargaKopiPesanan[i] * jumlahKopiPesanan[i];
        }
        if (jumlahUang >= totalHarga) {
            System.out.println("==========================================");
            System.out.println("Total Harga : " + totalHarga);
            System.out.println("Kembalian : " + (jumlahUang - totalHarga));
            System.out.println("==========================================");
            System.out.println("Pesanan Berhasil Dibayar");
            System.out.println("==========================================");
            totalPesanan = 0;
        } else {
            System.out.println("==========================================");
            System.out.println("Uang Anda Kurang");
            System.out.println("==========================================");
        }
    }
    // Method untuk menampilkan menu print struk
    static void menuPrintStruk() {
        System.out.println("==========================================");
        System.out.println("Print Struk");
        System.out.println("==========================================");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.println("==========================================");
    }
    // Method untuk memilih menu print struk
    static void pilihMenuPrintStruk() {
        Scanner input = new Scanner(System.in);
        menuPrintStruk();
        System.out.print("Pilih Menu : ");
        int pilihMenuPrintStruk = input.nextInt();
        switch (pilihMenuPrintStruk) {
            case 1:
                printStruk();
                break;
            case 2:
                break;
            default:
                System.out.println("==========================================");
                System.out.println("Menu Tidak Tersedia");
                System.out.println("==========================================");
                break;
        }
    }
    // Method untuk mencetak struk ke txt
    static void printStruk() {
        if(filestruk == totalPesanan){
            try {
                FileWriter fileWriter = new FileWriter("struk"+filestruk+".txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println("==========================================");
                printWriter.println("Struk Pembayaran");
                printWriter.println("==========================================");
                printWriter.println("Tanggal : " + tanggal + "\t" + "Waktu : " + jam + ":" + menit + ":" + detik);
                printWriter.println("==========================================");
                printWriter.println("ID Kopi\tNama Kopi\tHarga\tJumlah\tTotal");
                printWriter.println("==========================================");
                int totalHarga = 0;
                for (int i = 0; i < totalPesanan; i++) {
                    totalHarga = hargaKopiPesanan[i] * jumlahKopiPesanan[i];
                    printWriter.println(idKopiPesanan[i] + "\t" + namaKopiPesanan[i] + "\t\t" + hargaKopiPesanan[i] + "\t" + jumlahKopiPesanan[i] + "\t" + totalHarga);
                }
                printWriter.println("==========================================");
                printWriter.close();
                System.out.println("==========================================");
                System.out.println("Struk Berhasil Dicetak");
                System.out.println("==========================================");
            } catch (IOException e) {
                System.out.println("==========================================");
                System.out.println("Struk Gagal Dicetak");
                System.out.println("==========================================");
            }
        }
    }



    // Main Menu Aplikasi
    public static void mainAplikasi(){

    }
    // Main Menu Utama
    public static void mainmenuUtama() {
        menuUtama();
        pilihMenuUtama();
    }

    // Main Menu Data Pelanggan

    // Main Menu Transaksi
    public static void mainmenuTransaksi(){
        menuTransaksiKopi();
        pilihmenuTransaksiKopi();
    }

    // Main Menu Statistik Penjualan Kopi & Stok Kopi

    // Main Menu Keluar
    public static void mainmenuKeluar(){
        menuKeluar();
        pilihMenuKeluar();
    }

    // Main Runtime
    public static void main(String[] args) {
        bersihkanLayar();
        mainAplikasi();

    }
    
}
