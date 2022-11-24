package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class PhongChieu implements Serializable {
    private Integer ma;
    private Integer soLuongGhe;
    private String dacDiem;
    private RapChieuPhim rapChieuPhim;

    public PhongChieu() {
    }

    public PhongChieu(Integer ma, Integer soLuongGhe, String dacDiem, RapChieuPhim rapChieuPhim) {
        this.ma = ma;
        this.soLuongGhe = soLuongGhe;
        this.dacDiem = dacDiem;
        this.rapChieuPhim = rapChieuPhim;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(Integer soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

    public RapChieuPhim getRapChieuPhim() {
        return rapChieuPhim;
    }

    public void setRapChieuPhim(RapChieuPhim rapChieuPhim) {
        this.rapChieuPhim = rapChieuPhim;
    }
}
