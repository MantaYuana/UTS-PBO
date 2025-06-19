/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

// Mendefinisikan paket tempat kelas ini berada, untuk mengorganisir kode.
package TugasFile;

// Mengimpor kelas-kelas yang diperlukan untuk operasi file dan input/output.
import java.io.File; // Untuk merepresentasikan file atau direktori.
import java.io.FileWriter; // Untuk menulis ke file karakter.
import java.io.IOException; // Untuk menangani error saat operasi I/O.
// Mengimpor kelas-kelas utilitas yang diperlukan.
import java.util.ArrayList; // Untuk membuat daftar (list) yang ukurannya bisa berubah.
import java.util.Arrays; // Untuk membantu pekerjaan dengan array.
import java.util.List; // Merupakan interface untuk struktur data list.
import java.util.Scanner; // Untuk membaca input dari pengguna atau file.

/**
 * Kelas utama untuk aplikasi manajemen nama karyawan (ENMA).
 * Aplikasi ini dapat membuat, membaca, dan memperbarui file teks yang berisi
 * daftar nama.
 */
public class DaftarCatatan {
    // Mendefinisikan nama file sebagai konstanta agar mudah diubah jika diperlukan.
    private static final String FILENAME = "karyawan.txt";
    // Mendefinisikan karakter pemisah (delimiter) sebagai konstanta.
    private static final String DELIMITER = "|";

