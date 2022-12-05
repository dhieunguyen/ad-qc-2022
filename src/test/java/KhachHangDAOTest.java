import com.example.pttk_dbclpm.dao.customer.KhachHangDAO;
import com.example.pttk_dbclpm.dao.customer.KhachHangDAOImpl;
import com.example.pttk_dbclpm.model.KhachHang;
import com.example.pttk_dbclpm.model.TheThanhVien;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class KhachHangDAOTest {
    private KhachHangDAO khachHangDAO = new KhachHangDAOImpl();

    public KhachHangDAOTest() throws SQLException {
    }

    @Test
    public void getKhachHang1() {
        TheThanhVien theThanhVien = new TheThanhVien("123");
        KhachHang khachHang = khachHangDAO.getKhachHang(theThanhVien);
        Assert.assertNotNull(khachHang);
    }
    @Test
    public void getKhachHang2() {
        TheThanhVien theThanhVien = new TheThanhVien("ZTPOFTTOARZEFXNEKSBMZTPOFTTOARZEFXNEKSBMAKX123");
        KhachHang khachHang = khachHangDAO.getKhachHang(theThanhVien);
        Assert.assertNull(khachHang);
    }
}
