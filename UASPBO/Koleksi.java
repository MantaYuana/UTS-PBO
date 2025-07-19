/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class Koleksi {

    private String idKoleksi;
    private String judul;
    private int tahunTerbit;

    Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getIdKoleksi(){
        return this.idKoleksi;
    }
    
    public String getJudul(){
        return this.judul;
    }
    
    public int getTahunTerbit(){
        return this.tahunTerbit;
    }
    
    public void setJudulKoleksi(String text){
        this.judul = text;
    }
}
