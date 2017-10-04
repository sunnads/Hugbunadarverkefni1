/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.foodbar.repository;

import is.hi.foodbar.model.Restaurants;
import java.util.List;

import is.hi.foodbar.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Karítas Sif, Brynja Pálína, Sunna Dröfn
 */

public interface RestaurantRepository extends JpaRepository<Restaurants, Long>{
    /**
     * Nær í öll restaurants
     * @return listi af resturants
     */
    List<Restaurants> findAll();
    
    /**
     * Nær í alla kennara
     * @param restaurants
     */
   // Resturants save(Resturants resturants);
    /**
     * Finnum alla kennara sem hafa lengra nafn en 3 stafir
     * 
     * @return lista af kennurum með nafn lengra en 3 stafir
     */ 
    @Query(value = "SELECT name FROM resturants where  name LIKE '%name%' ")
    List<Restaurants> findResturantsByName(String name);

    //List<Resturants> findAllByOrderByIdDesc();

   @Override
   Restaurants findOne(Long id);

   Restaurants save (Restaurants resturants);
   
   // Notið sama nafn og dálkanafn í töflunni/tilviksbreytan (e. attribute) 
   //List<Resturants> findByName(String name);
}
