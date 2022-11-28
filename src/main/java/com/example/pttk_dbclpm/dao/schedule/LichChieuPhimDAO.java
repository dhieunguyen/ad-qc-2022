package com.example.pttk_dbclpm.dao.schedule;

import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Phim;
import com.example.pttk_dbclpm.model.PhongChieu;

import java.util.List;

public interface LichChieuPhimDAO {
    List<LichChieuPhim> getLichChieuPhim(Phim phim);
    List<LichChieuPhim> getLichChieuPhim(PhongChieu phongChieu);
}
