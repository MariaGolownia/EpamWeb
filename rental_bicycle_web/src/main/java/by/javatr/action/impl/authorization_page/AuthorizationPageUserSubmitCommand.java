package by.javatr.action.impl.authorization_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.User;
import by.javatr.entity.en_um.Role;
import by.javatr.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationPageUserSubmitCommand extends BaseCommand {
    private static final String USER_LOGIN = "userLogin";
    private static final String USER_PASSWORD = "userPassword";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcherSuccess = null;
        String userLogin = request.getParameter(USER_LOGIN);
        String userPassword = request.getParameter(USER_PASSWORD);
        UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
        userPassword = userService.getHashCodePassword(userPassword);
        User userByLoginAndPassword = userService.findByLoginAndPassword(userLogin, userPassword);
        HttpSession session = request.getSession();

        if (userByLoginAndPassword != null || session.getAttribute("user_login")!=null) {
            if (session.getAttribute("user_login")==null) {
                session.setAttribute("user_login", userLogin);
            }
                request.setAttribute("userL", session.getAttribute("user_login"));
                //request.setAttribute("userR", userByLoginAndPassword.getRole());
                dispatcherSuccess = request.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp");

        } else {
            User userByLogin = userService.findByLogin(userLogin);
            request.setAttribute("loginUser", userLogin);
            request.setAttribute("loginErr", "Please check your password is correct!");
            dispatcherSuccess = request.getRequestDispatcher("/WEB-INF/jsp/authorization_page.jsp");


//                request.setAttribute("loginUser", userLogin);
//                RequestDispatcher dispatcherSomeStepsForSuccess = request.getRequestDispatcher("/WEB-INF/jsp/registration_page.jsp");
//                try {
//                    dispatcherSomeStepsForSuccess.forward(request, response);
//                } catch (ServletException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }

        }
        try {
            dispatcherSuccess.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
