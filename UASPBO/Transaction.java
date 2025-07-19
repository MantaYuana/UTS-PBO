/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author gunam
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idTransaksi;
    private String idKoleksi;
    private String username;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private String status;

    public Transaction(String idTransaksi, String idKoleksi, String username) {
        this.idTransaksi = idTransaksi;
        this.idKoleksi = idKoleksi;
        this.username = username;
        this.tanggalPinjam = LocalDate.now();
        this.status = "Dipinjam";
    }

    public void kembalikan() {
        this.tanggalKembali = LocalDate.now();
        this.status = "Dikembalikan";
    }
    
    @Override
    public String toString() {
        return "ID Transaksi: " + idTransaksi + ", ID Koleksi: " + idKoleksi + 
               ", Peminjam: " + username + ", Tgl Pinjam: " + tanggalPinjam + 
               ", Tgl Kembali: " + (tanggalKembali != null ? tanggalKembali : "-") + 
               ", Status: " + status;
    }

    public String getIdKoleksi() {
        return idKoleksi;
    }

    public String getStatus() {
        return status;
    }
}
