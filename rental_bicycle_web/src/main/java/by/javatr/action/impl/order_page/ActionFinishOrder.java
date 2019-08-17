package by.javatr.action.impl.order_page;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.Order;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.BicycleServiceImpl;
import by.javatr.service.impl.OrderServiceImpl;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finishOrder/*")
public class ActionFinishOrder extends HttpServlet {
    public static final Boolean FREE_STATUS_TRUE = true;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer orderId = Integer.valueOf(request.getParameter("idOrder"));
        String finishTimeStr = "";
        FactoryService factoryService = FactoryService.getInstance();
        OrderServiceImpl userOrderService = factoryService.get(DaoSql.OrderDao);
        String json = "";
        finishTimeStr = userOrderService.setFinishTime(orderId);
        response.setContentType("text/plain");

//        List<Integer> bicycleIdList = new ArrayList<>();
//        // Обращение для поиска велосипедов по idOrder
//        bicycleIdList =
//        BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
//        bicycleService.changeFreeStatus(bicycleIdList, FREE_STATUS_TRUE);

        try {
            response.getWriter().write(finishTimeStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request, response);
    }
}
