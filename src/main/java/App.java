import ticketoffice.*;

/**
 * Created by employee on 10/22/15.
 */
public class App {
    public static void main(String[] s) {
        TicketOffice ticketOffice = new TicketOfficeImpl();

        Printer printer = new PrinterImpl(System.out);
        printer.printHelloMessage();
        InputOptions inputOptions = new InputOptionsImpl(System.in, printer);

        TicketOfficeController controller = new TicketOfficeController(inputOptions, ticketOffice, printer);
        controller.openTicketOffice();
    }
}
