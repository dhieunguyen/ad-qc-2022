package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class Phim implements Serializable {
    private Integer ma;
    private String tenPhim;
    private Integer namSanXuat;
    private String moTa;

    public Phim() {
    }
    public Phim(Integer ma) {
        this.ma = ma;
    }
    public Phim(Integer ma, String tenPhim, Integer namSanXuat, String moTa) {
        this.ma = ma;
        this.tenPhim = tenPhim;
        this.namSanXuat = namSanXuat;
        this.moTa = moTa;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public Integer getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Integer namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
