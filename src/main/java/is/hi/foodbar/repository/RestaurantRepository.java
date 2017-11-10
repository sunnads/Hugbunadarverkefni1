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
import org.springframework.data.repository.query.Param;

/**
 * Tenging við gagnagrunninn fyrir veitingastaðina.
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
     * @return Veitingastað
     */
    Restaurants save(Restaurants restaurants);

    List<Restaurants> findByName(String name);

    @Query(value = "SELECT r FROM Restaurants r where lower(r.name) LIKE lower(concat('%', :name,'%'))")
    List<Restaurants> findByNameMatch(@Param("name") String name);

    @Query(value = "SELECT r FROM Restaurants r where lower(r.address) LIKE lower(concat('%', :address,'%'))")
    List<Restaurants> findByAddress(@Param("address") String address);

    @Query(value = "SELECT r FROM Restaurants r where r.postCode = :postCode")
    List<Restaurants> findByPostCode(@Param("postCode") int postCode);

    @Query(value = "SELECT r FROM Restaurants r where r.quality = :quality")
    List<Restaurants> findByQuality(@Param("quality") int quality);

    @Query(value = "SELECT r FROM Restaurants r where lower(r.menuType) LIKE lower(concat('%', :menuType,'%'))")
    List<Restaurants> findByMenuType(@Param("menuType") String menuType);
}
