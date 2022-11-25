package com.example.pttk_dbclpm.dao.user;

import com.example.pttk_dbclpm.model.ThanhVien;

import java.util.List;

public interface UserDAO {
     List<ThanhVien> getThanhVien();
     boolean checkLogin(ThanhVien thanhVien);
}
