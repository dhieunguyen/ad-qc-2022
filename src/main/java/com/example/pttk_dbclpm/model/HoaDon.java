package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class HoaDon implements Serializable {
    private Integer ma;
    private Integer uuDai;
    private Integer soVe;
    private Float tongTien;
    private Date ngayTao;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private HinhThucThanhToan hinhThucThanhToan;

    public HoaDon() {
    }



    public HoaDon(Integer ma, Float tongTien, Integer soVe, Date ngayTao) {
        this.ma = ma;
        this.tongTien = tongTien;
        this.soVe = soVe;
        this.ngayTao = ngayTao;
    }

    public HoaDon(Integer ma, Integer uuDai, Date ngayTao, KhachHang khachHang, NhanVien nhanVien, HinhThucThanhToan hinhThucThanhToan) {
        this.ma = ma;
        this.uuDai = uuDai;
        this.ngayTao = ngayTao;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getUuDai() {
        return uuDai;
    }

    public void setUuDai(Integer uuDai) {
        this.uuDai = uuDai;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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

    public HinhThucThanhToan getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Integer getSoVe() {
        return soVe;
    }

    public void setSoVe(Integer soVe) {
        this.soVe = soVe;
    }
}
