package persistance.daoImplements;

import core.daoInterface.TicketDao;
import core.entity.Ticket;

/**
 * Created by employee on 10/26/15.
 */
public class TicketDaoImpl extends GenericDaoImpl<Ticket,Integer> implements TicketDao {
    public TicketDaoImpl(Class<Ticket> entityClass) {
        super(entityClass);
    }
}
