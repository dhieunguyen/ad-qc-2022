package com.example.pttk_dbclpm.dao.room;

import com.example.pttk_dbclpm.model.PhongChieu;
import com.example.pttk_dbclpm.model.RapChieuPhim;

import java.util.List;

public interface PhongChieuDAO {
    List<PhongChieu> getPhongChieu(RapChieuPhim rapChieuPhim);
}
