package com.example.alp.model;

public class UploadedStandar {
    private String namaGallery;
    private String alamatGallery;
    private String kotaGallery;
    private String idGallery;

    public UploadedStandar(String namaGallery, String alamatGallery, String kotaGallery, String idGallery) {
        this.namaGallery = namaGallery;
        this.alamatGallery = alamatGallery;
        this.kotaGallery = kotaGallery;
        this.idGallery = idGallery;
    }

    public String getNamaGallery() {
        return namaGallery;
    }

    public void setNamaGallery(String namaGallery) {
        this.namaGallery = namaGallery;
    }

    public String getAlamatGallery() {
        return alamatGallery;
    }

    public void setAlamatGallery(String alamatGallery) {
        this.alamatGallery = alamatGallery;
    }

    public String getKotaGallery() {
        return kotaGallery;
    }

    public void setKotaGallery(String kotaGallery) {
        this.kotaGallery = kotaGallery;
    }

    public String getIdGallery() {
        return idGallery;
    }

    public void setIdGallery(String idGallery) {
        this.idGallery = idGallery;
    }
}
