package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class RapChieuPhim implements Serializable {
    private Integer ma;
    private String ten;
    private String diaChi;
    private String gioiThieu;

    public RapChieuPhim() {
    }
    public RapChieuPhim(Integer ma) {
        this.ma = ma;
    }

    public RapChieuPhim(Integer ma, String ten, String diaChi, String gioiThieu) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.gioiThieu = gioiThieu;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
}
