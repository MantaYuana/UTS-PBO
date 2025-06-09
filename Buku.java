/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Buku extends Koleksi{

    private String penulis;
    private int jumlahHalaman;

    Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int jumlahHalaman) {
        super(idKoleksi, judul, tahunTerbit);
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
    }
    
    public String getPenulis(){
        return this.penulis;
    }
    
    public int getJumlahHalaman(){
        return this.jumlahHalaman;
    }
}
