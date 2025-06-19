package UTSPBO;
// Kelas Komik adalah turunan (subclass) dari kelas Koleksi.
public class Komik extends Koleksi {

    // Atribut khusus untuk kelas Komik.
    private String ilustrator; // Nama ilustrator komik.
    private int volume; // Nomor volume dari seri komik.

    // Konstruktor untuk kelas Komik.
    Komik(String idKoleksi, String judul, int tahunTerbit, String ilustrator, int volume) {
        // Memanggil konstruktor dari kelas induk (Koleksi) untuk menginisialisasi atribut yang diwariskan.
        super(idKoleksi, judul, tahunTerbit);
        // Menginisialisasi atribut spesifik untuk Komik.
        this.ilustrator = ilustrator;
        this.volume = volume;
    }

    // Metode publik (getter) untuk mendapatkan nama ilustrator.
    public String getIlustrator() {
        return this.ilustrator; // Mengembalikan nilai ilustrator.
    }

    // Metode publik (getter) untuk mendapatkan volume komik.
    public int getVolume() {
        return this.volume; // Mengembalikan nilai volume.
    }
}
