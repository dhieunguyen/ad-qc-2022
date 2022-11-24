package com.example.pttk_dbclpm.model;

import java.io.Serializable;
import java.util.Date;

public class HoaDon implements Serializable {
    private Integer ma;
    private Integer uuDai;
    private Date ngayTao;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private HinhThucThanhToan hinhThucThanhToan;

    public HoaDon() {
    }

    public HoaDon(Integer ma, Integer uuDai, Date ngayTao, KhachHang khachHang, NhanVien nhanVien, HinhThucThanhToan hinhThucThanhToan) {
        this.ma = ma;
        this.uuDai = uuDai;
        this.ngayTao = ngayTao;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

}
