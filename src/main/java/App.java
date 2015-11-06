import core.inputOutput.InputOptions;
import core.inputOutput.InputOptionsImpl;
import core.inputOutput.Printer;
import core.inputOutput.PrinterImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;

/**
 * Created by employee on 10/22/15.
 */
public class App {
    public static void main(String[] s)throws ParseException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean.xml"}, true);
        TicketOfficeController controller = (TicketOfficeController)context.getBean("controller");
        controller.openTicketOffice();
    }
}