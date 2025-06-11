// Kelas Buku adalah turunan (subclass) dari kelas Koleksi.
public class Buku extends Koleksi{

    // Atribut khusus untuk kelas Buku.
    private String penulis; // Nama penulis buku.
    private int jumlahHalaman; // Jumlah halaman buku.

    // Konstruktor untuk kelas Buku.
    Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int jumlahHalaman) {
        // Memanggil konstruktor dari kelas induk (Koleksi) untuk menginisialisasi atribut yang diwariskan.
        super(idKoleksi, judul, tahunTerbit); 
        // Menginisialisasi atribut spesifik untuk Buku.
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
    }
    
    // Metode publik (getter) untuk mendapatkan nama penulis.
    public String getPenulis(){
        return this.penulis; // Mengembalikan nilai penulis.
    }
    
    // Metode publik (getter) untuk mendapatkan jumlah halaman.
    public int getJumlahHalaman(){
        return this.jumlahHalaman; // Mengembalikan nilai jumlahHalaman.
    }
}
