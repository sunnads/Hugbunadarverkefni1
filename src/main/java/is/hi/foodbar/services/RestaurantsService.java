package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;
import java.util.List;

/**
 * Þjónusta sem athugar hvort nafn er á réttu formi
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 */
public interface RestaurantsService {

    /**
     * Bætir við restaurant í restaurantRep
     *
     * @param r Veitingastaðurinn sem bætt er við restaurantRep
     */
    void addRestaurant(Restaurants r);

    /**
     * Skilar öllum restaurants í restaurantsRep
     *
     * @return listi af restaurants
     */
    List<Restaurants> allRestaurants();

    /**
     *
     *
     * @param restaurants
     * @return
     */
    Restaurants save(Restaurants restaurants);
}
