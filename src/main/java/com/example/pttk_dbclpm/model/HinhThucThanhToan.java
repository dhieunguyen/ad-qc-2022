package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class HinhThucThanhToan implements Serializable {
    private Integer ma;
    private Date ngayThanhToan;
    private String loai;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(Integer ma, Date ngayThanhToan, String loai) {
        this.ma = ma;
        this.ngayThanhToan = ngayThanhToan;
        this.loai = loai;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
