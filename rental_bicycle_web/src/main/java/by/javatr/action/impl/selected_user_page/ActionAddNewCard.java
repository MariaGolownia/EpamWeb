package by.javatr.action.impl.selected_user_page;

import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.VirtualCard;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.VirtualCardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/AddNewCard/*")
public class ActionAddNewCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        VirtualCardServiceImpl virtualCardService = factoryService.get(DaoSql.VirtualCardDao);
        String json = "";

        String numberPasportStr = request.getParameter("userDocId").trim();
        String cardNameStr = request.getParameter("userCardName").trim();
        String cardAmmountStr = request.getParameter("userCardAmmount").trim();
        String cardCcyStr = request.getParameter("userCardCcy").trim();

        if (numberPasportStr == null || cardNameStr == null || "".equals(cardNameStr)) {
            json = "None";
        } else {
            System.out.println("Ok");
            //virtualCardService.topUp(Integer.valueOf(cardIdStr), new BigDecimal(cardAmmountStr));
            //VirtualCard virtualCard = virtualCardService.read(Integer.valueOf(cardIdStr));
            //json = virtualCard.getBalance().toString();
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
