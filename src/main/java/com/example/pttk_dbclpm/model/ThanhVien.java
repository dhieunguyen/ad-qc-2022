package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class ThanhVien implements Serializable {
    private Integer ma;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String soDienThoai;
    private RapChieuPhim rapChieuPhim;

    public ThanhVien() {
    }
    public ThanhVien(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    public ThanhVien(Integer ma, String tenDangNhap, String matKhau, String hoTen, Date ngaySinh, String email, String soDienThoai, RapChieuPhim rapChieuPhim) {
        this.ma = ma;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.rapChieuPhim = rapChieuPhim;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public RapChieuPhim getRapChieuPhim() {
        return rapChieuPhim;
    }

    public void setRapChieuPhim(RapChieuPhim rapChieuPhim) {
        this.rapChieuPhim = rapChieuPhim;
    }
}
