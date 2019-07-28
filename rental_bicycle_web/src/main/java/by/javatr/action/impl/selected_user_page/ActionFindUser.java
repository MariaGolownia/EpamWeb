package by.javatr.action.impl.selected_user_page;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.service.FactoryService;
import by.javatr.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetUser/*")
public class ActionFindUser extends HttpServlet {
public final static int DEFAULT_USER_ID = 9;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Используем Gson для преобразования массива в структурированный string
        FactoryService factoryService = FactoryService.getInstance();
        UserInfoServiceImpl userInfoService = factoryService.get(DaoSql.UserInfoDao);
        UserInfo userInfo = new UserInfo();
        String json = "";

        String numberPasportStr = request.getParameter("userDocId").trim();
        if (numberPasportStr == null || "".equals(numberPasportStr)) {
            userInfo = userInfoService.findByIdentity(DEFAULT_USER_ID);
        } else {
            userInfo = userInfoService.findByIdNumberPassport(numberPasportStr);
            HttpSession session = request.getSession();
            UserInfo userInfoSession = (UserInfo) session.getAttribute("selectedUserInfo");
            if (userInfoSession!=null)
                session.removeAttribute("selectedUserInfo");
            session.setAttribute("selectedUserInfo", userInfo);
            json = new Gson().toJson(userInfo);
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
