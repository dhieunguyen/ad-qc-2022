package com.example.pttk_dbclpm.dao.customer;

import com.example.pttk_dbclpm.model.KhachHang;
import com.example.pttk_dbclpm.model.TheThanhVien;

import java.util.List;

public interface KhachHangDAO {
    List<KhachHang> getKhachHang(TheThanhVien theThanhVien);
}
