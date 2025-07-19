/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Majalah extends Koleksi {

    private String edisi;
    private int bulanTerbit;

    Majalah(String idKoleksi, String judul, int tahunTerbit, String edisi, int bulanTerbit) {
        super(idKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
    }

    public String getEdisi() {
        return this.edisi;
    }

    public int getBulanTerbit() {
        return this.bulanTerbit;
    }
}
