package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class DoAn implements Serializable {
    private Integer ma;
    private String ten;

    public DoAn() {
    }

    public DoAn(Integer ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
