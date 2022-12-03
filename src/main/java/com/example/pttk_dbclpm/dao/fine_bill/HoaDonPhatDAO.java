package com.example.pttk_dbclpm.dao.fine_bill;

import com.example.pttk_dbclpm.model.HoaDonPhat;
import com.example.pttk_dbclpm.model.Ve;

import java.util.List;

public interface HoaDonPhatDAO {

    List<HoaDonPhat> createHoaDonPhat(HoaDonPhat hoaDonPhat, List<Ve> veList);
}
