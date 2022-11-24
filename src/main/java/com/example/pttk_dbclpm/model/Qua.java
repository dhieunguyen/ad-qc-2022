package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class Qua implements Serializable {
    private Integer ma;
    private Integer diemQuyDoi;
    private DoAn doAn;
    private Ve ve;
    private HoaDon hoaDon;

    public Qua() {
    }

    public Qua(Integer ma, Integer diemQuyDoi, DoAn doAn, HoaDon hoaDon) {
        this.ma = ma;
        this.diemQuyDoi = diemQuyDoi;
        this.doAn = doAn;
        this.hoaDon = hoaDon;
    }

    public Qua(Integer ma, Integer diemQuyDoi, Ve ve, HoaDon hoaDon) {
        this.ma = ma;
        this.diemQuyDoi = diemQuyDoi;
        this.ve = ve;
        this.hoaDon = hoaDon;
    }
}
