/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Anggota extends User {

    public Anggota(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Member";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n================== MENU MEMBER ================");
        System.out.println("Selamat Datang, " + getUsername() + "!");
        System.out.println("1. Tampilkan Semua Koleksi");
        System.out.println("2. Pinjam Koleksi");
        System.out.println("3. Kembalikan Koleksi");
        System.out.println("4. Logout");
        System.out.print(">> ");
    }
}
