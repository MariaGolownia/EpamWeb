package by.javatr.action.impl.selected_user_page;

import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.VirtualCard;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.VirtualCardServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/GetTopUpBalance/*")
public class ActionTopUpBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        VirtualCardServiceImpl virtualCardService = factoryService.get(DaoSql.VirtualCardDao);
        String json = "";
        String cardIdStr = request.getParameter("userCardId").trim();
        String cardAmmountStr = request.getParameter("userCardAmmount").trim();

        if (cardIdStr == null || "".equals(cardIdStr)) {
            json = "None";
        } else {
            virtualCardService.topUp(Integer.valueOf(cardIdStr), new BigDecimal(cardAmmountStr));
            VirtualCard virtualCard = virtualCardService.read(Integer.valueOf(cardIdStr));
            json = virtualCard.getBalance().toString();
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
