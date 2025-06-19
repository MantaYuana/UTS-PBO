package UTSPBO;
import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna.

public class PerpustakaanUAS { // Kelas utama yang berisi logika program.

    // Metode statis untuk mencetak menu utama ke konsol.
    public static void printMenu(User user) {
        System.out.println("==================MENU PERPUSTAKAAN=============="); // Menampilkan header menu.
        System.out.println("Welcome, " + user.getUsername()); // Menyapa pengguna dengan namanya.
        System.out.println("1. Tampilkan Koleksi"); // Opsi menu 1.
        System.out.println("2. Tambah Buku"); // Opsi menu 2.
        System.out.println("3. Tambah Majalah"); // Opsi menu 3.
        System.out.println("4. Tambah Komik"); // Opsi menu 4.
        System.out.print(">> "); // Prompt untuk input pengguna.
    }

    // Metode untuk menampilkan semua koleksi yang ada di dalam array.
    public static void tampilKoleksi(Koleksi[] koleksiArray) {
        if (koleksiArray[0] == null) { // Memeriksa apakah koleksi pertama kosong.
            System.out.println("Koleksi Perpustakaan Kosong !"); // Jika ya, tampilkan pesan ini.
            return; // Keluar dari metode karena tidak ada yang perlu ditampilkan.
        }

        // Loop melalui setiap elemen dalam array koleksi.
        for (int i = 0; i < koleksiArray.length; i++) {
            if (koleksiArray[i] != null) { // Hanya proses elemen yang tidak null (sudah diisi).
                // Menampilkan informasi umum dari kelas Koleksi.
                System.out.println("ID Koleksi   : " + koleksiArray[i].getIdKoleksi());
                System.out.println("Judul        : " + koleksiArray[i].getJudul());
                System.out.println("Tahun Terbit : " + koleksiArray[i].getTahunTerbit());

                // Memeriksa apakah objek adalah instance dari kelas Buku.
                if (koleksiArray[i] instanceof Buku) {
                    Buku buku = (Buku) koleksiArray[i]; // Melakukan type casting ke Buku.
                    // Menampilkan informasi spesifik Buku.
                    System.out.println("Penulis      : " + buku.getPenulis());
                    System.out.println("Jml Halaman  : " + buku.getJumlahHalaman());
                }

                // Memeriksa apakah objek adalah instance dari kelas Majalah.
                if (koleksiArray[i] instanceof Majalah) {
                    Majalah majalah = (Majalah) koleksiArray[i]; // Melakukan type casting ke Majalah.
                    // Menampilkan informasi spesifik Majalah.
                    System.out.println("Edisi         : " + majalah.getEdisi());
                    System.out.println("Bulan Terbit  : " + majalah.getBulanTerbit());
                }

                // Memeriksa apakah objek adalah instance dari kelas Komik.
                if (koleksiArray[i] instanceof Komik) {
                    Komik komik = (Komik) koleksiArray[i]; // Melakukan type casting ke Komik.
                    // Menampilkan informasi spesifik Komik.
                    System.out.println("Ilustrator    : " + komik.getIlustrator());
                    System.out.println("Volume        : " + komik.getVolume());
                }
                System.out.println("-----------------------------------"); // Garis pemisah antar koleksi.
            }
        }
    }

    // Metode untuk menambahkan objek Buku baru ke dalam array koleksi.
    public static void tambahBuku(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) { // Memeriksa apakah perpustakaan sudah penuh.
            System.out.println("Maaf, tidak dapat menambah koleksi baru karena perpustakaan sudah penuh !");
            return; // Keluar dari metode jika penuh.
        }

        System.out.println("\n--- Tambah Buku Baru ---"); // Header untuk form tambah buku.

        // Meminta dan membaca input detail buku dari pengguna.
        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer scanner setelah membaca integer.
        System.out.print("Masukkan Nama Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan Jumlah Halaman: ");
        int jumlahHalaman = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer scanner.

