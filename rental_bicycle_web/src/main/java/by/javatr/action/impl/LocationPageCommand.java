package by.javatr.action.impl;

import by.javatr.action.BaseCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocationPageCommand extends BaseCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;

        request.setAttribute("userL", request.getParameter("userL"));
        request.setAttribute("userR", request.getParameter("userR"));
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/location_page.jsp");

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
