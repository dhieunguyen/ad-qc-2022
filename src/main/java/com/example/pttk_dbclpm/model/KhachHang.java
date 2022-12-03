package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class KhachHang implements Serializable {
    private Integer ma;
    private String hoTen;
    private String diaChi;
    private Date ngaySinh;
    private TheThanhVien theThanhVien;

    public KhachHang() {
    }

    public KhachHang(Integer ma) {
        this.ma = ma;
    }

    public KhachHang(Integer ma, String hoTen, String diaChi, Date ngaySinh, TheThanhVien theThanhVien) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.theThanhVien = theThanhVien;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public TheThanhVien getTheThanhVien() {
        return theThanhVien;
    }

    public void setTheThanhVien(TheThanhVien theThanhVien) {
        this.theThanhVien = theThanhVien;
    }
}
