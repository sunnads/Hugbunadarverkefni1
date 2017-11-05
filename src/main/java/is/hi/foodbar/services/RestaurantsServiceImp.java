
package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;

import java.util.List;

import is.hi.foodbar.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author Brynja Pálína Sigurgeirsdóttir
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 */
@Service
public class RestaurantsServiceImp implements RestaurantsService{

    // Tenging yfir í safn af veitingastöðum
    @Autowired
    RestaurantRepository restaurantRep;

    @Transactional
    @Override
    public void addRestaurant(Restaurants r) {
        restaurantRep.save(r);    // Notum save en ekki add
    }

    @Override
    public List<Restaurants> allRestaurants() {
        return restaurantRep.findAll();    // Notum findAll í staðinn fyrir getAll
    }

    @Override
    public Restaurants save(Restaurants restaurants) {
        return restaurantRep.save(restaurants);
    }

    @Override
    public List<Restaurants> findAllMatches(Restaurants restaurant) {

        //if(restaurant.getPostCode() < 0 && restaurant.getQuality() < 0)
        //    return restaurantRep.findWithoutPostQuality(name, address, menuType);
        //else
            return restaurantRep.findByName(restaurant.getName());
            //return restaurantRep.findByAll(name, postCode, address, quality, menuType);
    }

    @Override
    public boolean erALifi() {
        return true;
    }
}
