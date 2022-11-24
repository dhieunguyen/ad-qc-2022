package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class KhungPhat implements Serializable {
    private Integer ma;
    private String khungGio;
    private Float phi;

    public KhungPhat() {
    }

    public KhungPhat(Integer ma, String khungGio, Float phi) {
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

    public String getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(String khungGio) {
        this.khungGio = khungGio;
    }

    public Float getPhi() {
        return phi;
    }

    public void setPhi(Float phi) {
        this.phi = phi;
    }
}
