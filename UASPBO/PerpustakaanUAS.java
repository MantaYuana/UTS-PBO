/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

import java.io.*;
import java.util.*;

/**
 *
 * @author gunam
 */
public class PerpustakaanUAS implements ManageKoleksi {

    private final List<Koleksi> koleksiList = new ArrayList<>();
    private final Map<String, User> userList = new HashMap<>();
    private final TransactionLog transactionLogger;

    public PerpustakaanUAS() {
        userList.put("admin", new Admin("admin", "admin123"));
        userList.put("member", new Anggota("member", "member123"));

        transactionLogger = new TransactionLog("transaksi.txt");
        transactionLogger.loadTransaction();
    }

    @Override
    public void addKoleksi(Koleksi koleksi) {
        try {
            koleksiList.add(koleksi);
            System.out.println("Koleksi '" + koleksi.getJudul() + "' berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Error saat menambahkan koleksi: " + e.getMessage());
        }
    }

    @Override
    public void deleteKoleksi(String idKoleksi) {
        Koleksi koleksi = findKoleksi(idKoleksi);
        if (koleksi != null) {
            koleksiList.remove(koleksi);
            System.out.println("Koleksi dengan ID " + idKoleksi + " berhasil dihapus.");
        } else {
            System.out.println("Koleksi dengan ID " + idKoleksi + " tidak ditemukan.");
        }
    }

    @Override
    public Koleksi findKoleksi(String idKoleksi) {
        for (Koleksi koleksiObject : koleksiList) {
            if (koleksiObject.getIdKoleksi().equalsIgnoreCase(idKoleksi)) {
                return koleksiObject;
            }
        }
        return null;
    }

    @Override
    public void showAllKoleksi() {
        if (koleksiList.isEmpty()) {
            System.out.println("Koleksi perpustakaan kosong!");
            return;
        }
        System.out.println("\n--- Daftar Koleksi Perpustakaan ---");
        for (Koleksi koleksiObject : koleksiList) {
            System.out.println("ID Koleksi   : " + koleksiObject.getIdKoleksi());
            System.out.println("Judul        : " + koleksiObject.getJudul());
            System.out.println("Tahun Terbit : " + koleksiObject.getTahunTerbit());
            if (koleksiObject instanceof Buku) {
                System.out.println("Penulis      : " + ((Buku) koleksiObject).getPenulis());
            } else if (koleksiObject instanceof Majalah) {
                System.out.println("Edisi        : " + ((Majalah) koleksiObject).getEdisi());
            } else if (koleksiObject instanceof Komik) {
                System.out.println("Ilustrator   : " + ((Komik) koleksiObject).getIlustrator());
            }
            System.out.println("-----------------------------------");
        }
    }

    private class TransactionLog {

        private final String fileName;
        private final List<Transaction> riwayatTransaction = new ArrayList<>();

        public TransactionLog(String fileName) {
            this.fileName = fileName;
        }

