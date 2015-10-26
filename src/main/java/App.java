import core.entity.City;
import core.daoInterface.CityDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by employee on 10/22/15.
 */
public class App {
    public static void main(String[] s) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"bean.xml"}, true);
//        TOService service = (TOService)context.getBean("storageService");
////        service.save(new core.entity.City());

        CityDao dao = (CityDao)context.getBean("cityDao");

//        for(int i=1; i<=6; i++){
//        City p = new City();
//        p.setName("Lviv");
//        dao.create(p);
//        System.out.print(p.getId() + " " + p.getName());}
        List<City> qq= dao.read(5, "id");
        for(City c : qq){
            System.out.print(c.getId()+" "+c.getName());
        }

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
