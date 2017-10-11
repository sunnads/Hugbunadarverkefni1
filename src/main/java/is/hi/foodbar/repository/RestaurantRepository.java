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
 *
 * @author Brynja Pálína Sigurgeirsdóttir
 */

public interface RestaurantRepository extends JpaRepository<Restaurants, Long>{
    /**
     * Nær í öll restaurants
     * @return listi af restaurants
     */
    List<Restaurants> findAll();

    /**
     * Bætir við restaurant
     * @param restaurants
     */
    Restaurants save (Restaurants restaurants);
}