        @SuppressWarnings("unchecked")
        public void loadTransaction() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                riwayatTransaction.addAll((List<Transaction>) ois.readObject());
                System.out.println("Riwayat transaksi berhasil dimuat dari file.");
            } catch (FileNotFoundException e) {
                System.out.println("File riwayat tidak ditemukan, memulai dengan riwayat baru.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Gagal memuat riwayat transaksi: " + e.getMessage());
            }
        }

        public void saveTransaction() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(riwayatTransaction);
            } catch (IOException e) {
                System.out.println("Gagal menyimpan riwayat transaksi: " + e.getMessage());
            }
        }

        public void add(Transaction transaksi) {
            riwayatTransaction.add(transaksi);
        }

        public void showTransaction() {
            if (riwayatTransaction.isEmpty()) {
                System.out.println("Belum ada riwayat transaksi.");
                return;
            }
            System.out.println("\n--- Riwayat Transaction ---");
            for (Transaction t : riwayatTransaction) {
                System.out.println(t);
            }
        }

        public Transaction findActiveTransaction(String idKoleksi) {
            for (int i = riwayatTransaction.size() - 1; i >= 0; i--) {
                Transaction t = riwayatTransaction.get(i);
                if (t.getIdKoleksi().equalsIgnoreCase(idKoleksi) && t.getStatus().equals("Dipinjam")) {
                    return t;
                }
            }
            return null;
        }
    }

    private void addBuku(Scanner scanner) {
        System.out.println("\n--- Tambah Buku Baru ---");

        System.out.print("Masukkan ID Koleksi: ");
        String idKoleksi = scanner.nextLine();
        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan Jumlah Halaman: ");
        int jumlahHalaman = scanner.nextInt();
        scanner.nextLine();

        addKoleksi(new Buku(idKoleksi, judul, tahunTerbit, penulis, jumlahHalaman));
    }

    private void addMajalah(Scanner scanner) {
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

        addKoleksi(new Majalah(idKoleksi, judul, tahunTerbit, edisi, bulanTerbit));
    }

    private void addKomik(Scanner scanner) {
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

        addKoleksi(new Komik(idKoleksi, judul, tahunTerbit, ilustrator, volume));
    }

    public void borrowKoleksi(Scanner scanner, String username) {
        System.out.print("Masukkan ID Koleksi yang ingin dipinjam: ");
        String idKoleksi = scanner.nextLine();

        Koleksi koleksi = findKoleksi(idKoleksi);
        if (koleksi == null) {
            System.out.println("Koleksi ditemukan.");
            return;
        }

        if (transactionLogger.findActiveTransaction(idKoleksi) != null) {
            System.out.println("Maaf, koleksi ini sedang dipinjam.");
            return;
        }

        String idTransaction = "TRX" + System.currentTimeMillis();
        Transaction trx = new Transaction(idTransaction, idKoleksi, username);
        transactionLogger.add(trx);
        System.out.println("Koleksi '" + koleksi.getJudul() + "' berhasil dipinjam.");
    }

    public void returnKoleksi(Scanner scanner) {
        System.out.print("Masukkan ID Koleksi yang ingin dikembalikan: ");
        String idKoleksi = scanner.nextLine();

        Transaction trx = transactionLogger.findActiveTransaction(idKoleksi);
        if (trx == null) {
            System.out.println("Tidak ada catatan peminjaman aktif untuk koleksi ini.");
            return;
        }

        trx.kembalikan();
        System.out.println("Koleksi berhasil dikembalikan.");
    }

    public void runProgram() {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.println("\n--- LOGIN SISTEM PERPUSTAKAAN ---");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                currentUser = userList.get(username);
                if (currentUser != null && currentUser.checkPassword(password)) {
                    System.out.println("Login berhasil! Selamat datang, " + currentUser.getRole() + " "
                            + currentUser.getUsername());
                } else {
                    System.out.println("Username atau password salah!");
                    currentUser = null;
                }
            } else {
                currentUser.displayMenu();
                int pilihan = 0;
                try {
                    pilihan = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka!");
                    continue;
                }

                if (currentUser instanceof Admin) {
                    handleMenuAdmin(pilihan, scanner);
                    if (pilihan == 7) {
                        currentUser = null;
                    }
                } else if (currentUser instanceof Anggota) {
                    handleMenuAnggota(pilihan, scanner, currentUser.getUsername());
                    if (pilihan == 4) {
                        currentUser = null;
                    }
                }
            }
        }
    }

    private void handleMenuAdmin(int pilihan, Scanner scanner) {
        switch (pilihan) {
            case 1:
                showAllKoleksi();
                break;
            case 2:
                addBuku(scanner);
                break;
            case 3:
                addMajalah(scanner);
                break;
            case 4:
                addKomik(scanner);
                break;
            case 5:
                System.out.print("Masukkan ID Koleksi yang akan dihapus: ");
                deleteKoleksi(scanner.nextLine());
                break;
            case 6:
                transactionLogger.showTransaction();
                break;
            case 7:
                transactionLogger.saveTransaction();
                System.out.println("Logout berhasil...");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void handleMenuAnggota(int pilihan, Scanner scanner, String username) {
        switch (pilihan) {
            case 1:
                showAllKoleksi();
                break;
            case 2:
                borrowKoleksi(scanner, username);
                break;
            case 3:
                returnKoleksi(scanner);
                break;
            case 4:
                transactionLogger.saveTransaction();
                System.out.println("Logout berhasil...");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void main(String[] args) {
        PerpustakaanUAS app = new PerpustakaanUAS();
        app.runProgram();
    }
}
