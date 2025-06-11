// Kelas sederhana untuk merepresentasikan data pengguna.
public class User {

    // Atribut privat untuk menyimpan data pengguna.
    private String username; // Nama pengguna.
    private boolean is_admin; // Status admin (true jika admin, false jika bukan).

    // Konstruktor untuk kelas User.
    User(String username, boolean is_admin) {
        this.username = username; // Menginisialisasi username.
        this.is_admin = is_admin; // Menginisialisasi status admin.
    }

    // Metode publik (getter) untuk mendapatkan nama pengguna.
    public String getUsername() {
        return this.username; // Mengembalikan nilai username.
    }

    // Metode publik untuk memeriksa apakah pengguna adalah admin.
    public boolean isAdmin() {
        return this.is_admin; // Mengembalikan nilai is_admin.
    }
}
