import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
@Service("storageService")
public class TOServiceImpl implements  TOService {
    private OfficeDao dao;
    public void save(City content) {
        dao.save(content);
    }

    public List<City> getAll() {
        return dao.getAll();
    }
}
