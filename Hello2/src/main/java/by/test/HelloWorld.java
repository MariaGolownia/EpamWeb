package by.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
        {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!10</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!10</h1>");
        out.println("</body>");
        out.println("</html>");
        }
}
