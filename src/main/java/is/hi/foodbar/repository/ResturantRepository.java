/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.foodbar.repository;

import is.hi.foodbar.model.Resturants;
import java.util.List;

import is.hi.foodbar.model.Resturants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Karítas Sif, Brynja Pálína, Sunna Dröfn
 */

public interface ResturantRepository extends JpaRepository<Resturants, Long>{
    /**
     * Nær í öll resturants
     * @return listi af resturants
     */
    List<Resturants> findAll();
    
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
    @Query(value = "SELECT name FROM resturants where length name LIKE '%nafnVeitingastad%' ")
    List<Resturants> findResturantsByName();

    //List<Resturants> findAllByOrderByIdDesc();

   @Override
   Resturants findOne(Long id);
   
   // Notið sama nafn og dálkanafn í töflunni/tilviksbreytan (e. attribute) 
   //List<Kennari> findByNafn(String nafn);
}
