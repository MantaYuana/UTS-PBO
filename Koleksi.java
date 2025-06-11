// Ini adalah kelas induk (superclass) untuk semua item di perpustakaan.
public class Koleksi {

    // Atribut yang dilindungi (private), hanya bisa diakses di dalam kelas ini.
    private String idKoleksi; // ID unik untuk setiap koleksi.
    private String judul; // Judul koleksi.
    private int tahunTerbit; // Tahun terbit koleksi.

    // Konstruktor untuk kelas Koleksi. Dipanggil saat objek Koleksi atau turunannya dibuat.
    Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi; // Menginisialisasi idKoleksi dengan nilai dari parameter.
        this.judul = judul; // Menginisialisasi judul.
        this.tahunTerbit = tahunTerbit; // Menginisialisasi tahunTerbit.
    }

    // Metode publik (getter) untuk mendapatkan nilai idKoleksi dari luar kelas.
    public String getIdKoleksi(){
        return this.idKoleksi; // Mengembalikan nilai dari idKoleksi.
    }
    
    // Metode publik (getter) untuk mendapatkan nilai judul.
    public String getJudul(){
        return this.judul; // Mengembalikan nilai dari judul.
    }
    
    // Metode publik (getter) untuk mendapatkan nilai tahunTerbit.
    public int getTahunTerbit(){
        return this.tahunTerbit; // Mengembalikan nilai dari tahunTerbit.
    }
}
