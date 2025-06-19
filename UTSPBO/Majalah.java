package UTSPBO;
// Kelas Majalah adalah turunan (subclass) dari kelas Koleksi.
public class Majalah extends Koleksi {

    // Atribut khusus untuk kelas Majalah.
    private String edisi; // Edisi dari majalah (misal: "Januari 2024").
    private int bulanTerbit; // Bulan terbit majalah (misal: 1 untuk Januari).

    // Konstruktor untuk kelas Majalah.
    Majalah(String idKoleksi, String judul, int tahunTerbit, String edisi, int bulanTerbit) {
        // Memanggil konstruktor dari kelas induk (Koleksi) untuk menginisialisasi atribut yang diwariskan.
        super(idKoleksi, judul, tahunTerbit);
        // Menginisialisasi atribut spesifik untuk Majalah.
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
    }

    // Metode publik (getter) untuk mendapatkan edisi majalah.
    public String getEdisi() {
        return this.edisi; // Mengembalikan nilai edisi.
    }

    // Metode publik (getter) untuk mendapatkan bulan terbit.
    public int getBulanTerbit() {
        return this.bulanTerbit; // Mengembalikan nilai bulanTerbit.
    }
}
