import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by employee on 10/22/15.
 */
public class App {
    public static void main(String[] s) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"bean.xml"}, true);
//        TOService service = (TOService)context.getBean("storageService");
////        service.save(new City());

        CityDao dao = (CityDao)context.getBean("cityDao");

        City p = new City();
        p.setName();
        p.setId();
        dao.create(p);



//        TicketOffice ticketOffice = new TicketOfficeImpl();
//
//        Printer printer = new PrinterImpl(System.out);
//        printer.printHelloMessage();
//        InputOptions inputOptions = new InputOptionsImpl(System.in, printer);
//
//        TicketOfficeController controller = new TicketOfficeController(inputOptions, ticketOffice, printer);
//        controller.openTicketOffice();
    }
}
