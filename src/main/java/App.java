import core.daoInterface.FlightDao;
import core.entity.City;
import core.daoInterface.CityDao;
import core.entity.Flight;
import core.inputOtpute.InputOptions;
import core.inputOtpute.InputOptionsImpl;
import core.inputOtpute.Printer;
import core.inputOtpute.PrinterImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ticketoffice.TicketOfficeController;

import java.security.Timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by employee on 10/22/15.
 */
public class App {
    public static void main(String[] s)throws ParseException {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] {"bean.xml"}, true);
//
//
//        CityDao dao = (CityDao)context.getBean("cityDao");

//        for(int i=1; i<=6; i++){
//        City p = new City("Lviv");
//            dao.create(p);
//        System.out.print(p.getId() + " " + p.getName());}
//        List<City> qq= dao.read(5, "id");
//        for(City c : qq){
//            System.out.print(c.getId()+" "+c.getName());
//        }

//        FlightDao fDao = (FlightDao)context.getBean("flightDao");
//        List<Flight> flights = fDao.getAll();
//        for(Flight f: flights){
//            System.out.println(f.getIdFlight() + " " + f.getName() + " " + f.getDateTime());
//        }
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date date = sdf1.parse("2015-11-28");
//        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//        flights = fDao.findByDate(sqlStartDate, 5);
//            for(Flight f: flights){
//                System.out.println(f.getIdFlight() + " " + f.getName() + " " + f.getDateTime());
//            }

//
        Printer printer = new PrinterImpl(System.out);
        printer.printHelloMessage();
        InputOptions inputOptions = new InputOptionsImpl(System.in, printer);

        TicketOfficeController controller = new TicketOfficeController(inputOptions, printer);
        controller.openTicketOffice();
    }
}