        // Membuat objek Buku baru dengan data yang sudah diinput.
        Buku bukuBaru = new Buku(idKoleksi, judul, tahunTerbit, penulis, jumlahHalaman);
        daftarKoleksi[indexTambah] = bukuBaru; // Menambahkan objek baru ke array pada indeks yang tersedia.
        System.out.println("Buku '" + judul + "' berhasil ditambahkan!"); // Pesan konfirmasi.
    }

    // Metode untuk menambahkan objek Majalah baru ke dalam array koleksi.
    public static void tambahMajalah(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) { // Memeriksa apakah perpustakaan sudah penuh.
            System.out.println("Maaf, tidak dapat menambah koleksi baru karena perpustakaan sudah penuh !");
            return; // Keluar dari metode jika penuh.
        }

        System.out.println("\n--- Tambah Majalah Baru ---"); // Header untuk form tambah majalah.

        // Meminta dan membaca input detail majalah dari pengguna.
        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Majalah: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer.
        System.out.print("Masukkan Edisi Majalah: ");
        String edisi = scanner.nextLine();
        System.out.print("Masukkan Bulan Terbit: ");
        int bulanTerbit = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer.

        // Membuat objek Majalah baru dan menambahkannya ke array.
        Majalah majalahBaru = new Majalah(idKoleksi, judul, tahunTerbit, edisi, bulanTerbit);
        daftarKoleksi[indexTambah] = majalahBaru;
        System.out.println("Majalah '" + judul + "' berhasil ditambahkan!"); // Pesan konfirmasi.
    }

    // Metode untuk menambahkan objek Komik baru ke dalam array koleksi.
    public static void tambahKomik(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) { // Memeriksa apakah perpustakaan sudah penuh.
            System.out.println("Maaf, tidak dapat menambah koleksi baru karena perpustakaan sudah penuh !");
            return; // Keluar dari metode jika penuh.
        }

        System.out.println("\n--- Tambah Komik Baru ---"); // Header untuk form tambah komik.

        // Meminta dan membaca input detail komik dari pengguna.
        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Komik: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer.
        System.out.print("Masukkan Ilustrator Komik: ");
        String ilustrator = scanner.nextLine();
        System.out.print("Masukkan Volume Komik: ");
        int volume = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer.

        // Membuat objek Komik baru dan menambahkannya ke array.
        Komik komikBaru = new Komik(idKoleksi, judul, tahunTerbit, ilustrator, volume);
        daftarKoleksi[indexTambah] = komikBaru;
        System.out.println("Komik '" + judul + "' berhasil ditambahkan!"); // Pesan konfirmasi.
    }

    public static void editJudulKoleksi(Koleksi[] daftarKoleksi, Scanner scanner, int maxPosisi) {
        // 'repeat' untuk mengontrol perulangan utama (apakah pengguna ingin mengulang operasi).
        // 'found' adalah penanda (flag) untuk mengecek apakah ID koleksi ditemukan.
        boolean repeat = true;
        boolean found;
        // Variabel sementara untuk menampung input teks dari pengguna.
        String tempText;

        // Cek jika elemen pertama dalam array adalah null.
        // Ini adalah cara sederhana untuk memeriksa apakah sudah ada koleksi yang
        // ditambahkan.
        if (daftarKoleksi[0] == null) {
            // Jika kosong, tampilkan pesan dan keluar dari fungsi.
            System.out.println("Koleksi Perpustakaan Kosong !");
            return;
        }

        // Mencetak judul menu untuk fitur ini.
        System.out.println("\n--- Edit Judul Koleksi ---");
        // Perulangan utama yang berjalan selama pengguna ingin mengulang operasi
        // (menjawab 'y').
        while (repeat) {
            // Reset penanda 'found' ke false setiap kali perulangan dimulai.
            // Ini penting agar pencarian di iterasi berikutnya bekerja dengan benar.
            found = false;
            // Meminta pengguna memasukkan ID koleksi yang ingin diedit.
            System.out.print("Cari ID koleksi yang akan di edit: ");
            // Membaca input ID dari pengguna.
            String idKoleksi = scanner.nextLine();

            // Melakukan perulangan untuk mencari koleksi dari awal array hingga posisi
            // terakhir yang terisi ('maxPosisi').
            for (int i = 0; i < maxPosisi; i++) {
                // Membandingkan ID yang diinput pengguna dengan ID koleksi di posisi saat ini.
                if (idKoleksi.equals(daftarKoleksi[i].getIdKoleksi())) {
                    // Jika ID cocok, tampilkan judul lama dari koleksi tersebut.
                    System.out.println("\nJudul Koleksi Lama: " + daftarKoleksi[i].getJudul());
                    // Meminta pengguna memasukkan judul baru.
                    System.out.print("Masukkan Judul Koleksi Baru: ");
                    // Membaca input judul baru dari pengguna.
                    tempText = scanner.nextLine();

                    // Mengubah judul koleksi menggunakan method setter 'setJudulKoleksi'.
                    daftarKoleksi[i].setJudulKoleksi(tempText);
                    // Memberi konfirmasi bahwa judul telah berhasil diubah.
                    System.out.println("\nJudul Koleksi telah diubah !");
                    // Mengubah penanda 'found' menjadi true karena ID telah ditemukan.
                    found = true;
                    // Keluar dari perulangan 'for' karena data sudah ditemukan dan tidak perlu
                    // mencari lagi.
                    break;
                }
            }

            // Setelah perulangan 'for' selesai, cek nilai dari penanda 'found'.
            if (!found) {
                // Jika 'found' masih false, berarti ID tidak ditemukan dalam perulangan.
                System.out.println("ID Koleksi tidak ditemukan !");
            }

            // Menanyakan kepada pengguna apakah ingin mengulangi operasi edit.
            System.out.println("Ulangi Operasi Edit Judul ? (y/n)");
            // Menampilkan prompt input.
            System.out.print(">> ");
            // Membaca jawaban pengguna.
            tempText = scanner.nextLine();
            // Mengatur nilai 'repeat' menjadi true jika pengguna mengetik 'y' atau 'Y', dan
            // false untuk input lainnya.
            repeat = tempText.equalsIgnoreCase("y");
        }
    }

    // Metode utama, titik masuk program.
    public static void main(String[] args) {
        String tempText; // Variabel sementara untuk menyimpan input teks.
        short pilihanMenu; // Variabel untuk menyimpan pilihan menu dari pengguna.
        final int jumlahBuku = 20; // Kapasitas maksimum perpustakaan, bersifat final (tidak bisa diubah).
        int posisi = 0; // Indeks untuk melacak posisi kosong berikutnya di array.
        boolean repeat = true; // Flag boolean untuk mengontrol loop utama.
        Koleksi[] bukuPerpustakaan = new Koleksi[jumlahBuku]; // Membuat array untuk menyimpan semua koleksi.

        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk input global di main.
        System.out.println("Hello, who are you ?"); // Meminta nama pengguna.

        tempText = input.nextLine(); // Membaca nama pengguna.
        User user1 = new User(tempText, true); // Membuat objek User baru.

        while (repeat) { // Loop utama program, berjalan selama 'repeat' bernilai true.
            printMenu(user1); // Memanggil metode untuk menampilkan menu.
            pilihanMenu = input.nextShort(); // Membaca pilihan menu (sebagai short).
            input.nextLine(); // Membersihkan buffer setelah membaca angka.

            switch (pilihanMenu) { // Struktur kontrol untuk memilih aksi berdasarkan pilihan menu.
                case 1: // Jika pilihan adalah 1
                    tampilKoleksi(bukuPerpustakaan); // Panggil metode untuk menampilkan koleksi.
                    break; // Keluar dari switch.
                case 2: // Jika pilihan adalah 2
                    tambahBuku(bukuPerpustakaan, input, posisi, jumlahBuku); // Panggil metode untuk menambah buku.
                    posisi++; // Naikkan indeks posisi untuk item berikutnya.
                    break; // Keluar dari switch.
                case 3: // Jika pilihan adalah 3
                    tambahMajalah(bukuPerpustakaan, input, posisi, jumlahBuku); // Panggil metode untuk menambah
                                                                                // majalah.
                    posisi++; // Naikkan indeks posisi.
                    break; // Keluar dari switch.
                case 4: // Jika pilihan adalah 4
                    tambahKomik(bukuPerpustakaan, input, posisi, jumlahBuku); // Panggil metode untuk menambah komik.
                    posisi++; // Naikkan indeks posisi.
                    break; // Keluar dari switch.
                default: // Jika pilihan tidak ada di case manapun.
                    System.out.println("Opsi Tidak ada !"); // Tampilkan pesan error.
                    break; // Keluar dari switch.
            }

            System.out.println("Repeat Operation ? (y/n)"); // Tanya pengguna apakah ingin mengulang.
            System.out.print(">> "); // Prompt input.
            tempText = input.nextLine(); // Baca jawaban pengguna.
            repeat = tempText.equalsIgnoreCase("y"); // Set 'repeat' menjadi true jika jawaban adalah 'y' (ignore case).
        }

        System.out.println("\n\nTerimakasih !"); // Pesan penutup saat program selesai.
    }
}
