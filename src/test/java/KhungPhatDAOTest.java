import com.example.pttk_dbclpm.dao.fine.KhungPhatDAOImpl;
import com.example.pttk_dbclpm.dao.user.ThanhVienDAOImpl;
import com.example.pttk_dbclpm.model.KhungPhat;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class KhungPhatDAOTest {
    private KhungPhatDAOImpl khungPhatDAO = new KhungPhatDAOImpl();

    public KhungPhatDAOTest() throws SQLException {
    }

    @Test
    public void getKhungPhatTest1() {
        int gio = 49;
        KhungPhat kp = khungPhatDAO.getKhungPhat(gio);
        Assert.assertEquals(0.0, Float.parseFloat(String.format("%.1f", kp.getPhi())), 0.0f);
    }

    @Test
    public void getKhungPhatTest2() {
        int gio = 25;
        KhungPhat kp = khungPhatDAO.getKhungPhat(gio);
        System.out.println(Float.parseFloat(String.format("%.1f", kp.getPhi())));
        Assert.assertEquals(0.2, Float.parseFloat(String.format("%.1f", kp.getPhi())), 0.1f);
    }

    @Test
    public void getKhungPhatTest3() {
        int gio = 13;
        KhungPhat kp = khungPhatDAO.getKhungPhat(gio);
        Assert.assertEquals(0.4,Float.parseFloat(String.format("%.1f", kp.getPhi())), 0.1f);
    }

    @Test
    public void getKhungPhatTest4() {
        int gio = 7;
        KhungPhat kp = khungPhatDAO.getKhungPhat(gio);
        Assert.assertEquals(0.6, Float.parseFloat(String.format("%.1f", kp.getPhi())), 0.1f);
    }

    @Test
    public void getKhungPhatTest5() {
        int gio = 5;
        KhungPhat kp = khungPhatDAO.getKhungPhat(gio);
        Assert.assertEquals(null, kp);
    }
}
