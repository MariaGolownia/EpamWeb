package by.javatr.action.impl.location_page;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.Location;
import by.javatr.service.FactoryService;
import by.javatr.service.LocationService;
import by.javatr.service.impl.LocationServiceImpl;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetLocationImg/*")
public class ActionLocationImg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        Location location = new Location();
        String locationImg = "";

        String locationIdStr = request.getParameter("locationId").trim();
        if (locationIdStr == null || "".equals(locationIdStr)) {
            locationImg = "None";
        } else {
            Integer locationId = Integer.valueOf(locationIdStr);
            LocationServiceImpl locationService = factoryService.get(DaoSql.LocationDao);
            location = locationService.findById(locationId);
            HttpSession session = request.getSession();
            if ((Location)session.getAttribute("selectedLocation") != null)
                session.removeAttribute("selectedLocation");
            session.setAttribute("selectedLocation", location);
            locationImg = location.getPhoto();
        }

        response.setContentType("text/plain");
        try {
            response.getWriter().write(locationImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request, response);
    }
}
