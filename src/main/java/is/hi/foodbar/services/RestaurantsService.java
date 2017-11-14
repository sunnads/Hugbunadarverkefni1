package is.hi.foodbar.services;

import is.hi.foodbar.model.MenuType;
import is.hi.foodbar.model.OpeningTimes;
import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.model.Type;
import java.util.List;

/**
 * Þjónusta sem tengir við gagnagrunninn
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
     * Hendir veitingastað úr database
     *
     * @param id Long id á veitingastaðnum sem á að henda
     */
    void removeRestaurant(long id);

    /**
     * Bætir við tegund t fyrir veitingastað r
     * @param t tegund sem bætt er við
     * @param r veitingastað r
     */
    void addType(Type t, Restaurants r);

    /**
     * Bætir við matseðilstegund m fyrir veitingastað r
     * @param m tegund matseðils sem bætt er við
     * @param r veitingastað r
     */
    void addMenuType(MenuType m, Restaurants r);

    /**
     * Bætir við opnunartímum o fyrir veitingastað r
     * @param o opnunartímar sem verið er að bæta við
     * @param r veitingastað r
     */
    void addOpeningTimes(OpeningTimes o, Restaurants r);

    /**
     * Skilar öllum restaurants í restaurantsRep
     *
     * @return listi af restaurants
     */
    List<Restaurants> allRestaurants();

    /**
     * Finnur fyrsta veitingastað sem inniheldur það sem leitað er að í nafninu
     *
     * @param name sem leitað er að
     * @return veitingastaður sem passar við nafnið
     */
    Restaurants findRestaurant(String name);

    /**
     * Finnur fyrsta veitingastað sem inniheldur það sem leitað er að í nafninu
     *
     * @param id sem leitað er að
     * @return veitingastaðurinn sem hefur þetta id
     */
    Restaurants findRestaurantById(Long id);

    /**
     * Leitar í gagnagrunn að öllum vetingastöðum sem passa við það sem notandi slær inn.
     *
     * @param find Strengurinn sem notandi sló inn
     * @return listi af veitingastöðum sem passa við það sem notandi leitaði að
     */
    List<Restaurants> findAllMatches(String find);

    /**
     * Leitar í gagnagrunn að öllum vetingastöðum sem passa við allt sem notandi slær inn.
     *
     * @param restaurant veitingastaðurinn sem notandi vill finna
     * @return listi af veitingastöðum sem passa við það sem notandi leitaði að
     */
    List<Restaurants> findFilteredMatches(Restaurants restaurant);

    boolean erALifi();
}