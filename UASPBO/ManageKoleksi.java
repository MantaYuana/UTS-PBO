/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

import java.util.ArrayList;

/**
 *
 * @author gunam
 */
public interface ManageKoleksi {
    void addKoleksi(Koleksi koleksi);
    void deleteKoleksi(String idKoleksi);
    Koleksi findKoleksi(String idKoleksi);
    void showAllKoleksi();
}
