package by.javatr.controller.util;
import by.javatr.controller.web_data.Attributes;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Helper class that handles all the work with user forwarding/redirecting.
 * <p>Provides internal API to controller layer, making it easier to develop commands.
 * <p>Makes possible to set system messages to notify users, even considering the JSP pages are
 * located within WEB-INF folder.
 * <p>To set a message, it's type code and localization bundle key must be provided.
 * <p>If the message type is not specified, 'fail/error' type is set by default.
 */
public class Dispatcher {

    /**
     * Indicates that the message must be displayed as 'success' message.
     */
    public static final int MESSAGE_TYPE_SUCCESS = 0;
    /**
     * Indicates that the message must be displayed as 'fail/error' message.
     */
    public static final int MESSAGE_TYPE_FAIL = 1;

    private Dispatcher() {
    }

    /**
     * Redirects current http request to the given URL.
     *
     * @param url      absolute URL to be redirected to
     * @param response current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToURL(String url, HttpServletResponse response) throws IOException {
        response.sendRedirect(url);
    }

    /**
     * Redirects current http request to the given URL and
     * sets system message key as a cookie with the type 'FAIL'.
     * <p>
     * The message key may be converted in MessageKeyFromCookieFilter from cookie to attribute
     * with the same name.
     * JSP pages can use this message key in order to get the localized message.
     * <p>
     * As no request info is transferred using redirect, cookies is the only option
     * to send the message.
     *
     * @param url        absolute URL to be redirected to
     * @param messageKey system message key to be set on JSP pages, must contain no spaces (cookies restriction)
     * @param response   current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToURL(String url, String messageKey,
                                     HttpServletResponse response) throws IOException {
        redirectToURL(url, MESSAGE_TYPE_FAIL, messageKey, response);
    }

    /**
     * Redirects current http request to the given URL and
     * sets system message key as a cookie with the given type.
     * <p>
     * The message key may be converted in MessageKeyFromCookieFilter from cookie to attribute
     * with the same name.
     * JSP pages can use this message key in order to get the localized message.
     * <p>
     * As no request info is transferred using redirect, cookies is the only option
     * to send the message.
     *
     * @param url         absolute URL to be redirected to
     * @param messageType type of the message to be sent (0 - success, 1 - fail)
     * @param messageKey  system message key to be set on JSP pages, must contain no spaces (cookies restriction)
     * @param response    current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToURL(String url, int messageType, String messageKey,
                                     HttpServletResponse response) throws IOException {
        String attributeName;
        switch (messageType) {
            case 0:
                attributeName = Attributes.SYSTEM_MESSAGE_SUCCESS;
                break;
            case 1:
            default:
                attributeName = Attributes.SYSTEM_MESSAGE_FAIL;
        }
        Cookie attributeCookie = new Cookie(attributeName, messageKey);
        response.addCookie(attributeCookie);
        response.sendRedirect(url);
    }

    /**
     * Redirects current http request to the given Command by making the URL
     * from the context path and command URL.
     *
     * @param commandUrl command URL to be redirected to, must start with '/'
     * @param request    current http request
     * @param response   current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToCommand(String commandUrl, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String destinationUrl = request.getContextPath() + commandUrl;
        redirectToURL(destinationUrl, response);
    }

    /**
     * Redirects current http request to the given Command by making the URL
     * from the context path and command URL. Also
     * sets system message key as a cookie with the type 'FAIL'.
     * <p>
     * The message key may be converted in MessageKeyFromCookieFilter from cookie to attribute
     * with the same name.
     * JSP pages can use this message key in order to get the localized message.
     * <p>
     * As no request info is transferred using redirect, cookies is the only option
     * to send the message.
     *
     * @param commandUrl command URL to be redirected to, must start with '/'
     * @param messageKey system message key to be set on JSP pages, must contain no spaces (cookies restriction)
     * @param request    current http request
     * @param response   current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToCommand(String commandUrl, String messageKey,
                                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        String destinationUrl = request.getContextPath() + commandUrl;
        redirectToURL(destinationUrl, MESSAGE_TYPE_FAIL, messageKey, response);
    }

    /**
     * Redirects current http request to the given Command by making the URL
     * from the context path and command URL. Also
     * sets system message key as a cookie with the given type.
     * <p>
     * The message key may be converted in MessageKeyFromCookieFilter from cookie to attribute
     * with the same name.
     * JSP pages can use this message key in order to get the localized message.
     * <p>
     * As no request info is transferred using redirect, cookies is the only option
     * to send the message.
     *
     * @param commandUrl  command URL to be redirected to, must start with '/'
     * @param messageType type of the message to be sent (0 - success, 1 - fail)
     * @param messageKey  system message key to be set on JSP pages, must contain no spaces (cookies restriction)
     * @param request     current http request
     * @param response    current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed or
     *                                         if a partial URL is given and cannot be converted into a valid URL.
     */
    public static void redirectToCommand(String commandUrl, int messageType, String messageKey,
                                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        String destinationUrl = request.getContextPath() + commandUrl;
        redirectToURL(destinationUrl, messageType, messageKey, response);
    }

