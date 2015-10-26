import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
@Service("storageService")
public class TOServiceImpl implements  TOService {
        private GenericDao<City,Integer> dao = new GenericDaoImpl<City,Integer>(City.class);
    public void save(City content) {
        dao.save(content);
    }


    public List<City> getAll() {
        return null;
        //dao.getAll();
    }
}
