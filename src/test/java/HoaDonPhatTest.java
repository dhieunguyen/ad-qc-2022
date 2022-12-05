import com.example.pttk_dbclpm.dao.customer.KhachHangDAO;
import com.example.pttk_dbclpm.dao.customer.KhachHangDAOImpl;
import com.example.pttk_dbclpm.dao.fine_bill.HoaDonPhatDAO;
import com.example.pttk_dbclpm.dao.fine_bill.HoaDonPhatDAOImpl;
import com.example.pttk_dbclpm.model.*;
import dao.HoaDonPhatDAOTest;
import dao.TheThanhVienDAOImpl;
import dao.VeDAOImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonPhatTest {
    private HoaDonPhatDAO hoaDonPhatDAO = new HoaDonPhatDAOImpl();
    private HoaDonPhatDAOTest hoaDonPhatDAOTest = new dao.HoaDonPhatDAOImpl();

    private VeDAOImpl veDAO = new dao.VeDAOImpl();
    private TheThanhVienDAOImpl theThanhVienDAO = new dao.TheThanhVienDAOImpl();

    public HoaDonPhatTest() throws SQLException {
    }

    @Test
    public void createHoaDonPhatTest1() throws SQLException {
        HoaDonPhat hoaDonPhat = new HoaDonPhat(30,
                0.0f,
                70000.0f,
                new KhungPhat(1),
                null,
                new NhanVien(1));
        List<Ve> list = new ArrayList<>();
        Ve ve = new Ve(93);
        ve.setHoaDonPhat(hoaDonPhat);
        list.add(ve);
        HoaDonPhat hoaDonPhatRes = hoaDonPhatDAO.createHoaDonPhat(hoaDonPhat, list);
        Assert.assertEquals(hoaDonPhat.getDiemBiTru(), hoaDonPhatRes.getDiemBiTru());
        Assert.assertEquals(hoaDonPhat.getTienPhat(), hoaDonPhatRes.getTienPhat());
        Assert.assertEquals(hoaDonPhat.getTienHoanLai(), hoaDonPhatRes.getTienHoanLai());
        Assert.assertEquals(hoaDonPhat.getKhungPhat().getMa(), hoaDonPhatRes.getKhungPhat().getMa());
        Assert.assertNull(hoaDonPhatRes.getKhachHang());
        Assert.assertEquals(hoaDonPhat.getNhanVien().getMa(), hoaDonPhatRes.getNhanVien().getMa());
        Assert.assertEquals(true, veDAO.updateTrangThaiVe(list));
        Assert.assertEquals(true, hoaDonPhatDAOTest.deleteHoaDonPhat(hoaDonPhatRes.getMa()));
    }

    @Test
    public void createHoaDonPhatTest2() throws SQLException {
        TheThanhVien ttv = new TheThanhVien("123");
        KhachHang khachHang = new KhachHang(1);
        khachHang.setTheThanhVien(ttv);
        HoaDonPhat hoaDonPhat = new HoaDonPhat(10,
                0.0f,
                70000.0f,
                new KhungPhat(1),
                khachHang,
                new NhanVien(1));
        List<Ve> list = new ArrayList<>();
        Ve ve = new Ve(93);
        ve.setHoaDonPhat(hoaDonPhat);
        list.add(ve);
        HoaDonPhat hoaDonPhatRes = hoaDonPhatDAO.createHoaDonPhat(hoaDonPhat, list);
        Assert.assertEquals(hoaDonPhat.getDiemBiTru(), hoaDonPhatRes.getDiemBiTru());
        Assert.assertEquals(hoaDonPhat.getTienPhat(), hoaDonPhatRes.getTienPhat());
        Assert.assertEquals(hoaDonPhat.getTienHoanLai(), hoaDonPhatRes.getTienHoanLai());
        Assert.assertEquals(hoaDonPhat.getKhungPhat().getMa(), hoaDonPhatRes.getKhungPhat().getMa());
        Assert.assertEquals(hoaDonPhat.getKhachHang().getMa(), hoaDonPhatRes.getKhachHang().getMa());
        Assert.assertEquals(hoaDonPhat.getNhanVien().getMa(), hoaDonPhatRes.getNhanVien().getMa());
        Assert.assertEquals(true, veDAO.updateTrangThaiVe(list));
        Assert.assertEquals(true, theThanhVienDAO.updateDiemTichLuy(hoaDonPhat));
        Assert.assertEquals(true, hoaDonPhatDAOTest.deleteHoaDonPhat(hoaDonPhatRes.getMa()));
    }
}
