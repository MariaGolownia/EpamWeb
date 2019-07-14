package by.javatr.dao;
import by.javatr.entity.VirtualCard;
import java.math.BigDecimal;
import java.util.List;

public interface VirtualCardDao extends Dao<VirtualCard> {

    List<VirtualCard> readByUserId(String search) throws PersistentException;

    List<VirtualCard> readByMinBalance(BigDecimal search) throws PersistentException;
}
