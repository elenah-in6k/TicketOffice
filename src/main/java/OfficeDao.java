import java.io.Serializable;
import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
public interface OfficeDao {
    public void save(City content);
    public List<City> getAll();
}

