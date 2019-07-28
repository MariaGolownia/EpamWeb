package by.javatr.dao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.entity.User;
import by.javatr.entity.VirtualCard;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface VirtualCardDao extends Dao<VirtualCard> {

    List<VirtualCard> readByUser (User search) throws SQLException;

    List<VirtualCard>  readByUserId(Integer id) throws SQLException;

    VirtualCard read(Integer id) throws SQLException;

    void update(VirtualCard virtualCard) throws SQLException;
}
