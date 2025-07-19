/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n================== MENU ADMIN =================");
        System.out.println("Selamat Datang, " + getUsername() + "!");
        System.out.println("1. Tampilkan Semua Koleksi");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Tambah Majalah");
        System.out.println("4. Tambah Komik");
        System.out.println("5. Hapus Koleksi");
        System.out.println("6. Lihat Riwayat Transaksi");
        System.out.println("7. Logout");
        System.out.print(">> ");
    }
}
