package by.javatr.action.impl.selected_user_page;


import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.UserInfo;
import by.javatr.entity.VirtualCard;
import by.javatr.service.FactoryService;
import by.javatr.service.ServiceException;
import by.javatr.service.impl.VirtualCardServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetUserCards/*")
public class ActionFindUsersCards extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        List<VirtualCard> virtualCards = new ArrayList<>();
        VirtualCardServiceImpl virtualCardService = factoryService.get(DaoSql.VirtualCardDao);
        String json = "";
        String numberPasportStr = request.getParameter("userDocId").trim();
        if (numberPasportStr == null || "".equals(numberPasportStr)) {
            json = "None";
        } else {
            try {
                virtualCards = virtualCardService.findByUserPassportId(numberPasportStr);
                json = new Gson().toJson(virtualCards);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("text/plain");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request, response);
    }
}