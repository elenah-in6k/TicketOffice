import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by employee on 10/21/15.
 */
public class InputOptions {

    InputStream input;
    Scanner inputOptions;
    Printer printer;

    public InputOptions(InputStream inputStream, Printer printer) {
        input = inputStream;
        inputOptions = new Scanner(input);
        this.printer = printer;
    }
    public FlightOptions setOptions(){
        printer.printInputDateMessage();
        LocalDate date = LocalDate.parse(inputOptions.next().trim(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        printer.printInputTicketMessage();
        int numberOfTicket = inputOptions.nextInt();
        printer.printInputCityMessage();
        String nameCity = inputOptions.next().trim();
        City city = new City(nameCity);
        return  new FlightOptions(date, numberOfTicket, city);
    }
}
