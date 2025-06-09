/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.college.perpustakaanuas;

import java.util.Scanner;

/**
 *
 * @author gunam
 */
public class PerpustakaanUAS {

    public static void printMenu(User user) {
        System.out.println("==================MENU PERPUSTAKAAN==============");
        System.out.println("Welcome, " + user.getUsername());
        System.out.println("1. Tampilkan Koleksi");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Tambah Majalah");
        System.out.println("4. Tambah Komik");
        System.out.print(">> ");
    }

    public static void tampilBuku(Koleksi[] koleksiArray) {
        if (koleksiArray[0] == null) {
            System.out.println("Koleksi Perpustakaan Kosong !");
            return;
        }

        for (int i = 0; i < koleksiArray.length; i++) {
            if (koleksiArray[i] != null) {
                System.out.println("ID Koleksi   : " + koleksiArray[i].getIdKoleksi());
                System.out.println("Judul        : " + koleksiArray[i].getJudul());
                System.out.println("Tahun Terbit : " + koleksiArray[i].getTahunTerbit());

                if (koleksiArray[i] instanceof Buku) {
                    Buku buku = (Buku) koleksiArray[i];
                    System.out.println("Penulis      : " + buku.getPenulis());
                    System.out.println("Jml Halaman  : " + buku.getJumlahHalaman());
                }

                if (koleksiArray[i] instanceof Majalah) {
                    Majalah majalah = (Majalah) koleksiArray[i];
                    System.out.println("Edisi         : " + majalah.getEdisi());
                    System.out.println("Bulan Terbit  : " + majalah.getBulanTerbit());
                }

                if (koleksiArray[i] instanceof Komik) {
                    Komik komik = (Komik) koleksiArray[i];
                    System.out.println("Ilustrator    : " + komik.getIlustrator());
                    System.out.println("Volume        : " + komik.getVolume());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    public static void tambahBuku(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) {
            System.out.println("Maaf, tidak dapaat menambah koleksi baru karena perpustakaan sudah penuh !");
            return;
        }

        System.out.println("\n--- Tambah Buku Baru ---");

        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan Jumlah Halaman: ");
        int jumlahHalaman = scanner.nextInt();
        scanner.nextLine();

        Buku bukuBaru = new Buku(idKoleksi, judul, tahunTerbit, penulis, jumlahHalaman);
        daftarKoleksi[indexTambah] = bukuBaru;
        System.out.println("Buku '" + judul + "' berhasil ditambahkan!");
    }

    public static void tambahMajalah(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) {
            System.out.println("Maaf, tidak dapaat menambah koleksi baru karena perpustakaan sudah penuh !");
            return;
        }

        System.out.println("\n--- Tambah Majalah Baru ---");

        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Majalah: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Edisi Majalah: ");
        String edisi = scanner.nextLine();
        System.out.print("Masukkan Bulan Terbit: ");
        int bulanTerbit = scanner.nextInt();
        scanner.nextLine();

        Majalah majalahBaru = new Majalah(idKoleksi, judul, tahunTerbit, edisi, bulanTerbit);
        daftarKoleksi[indexTambah] = majalahBaru;
        System.out.println("Majalah '" + judul + "' berhasil ditambahkan!");
    }

    public static void tambahKomik(Koleksi[] daftarKoleksi, Scanner scanner, int indexTambah, int kapasitasPerpus) {
        if (indexTambah >= kapasitasPerpus) {
            System.out.println("Maaf, tidak dapaat menambah koleksi baru karena perpustakaan sudah penuh !");
            return;
        }
        
        System.out.println("\n--- Tambah Komik Baru ---");

        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul Komik: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Ilustrator Komik: ");
        String ilustrator = scanner.nextLine();
        System.out.print("Masukkan Volume Komik: ");
        int volume = scanner.nextInt();
        scanner.nextLine();

        Komik komikBaru = new Komik(idKoleksi, judul, tahunTerbit, ilustrator, volume);
        daftarKoleksi[indexTambah] = komikBaru;
        System.out.println("Komik '" + judul + "' berhasil ditambahkan!");
    }

    public static void main(String[] args) {
        String tempText;
        short pilihanMenu;
        final int jumlahBuku = 20;
        int posisi = 0;
        boolean repeat = true;
        Koleksi[] bukuPerpustakaan = new Koleksi[jumlahBuku];

        Scanner input = new Scanner(System.in);
        System.out.println("Hello, who are you ?");

        tempText = input.nextLine();
        User user1 = new User(tempText, true);

        while (repeat) {
            printMenu(user1);
            pilihanMenu = input.nextShort();
            input.nextLine();

            switch (pilihanMenu) {
                case 1:
                    tampilBuku(bukuPerpustakaan);
                    break;
                case 2:
                    tambahBuku(bukuPerpustakaan, input, posisi, jumlahBuku);
                    posisi++;
                    break;
                case 3:
                    tambahMajalah(bukuPerpustakaan, input, posisi, jumlahBuku);
                    posisi++;
                    break;
                case 4:
                    tambahKomik(bukuPerpustakaan, input, posisi, jumlahBuku);
                    posisi++;
                    break;
                default:
                    System.out.println("Opsi Tidak ada !");
                    break;
            }

            System.out.println("Repeat Operation ? (y/n)");
            System.out.print(">> ");
            tempText = input.nextLine();
            repeat = tempText.equalsIgnoreCase("y");
        }

        System.out.println("\n\nTerimakasih !");
    }
}
