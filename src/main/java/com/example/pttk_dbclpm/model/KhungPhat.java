package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class KhungPhat implements Serializable {
    private Integer ma;
    private Integer khungGio;
    private Float phi;

    public KhungPhat() {
    }

    public KhungPhat(Integer ma, Integer khungGio, Float phi) {
        this.ma = ma;
        this.khungGio = khungGio;
        this.phi = phi;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(Integer khungGio) {
        this.khungGio = khungGio;
    }

    public Float getPhi() {
        return phi;
    }

    public void setPhi(Float phi) {
        this.phi = phi;
    }
}
