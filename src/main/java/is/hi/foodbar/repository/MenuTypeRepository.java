package is.hi.foodbar.repository;

import is.hi.foodbar.model.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Tenging við gagnagrunninn fyrir tegundir matseðla sem veitingastaðir hafa.
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

public interface MenuTypeRepository extends JpaRepository<MenuType, Long>{

    /**
     * Nær í alla matseðla veitingastaða
     *
     * @return listi af matseðlum fyrir veitingastaði
     */
    List<MenuType> findAll();

    /**
     * Bætir við matseðli fyrir veitingastað
     *
     * @param menu matseðill sem er bætt við
     * @return tegund matseðils fyrir veitingastað
     */
    MenuType save(MenuType menu);
}
