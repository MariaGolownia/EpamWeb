package by.javatr.bicrent.action.impl.selected_user_page;
import by.javatr.bicrent.action.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageCommand extends BaseCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;

        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selected_user_page.jsp");

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
