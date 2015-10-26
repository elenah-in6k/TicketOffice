package ticketoffice;

import org.junit.Test;
import ticketoffice.oldclasses.Ticket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/21/15.
 */
public class TicketTest {
    @Test
    public void testIsReserved(){
        Ticket ticket = new Ticket(1);
        assertThat(ticket.isReserved(), is(false));
        ticket.Booking();
        assertThat(ticket.isReserved(), is(true));

    }

}
