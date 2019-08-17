package by.javatr.action.impl.order_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Order;
import by.javatr.service.BicycleService;
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
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@WebServlet("/startOrder/*")
public class ActionStartOrder extends BaseCommand {
public static final Boolean FREE_STATUS_FALSE = false;

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        String userIdPassword = request.getParameter("idOfPassport");
//        String locationID = request.getParameter("idLocation");
//        List<Integer> bicycleIdList = new ArrayList<>();
//        Integer orderId;
//        String[] id = request.getParameter("idVal").split(",");
//        for (int i = 0; i < id.length; i++) {
//            bicycleIdList.add(Integer.valueOf(id[i]));
//        }
//        //bicycleIdList = request.getParameter("idVal");
//        FactoryService factoryService = FactoryService.getInstance();
//        BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
//        bicycleService.changeFreeStatus(bicycleIdList, FREE_STATUS_FALSE);
//
//        OrderServiceImpl userOrderService = factoryService.get(DaoSql.OrderDao);
//        String json = "";
//        orderId = userOrderService.createOrder(userIdPassword, bicycleIdList, locationID);
//
//        Order order = new Order();
//        order = userOrderService.readStartOrder(orderId);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("newOrderId", Integer.toString(orderId));
//        json = new Gson().toJson(order);
//
//        response.setContentType("text/plain");
//        try {
//            response.getWriter().write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
//        doGet(request, response);
//    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String userIdPassword = request.getParameter("idOfPassport");
        String locationID = request.getParameter("idLocation");
        List<Integer> bicycleIdList = new ArrayList<>();
        Integer orderId;
        String[] id = request.getParameter("idVal").split(",");
        for (int i = 0; i < id.length; i++) {
            bicycleIdList.add(Integer.valueOf(id[i]));
        }
        //bicycleIdList = request.getParameter("idVal");
        FactoryService factoryService = FactoryService.getInstance();
        BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
        bicycleService.changeFreeStatus(bicycleIdList, FREE_STATUS_FALSE);

        OrderServiceImpl userOrderService = factoryService.get(DaoSql.OrderDao);
        String json = "";
        orderId = userOrderService.createOrder(userIdPassword, bicycleIdList, locationID);

        Order order = new Order();
        order = userOrderService.readStartOrder(orderId);

        HttpSession session = request.getSession();
        session.setAttribute("newOrderId", Integer.toString(orderId));
        json = new Gson().toJson(order);

        response.setContentType("text/plain");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
