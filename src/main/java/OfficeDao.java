import ticketoffice.Flight;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
public interface OfficeDao {
    public void save(CityN content);
    public List<CityN> getAll();
}