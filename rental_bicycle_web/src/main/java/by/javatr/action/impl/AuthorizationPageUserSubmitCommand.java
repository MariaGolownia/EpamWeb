package by.javatr.action.impl;
import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.User;
import by.javatr.entity.en_um.Role;
import by.javatr.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        User userByLoginAndPassword = userService.findByLoginAndPassword(userLogin, userPassword);

        if (userByLoginAndPassword != null) {
            if (userByLoginAndPassword.getRole() == Role.ADMIN) {
                request.setAttribute("userL", userByLoginAndPassword.getLogin());
                request.setAttribute("userR", userByLoginAndPassword.getRole());
                dispatcherSuccess = request.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp");
            }
        else {
                request.setAttribute("userL", userByLoginAndPassword.getLogin());
                request.setAttribute("userP", userByLoginAndPassword.getRole());
                dispatcherSuccess = request.getRequestDispatcher("/WEB-INF/jsp/rent_page.jsp");
        }

            try {
                dispatcherSuccess.forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            User userByLogin = userService.findByLogin(userLogin);
            if (userByLogin != null) {
                request.setAttribute("loginUser", userLogin);
                request.setAttribute("loginErr", "User with this login exists! Please check your password is correct!");
                dispatcherSuccess = request.getRequestDispatcher("/WEB-INF/jsp/authorization_page.jsp");
                try {
                    dispatcherSuccess.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("loginUser", userLogin);
                RequestDispatcher dispatcherSomeStepsForSuccess = request.getRequestDispatcher("/WEB-INF/jsp/registration_page.jsp");
                try {
                    dispatcherSomeStepsForSuccess.forward(request, response);
                } catch (ServletException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
