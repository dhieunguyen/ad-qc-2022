package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class Ve implements Serializable {
    public static int DA_BAN = 1;
    public static int CHUA_BAN = 0;
    private Integer ma;
    private String soGhe;
    private Integer uuDai;
    private Float gia;
    private Integer trangThaiVe;
    private Integer diemThuong;
    private LichChieuPhim lichChieuPhim;
    private HoaDonPhat hoaDonPhat;
    private HoaDon hoaDon;

    public Ve() {
    }

    public Ve(Integer ma, String soGhe, Integer uuDai, Float gia, Integer trangThaiVe, Integer diemThuong, LichChieuPhim lichChieuPhim, HoaDonPhat hoaDonPhat) {
        this.ma = ma;
        this.soGhe = soGhe;
        this.uuDai = uuDai;
        this.gia = gia;
        this.trangThaiVe = trangThaiVe;
        this.diemThuong = diemThuong;
        this.lichChieuPhim = lichChieuPhim;
        this.hoaDonPhat = hoaDonPhat;
    }

    public Ve(Integer ma, String soGhe, Integer uuDai, Float gia, Integer trangThaiVe, Integer diemThuong, LichChieuPhim lichChieuPhim, HoaDon hoaDon) {
        this.ma = ma;
        this.soGhe = soGhe;
        this.uuDai = uuDai;
        this.gia = gia;
        this.trangThaiVe = trangThaiVe;
        this.diemThuong = diemThuong;
        this.lichChieuPhim = lichChieuPhim;
        this.hoaDon = hoaDon;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public Integer getUuDai() {
        return uuDai;
    }

    public void setUuDai(Integer uuDai) {
        this.uuDai = uuDai;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public Integer getTrangThaiVe() {
        return trangThaiVe;
    }

    public void setTrangThaiVe(Integer trangThaiVe) {
        this.trangThaiVe = trangThaiVe;
    }

    public LichChieuPhim getLichChieuPhim() {
        return lichChieuPhim;
    }

    public void setLichChieuPhim(LichChieuPhim lichChieuPhim) {
        this.lichChieuPhim = lichChieuPhim;
    }

    public HoaDonPhat getHoaDonPhat() {
        return hoaDonPhat;
    }

    public void setHoaDonPhat(HoaDonPhat hoaDonPhat) {
        this.hoaDonPhat = hoaDonPhat;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Integer getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(Integer diemThuong) {
        this.diemThuong = diemThuong;
    }
}
