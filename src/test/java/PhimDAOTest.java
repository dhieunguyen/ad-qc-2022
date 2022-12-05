import com.example.pttk_dbclpm.dao.film.PhimDAOImpl;
import com.example.pttk_dbclpm.dao.user.ThanhVienDAOImpl;
import com.example.pttk_dbclpm.model.Phim;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PhimDAOTest {
    private PhimDAOImpl phimDAO = new PhimDAOImpl();

    public PhimDAOTest() throws SQLException {
    }

    @Test
    public void getPhimTest(){
        List<Phim> list = phimDAO.getPhim();
        Assert.assertNotEquals(0,list.size());
    }
}
