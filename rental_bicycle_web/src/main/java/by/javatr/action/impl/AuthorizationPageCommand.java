package by.javatr.action.impl;

import by.javatr.action.BaseCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationPageCommand extends BaseCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
//        Интерфейс RequestDispatcher используется для работы с дополнительными ресурсами,
//        к которым относятся другой сервлет, страница JSP или документ HTML.
//        Данный интерфейс используется для внутренней коммуникации между сервлетами в одном контексте.
//        Доступ к RequestDispatcher можно получить с помощью метода getRequestDispatcher(String url)
//        интерфейса ServletContext.

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/authorization_page.jsp");
        try {
            dispatcher.forward(request, response);
            // передача запроса/управления другому ресурсу на сервере;
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
