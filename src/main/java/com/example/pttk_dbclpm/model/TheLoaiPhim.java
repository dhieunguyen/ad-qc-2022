package com.example.pttk_dbclpm.model;

import java.io.Serializable;

public class TheLoaiPhim implements Serializable {
    private Phim phim;
    private TheLoai theLoai;

    public TheLoaiPhim() {
    }

    public TheLoaiPhim(Phim phim, TheLoai theLoai) {
        this.phim = phim;
        this.theLoai = theLoai;
    }
}
