package by.javatr.service.impl;
import by.javatr.dao.VirtualCardDao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.UserInfo;
import by.javatr.entity.VirtualCard;
import by.javatr.service.FactoryService;
import by.javatr.service.Service;
import by.javatr.service.VirtualCardService;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VirtualCardServiceImpl  extends Service implements VirtualCardService {
    @Override
    public List<VirtualCard>  findByUserId(Integer userId) {
        List<VirtualCard> virtualCards = new ArrayList<>();
        try {
            VirtualCardDao virtualCardDao = FactoryDaoSql.getInstance().get(DaoSql.VirtualCardDao);
            virtualCards = virtualCardDao.readByUserId(userId);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return  virtualCards;
    }

    @Override
    public List<VirtualCard> findByUserPassportId(String userPassportId) {
        List<VirtualCard> virtualCards = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        Integer userId = null;
        try {
            UserInfoServiceImpl userInfoDao = FactoryService.getInstance().get(DaoSql.UserInfoDao);
            userInfo = userInfoDao.findByIdNumberPassport(userPassportId);
            userId = userInfo.getId();
            VirtualCardDao virtualCardDao = FactoryDaoSql.getInstance().get(DaoSql.VirtualCardDao);
            virtualCards = virtualCardDao.readByUserId(userId);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return  virtualCards;
    }

    @Override
    public BigDecimal readBalance(String cardId) {
        BigDecimal balance = new BigDecimal(0.00);
        VirtualCard virtualCard = new VirtualCard();
        Integer userId = null;
        VirtualCardDao virtualCardService = FactoryService.getInstance().get(DaoSql.VirtualCardDao);
        try {
            virtualCard = virtualCardService.read(Integer.valueOf(cardId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        balance = virtualCard.getBalance();
        return  balance;
    }

    @Override
    public VirtualCard read(Integer id) {
        VirtualCard virtualCard = new VirtualCard();
        try {
            VirtualCardDao virtualCardDao = FactoryDaoSql.getInstance().get(DaoSql.VirtualCardDao);
            virtualCard = virtualCardDao.read(id);

        } catch (DaoException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  virtualCard;
    }

    @Override
    public void topUp(Integer cardId, BigDecimal ammount) {
        VirtualCardServiceImpl virtualCardService = new VirtualCardServiceImpl();
        VirtualCard virtualCard = virtualCardService.read(cardId);
        BigDecimal currentBalance = virtualCard.getBalance();
        currentBalance = currentBalance.add(ammount);
        virtualCard.setBalance(currentBalance);
        try {
            VirtualCardDao virtualCardDao = FactoryDaoSql.getInstance().get(DaoSql.VirtualCardDao);
                virtualCardDao.update(virtualCard);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
