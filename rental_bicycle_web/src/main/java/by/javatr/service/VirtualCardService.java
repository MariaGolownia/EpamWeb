package by.javatr.service;
import by.javatr.entity.VirtualCard;

import java.math.BigDecimal;
import java.util.List;

public interface VirtualCardService {

    List<VirtualCard>  findByUserId(Integer userId);

    List<VirtualCard>  findByUserPassportId(String userPassportId) throws ServiceException;

    BigDecimal readBalance(String cardId);

    VirtualCard read(Integer id);

    void topUp(Integer cardId, BigDecimal ammount);
}
