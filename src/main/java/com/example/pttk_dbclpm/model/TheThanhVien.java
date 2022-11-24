package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class TheThanhVien implements Serializable {
    private Integer ma;
    private String maVach;
    private Integer diemTichLuy;
    private Date ngayTao;

    public TheThanhVien() {
    }

    public TheThanhVien(Integer ma, String maVach, Integer diemTichLuy, Date ngayTao) {
        this.ma = ma;
        this.maVach = maVach;
        this.diemTichLuy = diemTichLuy;
        this.ngayTao = ngayTao;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
}
