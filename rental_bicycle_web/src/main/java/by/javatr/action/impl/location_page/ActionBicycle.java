package by.javatr.action.impl.location_page;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.Bicycle;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.BicycleServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetFreeBicycles/*")
public class ActionBicycle extends HttpServlet {
    private static final Boolean BOOLEAN_FREE_BICYCLE = true;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        List<Bicycle> list = new ArrayList<>();
        String json = "";

        String locationIdStr = request.getParameter("locationId").trim();

        if (locationIdStr == null || "".equals(locationIdStr)) {
            json = "None";
        } else {
            Integer locationId = Integer.valueOf(locationIdStr);
            BicycleServiceImpl bicycleService = factoryService.get(DaoSql.BicycleDao);
            list = bicycleService.findByFreeStatus(locationId, BOOLEAN_FREE_BICYCLE);
            json = new Gson().toJson(list);
        }

        response.setContentType("text/plain");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
