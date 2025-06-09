/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Komik extends Koleksi {

    private String ilustrator;
    private int volume;

    Komik(String idKoleksi, String judul, int tahunTerbit, String ilustrator, int volume) {
        super(idKoleksi, judul, tahunTerbit);
        this.ilustrator = ilustrator;
        this.volume = volume;
    }

    public String getIlustrator() {
        return this.ilustrator;
    }

    public int getVolume() {
        return this.volume;
    }
}
