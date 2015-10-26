import core.entity.City;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
public interface TOService {
    public void save(City content);
    public List<City> getAll();
}
