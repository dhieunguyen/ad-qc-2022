package com.example.pttk_dbclpm.dao.ticket;

import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Ve;

import java.util.List;

public interface VeDAO {
    List<Ve> getVe(LichChieuPhim lichChieuPhim,List<Ve> veList);
    boolean updateTrangThaiVe(List<Ve> ve);
}
