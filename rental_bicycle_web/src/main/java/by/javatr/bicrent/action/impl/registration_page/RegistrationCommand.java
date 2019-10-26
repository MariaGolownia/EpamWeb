package by.javatr.bicrent.action.impl.registration_page;

import by.javatr.bicrent.action.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationCommand extends BaseCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String USER_MODE = "mode";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        String mode = request.getParameter(USER_MODE);

        if (mode != null && mode.toLowerCase().equals("admin"))
        {
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/registration_page_adm.jsp");
        }
        else{
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration_page.jsp");
        }

        try {
            dispatcher.forward(request, response);
            // передача запроса/управления другому ресурсу на сервере;
        } catch (ServletException e) {
            // TODO ADD LOCK
           // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
           // e.printStackTrace();
        }

    }
}
