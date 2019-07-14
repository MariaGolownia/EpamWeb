package by.javatr.dao;
import by.javatr.entity.User;
import by.javatr.entity.VirtualCard;
import java.math.BigDecimal;
import java.util.List;

public interface VirtualCardDao extends Dao<VirtualCard> {

    List<VirtualCard> readByUser (User search) throws PersistentException;

}
