package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class NhanVien extends ThanhVien implements Serializable {
    private String maNhanVien;

    public NhanVien( Integer maThanhVien) {
        super(maThanhVien);
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
