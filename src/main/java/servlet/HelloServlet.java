package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/28/15.
 */
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html>\n" +
                "<body>" +
                "<h1>Hello Servlet</h1>" +
                "</body>" +
                "</html>");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
