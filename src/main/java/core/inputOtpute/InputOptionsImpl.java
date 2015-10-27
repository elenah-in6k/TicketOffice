package core.inputOtpute;

import core.entity.City;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public FlightOptions readSearchOptions()throws ParseException {
        read();
        printerImpl.printInputDateMessage();
//        LocalDate date = LocalDate.parse(inputOptions.next(),
//                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(inputOptions.next());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        printerImpl.printInputTicketMessage();
        int numberOfTicket = Integer.parseInt(inputOptions.next());

        printerImpl.printInputCityMessage();
        String nameCity = inputOptions.next();
        City city = new City(nameCity);
        return new FlightOptions(sqlDate, numberOfTicket, city);

//        return  new core.inputOtpute.FlightOptions(LocalDate.parse("30.11.2015",
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
