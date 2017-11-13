/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.foodbar.repository;

import is.hi.foodbar.model.OpeningTimes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Tenging við gagnagrunninn fyrir opnunartíma veitingastaða.
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date november 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

public interface OpeningTimesRepository extends JpaRepository<OpeningTimes, Long>{
    /**
     * Nær í alla opnunartíma veitingastaða
     *
     * @return listi af opnunartímum fyrir veitingastaði
     */
    List<OpeningTimes> findAll();

    /**
     * Bætir við opnunartímum fyrir veitingastað
     *
     * @param open opnunartímar sem er bætt við
     * @return opnunartímar veitingarstaðar
     */
    OpeningTimes save(OpeningTimes open);
}
