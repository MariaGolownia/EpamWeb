package by.javatr.action.impl.payment_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.UserInfoDao;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.*;
import by.javatr.entity.en_um.Currency;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentPageCommand extends BaseCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        String orderID=request.getParameter("orderid");

        OrderServiceImpl orderService = factoryService.get(DaoSql.OrderDao);
        Order order = orderService.read(Integer.valueOf(orderID));

        BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
        List<Integer>bicyclesIdList = order.getBicyclesId();
        List<Bicycle>bicycleList = bicycleService.findById(bicyclesIdList);

        UserInfoServiceImpl userService = factoryService.get(DaoSql.UserInfoDao);
        UserInfo userInfo = userService.findByIdentity(order.getUserId());

        List<VirtualCard>virtualCards = new ArrayList<>();
        VirtualCardServiceImpl virtualCardService = factoryService.get(DaoSql.VirtualCardDao);
        virtualCards = virtualCardService.findByUserId(userInfo.getId());

        request.setAttribute("IdPassportUser", userInfo.getPassportIdentificationNumber());
        request.setAttribute("idPayment", orderID);
        request.setAttribute("cards", virtualCards);
        request.setAttribute("bicycles", bicycleList);

        request.setAttribute("cardBalance", virtualCards.get(0).getBalance());
        request.setAttribute("cardCurrency", virtualCards.get(0).getCurrency());
//        request.setAttribute("orderDuration", orderService.calcDuration(order.getStartTime(),
//                order.getFinishTime()));

        Integer countDurationInMin = orderService.calcDurationInMin(order.getStartTime(),
                order.getFinishTime());
               request.setAttribute("orderDuration", countDurationInMin);

        PriceServiceImpl priceService = factoryService.get(DaoSql.PriceDao);
        Currency currency = priceService.read(bicycleList.get(0).getPriceId()).getCurrency();
        request.setAttribute("orderCurrency", currency.toString());

        BigDecimal ammountForPay = orderService.calcAmmountForPay(bicyclesIdList, countDurationInMin);
        request.setAttribute("orderAmount", ammountForPay);

        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment_page.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}