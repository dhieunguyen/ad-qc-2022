package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class DoAnSuDung implements Serializable {
    private HoaDon hoaDon;
    private DoAn doAn;

    public DoAnSuDung() {
    }

    public DoAnSuDung(HoaDon hoaDon, DoAn doAn) {
        this.hoaDon = hoaDon;
        this.doAn = doAn;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DoAn getDoAn() {
        return doAn;
    }

    public void setDoAn(DoAn doAn) {
        this.doAn = doAn;
    }
}
