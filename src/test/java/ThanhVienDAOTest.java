import com.example.pttk_dbclpm.dao.user.ThanhVienDAOImpl;
import com.example.pttk_dbclpm.model.ThanhVien;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ThanhVienDAOTest {
    private ThanhVienDAOImpl thanhVienDAO = new ThanhVienDAOImpl();

    public ThanhVienDAOTest() throws SQLException {
    }
    @Test
    public void loginTest1() {
        String username = "hieund";
        String password = "123456";
        ThanhVien thanhVien = new ThanhVien(username, password);
        ThanhVien res = thanhVienDAO.checkLogin(thanhVien);
        assertEquals(username,res.getTenDangNhap());
    }
    @Test
    public void loginTest2(){
        String username = "hieund";
        String password = "1234567";
        ThanhVien thanhVien = new ThanhVien(username, password);
        ThanhVien res = thanhVienDAO.checkLogin(thanhVien);
        assertNull(null,res);
    }
}
