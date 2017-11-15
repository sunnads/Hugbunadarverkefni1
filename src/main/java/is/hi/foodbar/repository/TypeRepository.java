package is.hi.foodbar.repository;

import is.hi.foodbar.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Tenging við gagnagrunninn fyrir tegundir af veitingastöðum.
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
public interface TypeRepository extends JpaRepository<Type, Long>{

    /**
     * Nær í allar tegundir af veitingastöðum
     *
     * @return listi af tegundum fyrir veitingastaði
     */
    List<Type> findAll();

    /**
     * Bætir við tegund að veitingastað
     *
     * @param type tegund veitingarstaðar sem er bætt við
     * @return Tegund veitingastaðs
     */
    Type save(Type type);
}
