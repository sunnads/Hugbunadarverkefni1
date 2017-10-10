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
import org.springframework.data.repository.query.Param;
import java.util.ArrayList;

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
     * Finnur nafn á veitingastað eftir því sem er leitað af
     * @param name
     * @return  Listi af nöfnum á veitingastöðum sem passa akkúrat við leitina
     *          Ef enginn veitingarstaður finnst, skilar auðum lista
     */
    //@Query("SELECT name FROM Restaurants WHERE LOWER(name) LIKE LOWER(name)")
    List<Restaurants> findRestaurantsByName(String name);



    //List<Resturants> findAllByOrderByIdDesc();

   @Override
   Restaurants findOne(Long id);

   Restaurants save (Restaurants resturants);
   
   // Notið sama nafn og dálkanafn í töflunni/tilviksbreytan (e. attribute) 
   //List<Resturants> findByName(String name);
}
