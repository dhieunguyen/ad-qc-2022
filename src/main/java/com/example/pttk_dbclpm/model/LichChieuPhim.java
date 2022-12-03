package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class LichChieuPhim implements Serializable {
    private Integer ma;
    private Date ngayChieu;
    private Time gioBatDau;
    private Time gioKetThuc;
    private PhongChieu phongChieu;
    private Phim phim;

    public LichChieuPhim() {
    }
    public LichChieuPhim(Integer ma) {
        this.ma = ma;
    }

    public LichChieuPhim(Integer ma, Date ngayChieu, PhongChieu phongChieu, Phim phim) {
        this.ma = ma;
        this.ngayChieu = ngayChieu;
        this.phongChieu = phongChieu;
        this.phim = phim;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
}