    /**
     * Metode utama (main) yang menjadi titik awal eksekusi program.
     * 
     * @param args Argumen baris perintah (tidak digunakan di program ini).
     */
    public static void main(String[] args) {
        // Mencetak pesan selamat datang saat aplikasi pertama kali dijalankan.
        System.out.println("Welcome to ENMA, Employee Name Management Application!");
        // Membuat satu objek Scanner untuk membaca semua input dari pengguna.
        Scanner scanner = new Scanner(System.in);
        // Memulai perulangan tak terbatas (infinite loop) untuk terus menampilkan menu.
        while (true) {
            // Menampilkan judul menu.
            System.out.println("\n---------------- ENMA Menu ----------------");
            // Menampilkan opsi menu yang tersedia untuk pengguna.
            System.out.println("1. Create/Write Employee Name");
            System.out.println("2. Read Employee Name");
            System.out.println("3. Update Employee Name");
            System.out.println("4. Exit");
            // Meminta pengguna untuk memasukkan pilihan mereka.
            System.out.print("Select Menu (1-4): ");

            // Membaca seluruh baris input dari pengguna dan menyimpannya di variabel
            // 'choice'.
            String choice = scanner.nextLine();

            // Memulai struktur switch untuk memilih aksi berdasarkan input pengguna.
            switch (choice) {
                case "1": // Jika pengguna memilih "1".
                    // Panggil metode writeFile untuk membuat atau menulis file.
                    writeFile(scanner);
                    // Hentikan eksekusi switch agar tidak jatuh ke case berikutnya.
                    break;
                case "2": // Jika pengguna memilih "2".
                    // Panggil metode readFile untuk membaca dan menampilkan isi file.
                    readFile();
                    // Hentikan eksekusi switch.
                    break;
                case "3": // Jika pengguna memilih "3".
                    // Panggil metode updateFile untuk mengubah data dalam file.
                    updateFile(scanner);
                    // Hentikan eksekusi switch.
                    break;
                case "4": // Jika pengguna memilih "4".
                    // Tampilkan pesan perpisahan.
                    System.out.println("Thank you for using the application. Goodbye!");
                    // Tutup objek scanner untuk melepaskan sumber daya sistem.
                    scanner.close();
                    // Keluar dari metode main, yang akan menghentikan seluruh program.
                    return;
                default: // Jika input pengguna tidak cocok dengan case manapun.
                    // Beri tahu pengguna bahwa pilihan mereka tidak valid.
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Metode untuk menulis nama karyawan ke dalam file berdasarkan input pengguna.
     * 
     * @param scanner Objek Scanner untuk membaca input.
     */
    public static void writeFile(Scanner scanner) {
        // Membuat sebuah ArrayList untuk menampung nama-nama yang akan ditulis.
        List<String> employees = new ArrayList<>();

        // Menampilkan header untuk sesi input nama.
        System.out.println("---------------- Enter Employee Names ----------------");
        // Memberikan instruksi kepada pengguna cara memasukkan nama.
        System.out.println("Enter names separated by '|' (Name 1 | Name 2 | Name 3).");
        // Meminta pengguna untuk memasukkan nama.
        System.out.print("Enter names: ");
        // Membaca seluruh baris input dari pengguna.
        String inputLine = scanner.nextLine();

        // Memeriksa apakah input tidak null dan tidak kosong (setelah menghapus spasi).
        if (inputLine != null && !inputLine.trim().isEmpty()) {
            // Memecah baris input menjadi array string berdasarkan karakter delimiter.
            String[] names = inputLine.split("\\" + DELIMITER);

            // Melakukan perulangan untuk setiap nama dalam array 'names'.
            for (String name : names) {
                // Menghapus spasi di awal dan akhir dari setiap nama.
                String trimmedName = name.trim();
                // Memeriksa apakah nama (setelah di-trim) tidak kosong.
                if (!trimmedName.isEmpty()) {
                    // Menambahkan nama yang sudah bersih ke dalam list 'employees'.
                    employees.add(trimmedName);
                }
            }
        }

        // Memeriksa apakah list 'employees' kosong (tidak ada nama valid yang
        // dimasukkan).
        if (employees.isEmpty()) {
            // Memberi tahu pengguna bahwa operasi dibatalkan dan keluar dari metode.
            System.out.println("\nNo names were entered. Write Operation Cancled!.");
            return;
        }

        // Menggabungkan semua nama dalam list menjadi satu string, dipisahkan oleh
        // delimiter.
        String joinedData = String.join(DELIMITER, employees);

        // Memulai blok try-with-resources untuk memastikan FileWriter ditutup secara
        // otomatis.
        try (FileWriter writer = new FileWriter(FILENAME)) {
            // Menulis string data yang sudah digabungkan ke dalam file.
            writer.write(joinedData);
            // Memberi tahu pengguna bahwa operasi tulis berhasil.
            System.out.println("\nFile '" + FILENAME + "' Write Operation is SUCCESSFUL!.");
            // Menampilkan data yang baru saja ditulis.
            System.out.println("Data written: " + joinedData);
        } catch (IOException e) { // Menangkap jika terjadi error saat menulis file.
            // Mencetak pesan error ke konsol error standar.
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    /**
     * Metode untuk membaca dan menampilkan semua nama karyawan dari file.
     */
    public static void readFile() {
        // Membuat objek File untuk merepresentasikan file yang akan dibaca.
        File file = new File(FILENAME);
        // Memeriksa apakah file tidak ada.
        if (!file.exists()) {
            // Jika tidak ada, beri tahu pengguna dan keluar dari metode.
            System.out.println("File '" + FILENAME + "' not found");
            return;
        }

        // Memulai blok try-with-resources menggunakan Scanner untuk membaca file.
        try (Scanner reader = new Scanner(new File(FILENAME))) {
            // Membaca satu baris penuh dari file.
            String dataLine = reader.nextLine();

            // Memeriksa apakah baris yang dibaca tidak null dan tidak kosong.
            if (dataLine != null && !dataLine.isEmpty()) {
                // Memecah data dari file menjadi array string berdasarkan delimiter.
                String[] employeeList = dataLine.split("\\" + DELIMITER);

                // Mencetak header untuk daftar nama.
                System.out.println("\n---------------- Employee Name: '" + FILENAME + "' ----------------");
                // Melakukan perulangan pada array 'employeeList'.
                for (int i = 0; i < employeeList.length; i++) {
                    // Mencetak setiap nama dengan nomor urut.
                    System.out.println((i + 1) + ". " + employeeList[i].trim());
                }
            } else { // Jika file ada tapi isinya kosong.
                // Beri tahu pengguna bahwa file tersebut kosong.
                System.out.println("File '" + FILENAME + "' is empty");
            }
        } catch (IOException e) { // Menangkap jika terjadi error saat membaca file.
            // Mencetak pesan error ke konsol error standar.
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    /**
     * Metode untuk memperbarui nama karyawan yang ada di dalam file.
     * 
     * @param scanner Objek Scanner untuk membaca input.
     */
    public static void updateFile(Scanner scanner) {
        // Membuat objek File untuk merepresentasikan file yang akan diubah.
        File file = new File(FILENAME);
        // Memeriksa apakah file tidak ada.
        if (!file.exists()) {
            // Jika tidak ada, beri tahu pengguna dan keluar dari metode.
            System.out.println("File '" + FILENAME + "' not found");
            return;
        }

        // Menampilkan header untuk proses pembaruan.
        System.out.println("---------------- Update Employee Name ----------------");
        // Memanggil readFile() untuk menunjukkan data saat ini kepada pengguna.
        readFile();

        // Meminta pengguna memasukkan indeks data yang ingin diubah.
        System.out.print("Enter OLD employee name: ");
        // Membaca input pengguna untuk data lama. (CATATAN: Logika ini membandingkan
        // nama, bukan indeks)
        String oldName = scanner.nextLine();

        // Meminta pengguna memasukkan nama baru.
        System.out.print("Enter NEW employee name: ");
        // Membaca input pengguna untuk nama baru.
        String newName = scanner.nextLine();

        // Membuat ArrayList untuk menampung semua data dari file.
        List<String> employeeList = new ArrayList<>();
        // Membuat flag boolean untuk menandai apakah data ditemukan.
        boolean found = false;

        // Memulai blok try-with-resources untuk membaca file.
        try (Scanner reader = new Scanner(new File(FILENAME))) {
            // Membaca satu baris penuh dari file.
            String dataLine = reader.nextLine();
            // Memeriksa apakah baris data tidak null dan tidak kosong.
            if (dataLine != null && !dataLine.isEmpty()) {
                // Menambahkan semua nama dari file ke dalam 'employeeList'.
                employeeList.addAll(Arrays.asList(dataLine.split("\\" + DELIMITER)));
            }
        } catch (IOException e) { // Menangkap error saat membaca file.
            // Mencetak pesan error.
            System.err.println("An error occurred while reading file for update: " + e.getMessage());
            // Keluar dari metode jika terjadi error.
            return;
        }

        // Melakukan perulangan pada setiap nama di dalam 'employeeList'.
        for (int i = 0; i < employeeList.size(); i++) {
            // Membandingkan nama saat ini dengan input 'oldName' (mengabaikan huruf
            // besar/kecil).
            if (employeeList.get(i).trim().equalsIgnoreCase(oldName.trim())) {
                // Jika cocok, ganti nama di posisi ini dengan 'newName'.
                employeeList.set(i, newName.trim());
                // Set flag 'found' menjadi true karena data telah ditemukan.
                found = true;
                // Keluar dari perulangan karena data sudah ditemukan dan diubah.
                break;
            }
        }

        // Memeriksa apakah data ditemukan.
        if (found) {
            // Jika ya, gabungkan kembali list yang sudah diupdate menjadi satu string.
            String updatedData = String.join(DELIMITER, employeeList);
            // Memulai blok try-with-resources untuk menulis ulang file.
            try (FileWriter writer = new FileWriter(FILENAME)) {
                // Menulis data yang sudah diupdate ke file, menimpa konten lama.
                writer.write(updatedData);
                // Memberi tahu pengguna bahwa pembaruan berhasil.
                System.out.println("Data for '" + oldName + "' has been SUCSESFULLY updated to '" + newName + "'.");
            } catch (IOException e) { // Menangkap error saat menulis perubahan.
                // Mencetak pesan error.
                System.err.println("An error occurred while writing changes to the file: " + e.getMessage());
            }
        } else { // Jika perulangan selesai dan data tidak ditemukan.
            // Beri tahu pengguna bahwa data yang dicari tidak ada.
            System.out.println("Data for '" + oldName + "' not found in the file.");
        }
    }
}
