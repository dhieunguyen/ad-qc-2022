package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class LichChieuPhim implements Serializable {
    private Integer ma;
    private Date ngayChieu;
    private String gioChieu;
    private PhongChieu phongChieu;
    private Phim phim;

    public LichChieuPhim() {
    }

    public LichChieuPhim(Integer ma, Date ngayChieu, String gioChieu, PhongChieu phongChieu, Phim phim) {
        this.ma = ma;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
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

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
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
}
