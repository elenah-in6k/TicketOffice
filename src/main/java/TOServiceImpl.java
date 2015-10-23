import org.springframework.stereotype.Service;
import ticketoffice.Flight;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
@Service("storageService")
public class TOServiceImpl implements  TOService {
    private OfficeDao dao;
    public void save(CityN content) {
        dao.save(content);
    }

    public List<CityN> getAll() {
        return dao.getAll();
    }
}
