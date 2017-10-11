package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;
import java.util.List;

/**
 *
 * @author Brynja Pálína Sigurgeirsdóttir
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Þjónusta sem athugar hvort nafn er á réttu formi
 *
 */
public interface RestaurantsService {


    /**
     * Bætir við restaurant í restaurantRep
     *
     * @param r Restaurants
     */
    public void addRestaurant(Restaurants r);

    /**
     * Skilar öllum restaurants í restaurantsRep
     *
     * @return listi af restaurants
     */
    public List<Restaurants> allRestaurants();

    public Restaurants save(Restaurants restaurants);


}
