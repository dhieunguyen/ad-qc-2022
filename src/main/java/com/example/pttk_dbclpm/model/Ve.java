package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class Ve implements Serializable {
    private Integer ma;
    private String soGhe;
    private Integer uuDai;
    private Float gia;
    private Integer trangThaiVe;
    private LichChieuPhim lichChieuPhim;
    private HoaDonPhat hoaDonPhat;
    private HoaDon hoaDon;

    public Ve() {
    }

    public Ve(Integer ma, String soGhe, Integer uuDai, Float gia, Integer trangThaiVe, LichChieuPhim lichChieuPhim, HoaDonPhat hoaDonPhat) {
        this.ma = ma;
        this.soGhe = soGhe;
        this.uuDai = uuDai;
        this.gia = gia;
        this.trangThaiVe = trangThaiVe;
        this.lichChieuPhim = lichChieuPhim;
        this.hoaDonPhat = hoaDonPhat;
    }

    public Ve(Integer ma, String soGhe, Integer uuDai, Float gia, Integer trangThaiVe, LichChieuPhim lichChieuPhim, HoaDon hoaDon) {
        this.ma = ma;
        this.soGhe = soGhe;
        this.uuDai = uuDai;
        this.gia = gia;
        this.trangThaiVe = trangThaiVe;
        this.lichChieuPhim = lichChieuPhim;
        this.hoaDon = hoaDon;
    }
}
