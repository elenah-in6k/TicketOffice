import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/22/15.
 */
public class InputOptionsImplTest {
    @Test
    public void testInputOptions(){
        Printer printer = new PrinterImpl(System.out);
        InputStream input = new ByteArrayInputStream("30.11.2015\n1\nlviv".getBytes());
        InputOptionsImpl inputOptions = new InputOptionsImpl(input, printer);
        assertThat(inputOptions.setOptions().city.name, is("lviv"));
        
    }

}
