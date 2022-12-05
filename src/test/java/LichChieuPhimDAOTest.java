import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAO;
import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAOImpl;
import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Phim;
import com.example.pttk_dbclpm.model.PhongChieu;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class LichChieuPhimDAOTest {
    private LichChieuPhimDAO lichChieuPhimDAO = new LichChieuPhimDAOImpl();

    public LichChieuPhimDAOTest() throws SQLException {
    }
    @Test
    public void getLichChieuPhim1(){
        Phim phim = new Phim(1);
        List<LichChieuPhim> list = lichChieuPhimDAO.getLichChieuPhim(phim);
        Assert.assertNotNull(list);
    }
    @Test
    public void getLichChieuPhim2(){
        PhongChieu phongChieu = new PhongChieu(1);
        List<LichChieuPhim> list = lichChieuPhimDAO.getLichChieuPhim(phongChieu);
        Assert.assertNotNull(list);
    }
    @Test
    public void getLichChieuPhim3(){
        PhongChieu phongChieu = new PhongChieu(8);
        List<LichChieuPhim> list = lichChieuPhimDAO.getLichChieuPhim(phongChieu);
        Assert.assertEquals(0,list.size());
    }
}
