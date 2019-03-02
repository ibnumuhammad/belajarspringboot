/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajarspringboot.model;

/**
 *
 * @author Home
 */
public class Dummy {

    private String nik;
    private String nama;
    private String ttl;
    private String alamat;
    private String pekerjaan;
    private String kewarganegaraan;
    private String kecamatan;

    @Override
    public String toString() {
        return String.format("{nik: %s, nama: %s, ttl: %s, alamat: %s, pekerjaan: %s, Kewarganegaraan: %s, Kecamatan: %s}", this.getNik(), this.getNama(), this.getAlamat(), this.getTtl(), this.getPekerjaan(), this.getKewarganegaraan(), this.getKecamatan());

    }

    /**
     * @return the nik
     */
    public String getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(String nik) {
        this.nik = nik;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the ttl
     */
    public String getTtl() {
        return ttl;
    }

    /**
     * @param ttl the ttl to set
     */
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the pekerjaan
     */
    public String getPekerjaan() {
        return pekerjaan;
    }

    /**
     * @param pekerjaan the pekerjaan to set
     */
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    /**
     * @return the kewarganegaraan
     */
    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    /**
     * @param kewarganegaraan the kewarganegaraan to set
     */
    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    /**
     * @return the kecamatan
     */
    public String getKecamatan() {
        return kecamatan;
    }

    /**
     * @param kecamatan the kecamatan to set
     */
    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

}
