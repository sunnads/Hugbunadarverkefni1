package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 4.10.2017.
 */


public interface RestaurantsService  {


    /**
     * Fallið ber saman það sem notandi valdi/skrifaði inn í gluggan og það sem er í Resturants objectunum okkar,
     * þ.e. leitar að því sem notandi vildi finna.
     *
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggan
     * @param postCode         Integer sem inniheldur það sem notandi valdi fyrir póstnúmer
     * @param address          Strengur sem inniheldur það sem notandi skrifaði í address gluggan
     * @param quality          Integer sem inniheldur það sem notandi valdi fyrir gæðastaðal
     * @param menuType         Integer sem inniheldur það sem notandi valdi fyrir matseðil
     * @return Listi af öllum Resturants sem passa við það sem notandi leitaði að
     */
    List<Restaurants> searchRestaurant(String nafnVeitingastad, int postCode, String address,
                                                   int quality, String menuType);

    /**
     * Skilar öllum veitingastöðum í restaurants sem passa við leitina
     *
     * @return listi af veitingastöðum
     */
    List<Restaurants> findByName(String name);

    /**
     * Skilar öllum veitingastöðum í restaurants
     *
     * @return listi af veitingastöðum
     */
    List<Restaurants> allRestaurants();
}