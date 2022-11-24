package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class HoaDonPhat implements Serializable {
    private Integer ma;
    private Integer diemBiTru;
    private KhungPhat khungPhat;
    private KhachHang khachHang;
    private NhanVien nhanVien;

    public HoaDonPhat() {
    }

    public HoaDonPhat(Integer ma, Integer diemBiTru, KhungPhat khungPhat, KhachHang khachHang, NhanVien nhanVien) {
        this.ma = ma;
        this.diemBiTru = diemBiTru;
        this.khungPhat = khungPhat;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getDiemBiTru() {
        return diemBiTru;
    }

    public void setDiemBiTru(Integer diemBiTru) {
        this.diemBiTru = diemBiTru;
    }

    public KhungPhat getKhungPhat() {
        return khungPhat;
    }

    public void setKhungPhat(KhungPhat khungPhat) {
        this.khungPhat = khungPhat;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
