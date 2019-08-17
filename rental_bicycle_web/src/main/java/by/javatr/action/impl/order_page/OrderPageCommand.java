package by.javatr.action.impl.order_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import by.javatr.entity.UserInfo;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.BicycleServiceImpl;
import by.javatr.service.impl.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderPageCommand extends BaseCommand {
    private static final Boolean BOOLEAN_FREE_BICYCLE = true;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();

//        Integer numberOrder = 0;
//        FactoryService factoryService = FactoryService.getInstance();
//        OrderServiceImpl orderService = factoryService.get(DaoSql.OrderDao);
//        numberOrder = orderService.getLastOrderId() + 1;
//        request.setAttribute("numberOrder", numberOrder);

        Location selectedLocation = (Location) session.getAttribute("selectedLocation");
        if (selectedLocation != null) {
            String selectedLocationInformation = selectedLocation.getCountry() + ", " +
                    selectedLocation.getCity() + ", " + selectedLocation.withoutCountryAndCityToString();

            request.setAttribute("selectLocation", selectedLocation.getId());
            request.setAttribute("selectAddress", selectedLocationInformation);

            List<Bicycle> bicycles = new ArrayList<>();
            List <String> informBicycles = new ArrayList<>();
            BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
            bicycles = bicycleService.findByFreeStatus(selectedLocation.getId(), BOOLEAN_FREE_BICYCLE);
//            Integer index = 1;
//            for (Bicycle bicycle : bicycles) {
//                String informBicycle = index + "id: " + bicycle.getId() + ", " + bicycle.getModel() + ", year: "
//                + bicycle.getProductionYear() + ", type: " + bicycle.getBicycleType();
//                informBicycles.add(informBicycle);
//                index++;
//            }
            request.setAttribute("bicycles", bicycles);

        }

        UserInfo selectedUserInfo = (UserInfo) session.getAttribute("selectedUserInfo");
        if (selectedUserInfo != null) {
            request.setAttribute("selectIdPassport", selectedUserInfo.getPassportIdentificationNumber());
            request.setAttribute("selectUser", selectedUserInfo.getSurname()+ ' ' + selectedUserInfo.getName());
        }

        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/order_page.jsp");

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
