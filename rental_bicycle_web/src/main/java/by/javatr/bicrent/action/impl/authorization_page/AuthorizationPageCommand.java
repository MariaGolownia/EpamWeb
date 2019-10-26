package by.javatr.bicrent.action.impl.authorization_page;
import by.javatr.bicrent.action.BaseCommand;
import by.javatr.bicrent.controller.web_data.Attributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationPageCommand extends BaseCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
//Интерфейс RequestDispatcher используется для работы с дополнительными ресурсами,
//к которым относятся другой сервлет, страница JSP или документ HTML.
//Данный интерфейс используется для внутренней коммуникации между сервлетами в одном контексте.
//Доступ к RequestDispatcher можно получить с помощью метода getRequestDispatcher(String url)
//интерфейса ServletContext.
// The RequestDispatcher interface is used to work with additional resources,
// which include another servlet, a JSP page, or an HTML document.
// This interface is used for internal communication between servlets in the same context.
// RequestDispatcher can be accessed using the getRequestDispatcher(String url) method)
// ServletContext interface.

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/authorization_page.jsp");
        try {
            HttpSession session = request.getSession();
            session.removeAttribute(Attributes.USER_LOGIN);
            dispatcher.forward(request, response);
            // передача запроса/управления другому ресурсу на сервере;
        } catch (ServletException e) {
            LOGGER.error("ServletException from AuthorizationPageCommand =" + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IOException from AuthorizationPageCommand =" + e.getMessage());
        }
    }
}
