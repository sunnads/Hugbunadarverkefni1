/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.foodbar.repository;

import is.hi.foodbar.model.Restaurants;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Tenging við gagnagrunninn.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @date Október 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

public interface RestaurantRepository extends JpaRepository<Restaurants, Long>{
    /**
     * Nær í öll restaurants
     *
     * @return listi af restaurants
     */
    List<Restaurants> findAll();

    /**
     * Bætir við restaurant
     *
     * @param restaurants veitingastaðurinn sem á að bæta í gagnagrunninn
     */
    Restaurants save(Restaurants restaurants);

    /**
     * Finnum alla veitingastaði sem innihalda nafnið sem leitað er að í sínu nafni.
     *
     * @param nafn Strengur sem leitað er að
     * @return lista af veitingastöðum sem passa við leitina
     */
    @Query(value = "SELECT name FROM Restaurants restaurants where restaurants.name LIKE %?1%")
    List<Restaurants> findByName(String nafn);
}
