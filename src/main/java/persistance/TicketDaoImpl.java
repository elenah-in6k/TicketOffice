package persistance;

import core.dao.TicketDao;
import core.entity.Ticket;
import org.springframework.stereotype.Repository;

/**
 * Created by employee on 10/26/15.
 */
@Repository("ticketDao")
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {
    public TicketDaoImpl() {
        super();
    }
}
