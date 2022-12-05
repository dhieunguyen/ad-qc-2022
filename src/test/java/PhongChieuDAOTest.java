import com.example.pttk_dbclpm.dao.room.PhongChieuDAOImpl;
import com.example.pttk_dbclpm.model.PhongChieu;
import com.example.pttk_dbclpm.model.RapChieuPhim;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PhongChieuDAOTest {
    private PhongChieuDAOImpl phongChieuDAO = new PhongChieuDAOImpl();

    public PhongChieuDAOTest() throws SQLException {
    }

    @Test
    public void getPhongChieu(){
        RapChieuPhim rapChieuPhim = new RapChieuPhim(1);
        List<PhongChieu> list = phongChieuDAO.getPhongChieu(rapChieuPhim);
        Assert.assertNotNull(list);
    }
}
