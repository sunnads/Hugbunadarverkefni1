
package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;

import java.util.List;

import is.hi.foodbar.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Restaurants> findAllNameMatches(String nafn) {
        return restaurantRep.findByName(nafn);
    }
}
