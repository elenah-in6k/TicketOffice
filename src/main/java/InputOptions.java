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

    public InputOptions(InputStream inputStream) {
        input = inputStream;
        inputOptions = new Scanner(input);
    }
    public FlightOptions setOptions(){
        System.out.print("Input date in format dd.mm.yyyy: ");
        LocalDate date = LocalDate.parse(inputOptions.next().trim(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.print("Input quntity ticket: ");
        int numberOfTicket = inputOptions.nextInt();
        System.out.print("Input city: ");
        String nameCity = inputOptions.next().trim();
        City city = new City(nameCity);
        return  new FlightOptions(date, numberOfTicket, city);
    }
}