    /**
     * Sends an error response to the client using the specified status code and clearing the buffer.
     * If the response has already been committed, this method throws an IllegalStateException.
     * After using this method, the response should be considered to be committed and should not be written to.
     *
     * @param statusCode the error status code
     * @param response   current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed before this method call.
     */
    public static void sendError(int statusCode, HttpServletResponse response) throws IOException {
        response.sendError(statusCode);
    }

    /**
     * Sends an error response to the client using the specified status code and clearing the buffer.
     * If the response has already been committed, this method throws an IllegalStateException.
     * After using this method, the response should be considered to be committed and should not be written to.
     * <p>
     * Also sets system message key as an attribute to be shown on JSP pages.
     * The message key for errors is always set as an error message.
     *
     * @param statusCode the error status code
     * @param messageKey system message key to be set on JSP pages
     * @param request    current http request
     * @param response   current http response
     * @throws java.io.IOException             - if an input or output exception occurs.
     * @throws java.lang.IllegalStateException - if the response was committed before this method call.
     */
    public static void sendError(int statusCode, String messageKey, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute(Attributes.SYSTEM_MESSAGE_FAIL, messageKey);
        response.sendError(statusCode);
    }

    /**
     * Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
     * This method allows one servlet to do preliminary processing of a request and another resource to generate the response.
     * <p>
     *
     * @param page     page to be redirected to
     * @param request  current http request
     * @param response current http response
     * @throws ServletException                - if the target resource throws this exception.
     * @throws java.io.IOException             - if the target resource throws this exception.
     * @throws java.lang.IllegalStateException - if the response was already committed.
     */
    public static void forwardTo(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    /**
     * Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
     * This method allows one servlet to do preliminary processing of a request and another resource to generate the response.
     * <p>
     * Also sets system message key as an attribute to be shown on JSP pages, with the type 'FAIL'.
     *
     * @param page       page to be redirected to,
     * @param messageKey system message key to be set on JSP pages
     * @param request    current http request
     * @param response   current http response
     * @throws ServletException                - if the target resource throws this exception
     * @throws java.io.IOException             - if the target resource throws this exception
     * @throws java.lang.IllegalStateException - if the response was already committed
     */
    public static void forwardTo(String page, String messageKey,
                                 HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardTo(page, MESSAGE_TYPE_FAIL, messageKey, request, response);
    }

    /**
     * Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
     * This method allows one servlet to do preliminary processing of a request and another resource to generate the response.
     * <p>
     * Also sets system message key as an attribute to be shown on JSP pages, with the given type.
     *
     * @param page        page to be redirected to
     * @param messageType type of the message to be sent (0 - success, 1 - fail)
     * @param messageKey  system message key to be set on JSP pages
     * @param request     current http request
     * @param response    current http response
     * @throws ServletException                - if the target resource throws this exception
     * @throws java.io.IOException             - if the target resource throws this exception
     * @throws java.lang.IllegalStateException - if the response was already committed
     */
    public static void forwardTo(String page, int messageType, String messageKey,
                                 HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attributeName;
        switch (messageType) {
            case 0:
                attributeName = Attributes.SYSTEM_MESSAGE_SUCCESS;
                break;
            case 1:
            default:
                attributeName = Attributes.SYSTEM_MESSAGE_FAIL;
        }
        request.setAttribute(attributeName, messageKey);
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    /**
     * Extracts URL of the previous page from the http request object.
     *
     * @param request current http request
     * @return a String containing the previous page URL, or <code>null</code>
     * if the request does not contain the corresponding header.
     */
    public static String getPreviousPageURL(HttpServletRequest request) {
        return request.getHeader("referer");
    }
}
