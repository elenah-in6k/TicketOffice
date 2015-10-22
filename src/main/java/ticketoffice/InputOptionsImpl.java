package ticketoffice;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by employee on 10/21/15.
 */
public class InputOptionsImpl implements InputOptions {

    InputStream input;
    Scanner inputOptions;
    Printer printerImpl;

    public InputOptionsImpl(InputStream inputStream, Printer printerImpl) {
        input = inputStream;
        inputOptions = new Scanner(input);
        this.printerImpl = printerImpl;
    }

    public FlightOptions readSearchOptions() {
        read();
        printerImpl.printInputDateMessage();
        LocalDate date = LocalDate.parse(inputOptions.next(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        printerImpl.printInputTicketMessage();
        int numberOfTicket = Integer.parseInt(inputOptions.next());

        printerImpl.printInputCityMessage();
        String nameCity = inputOptions.next();
        City city = new City(nameCity);
        return new FlightOptions(date, numberOfTicket, city);

//        return  new ticketoffice.FlightOptions(LocalDate.parse("30.11.2015",
//               DateTimeFormatter.ofPattern("dd.MM.yyyy")), 1, city);
    }

    public void read() {
        byte[] inputChar = new byte[0];
        try {
            input.read(inputChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
