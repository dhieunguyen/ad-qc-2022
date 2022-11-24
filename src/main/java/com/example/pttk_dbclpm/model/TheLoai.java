package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class TheLoai implements Serializable {
    private Integer ma;
    private String theLoai;

    public TheLoai() {
    }

    public TheLoai(Integer ma, String theLoai) {
        this.ma = ma;
        this.theLoai = theLoai;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
