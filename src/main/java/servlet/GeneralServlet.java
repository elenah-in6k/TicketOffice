package servlet;

import core.inputOutput.HtmlPrinter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.BaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by employee on 11/2/15.
 */
public abstract class GeneralServlet extends HttpServlet {
    BaseServiceImpl service;
    HtmlPrinter printer;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = (BaseServiceImpl) context.getBean("service");
        printer = (HtmlPrinter)context.getBean("htmlPrinter");
    }
}
