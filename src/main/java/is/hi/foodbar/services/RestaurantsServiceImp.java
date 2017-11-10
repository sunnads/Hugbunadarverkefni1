
package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import is.hi.foodbar.model.Type;
import is.hi.foodbar.repository.RestaurantRepository;
import is.hi.foodbar.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 */
@Service
public class RestaurantsServiceImp implements RestaurantsService{

    // Tenging yfir í safn af veitingastöðum
    @Autowired
    private RestaurantRepository restaurantRep;

    // Tenging yfir í safn af tegundum fyrir veitingastaði
    @Autowired
    private TypeRepository typeRep;

    @Transactional
    @Override
    public void addRestaurant(Restaurants r) {
        restaurantRep.save(r);    // Notum save en ekki add
    }

    @Transactional
    @Override
    public void addType(Type t, Restaurants r) {
        r.addType(t);
        Set<Type> h =  r.getType();
        typeRep.save(t);
    }

    @Override
    public List<Restaurants> allRestaurants() {
        return restaurantRep.findAll();    // Notum findAll í staðinn fyrir getAll
    }

    @Override
    public Restaurants findRestaurant(String name) {

        if(restaurantRep.findByName(name).size() != 0)
            return restaurantRep.findByName(name).iterator().next();
        else
            return null;
    }

    @Override
    public List<Restaurants> findAllMatches(String find) {

        // Búum til lista og fyllum hann af öllum veitingastöðum sem passa við nafnið sem notandi leitaði að
        ArrayList<Restaurants> rList, filterList;
        rList = (ArrayList<Restaurants>) restaurantRep.findByNameMatch(find);
        return rList;
    }

    @Override
    public List<Restaurants> findFilteredMatches(Restaurants restaurant) {

        // Búum til lista og fyllum hann af öllum veitingastöðum sem passa við nafnið sem notandi leitaði að
        ArrayList<Restaurants> rList, filterList;
        rList = (ArrayList<Restaurants>) restaurantRep.findByNameMatch(restaurant.getName());

        // filterum út það sem passar ekki við heimilisfang sem notandi leitaði að
        filterList = (ArrayList<Restaurants>) restaurantRep.findByAddress(restaurant.getAddress());
        rList.retainAll(filterList);

        if(restaurant.getPostCode() != 0) {
            // filterum út það sem passar ekki við póstkóða sem notandi leitaði að
            filterList = (ArrayList<Restaurants>) restaurantRep.findByPostCode(restaurant.getPostCode());
            rList.retainAll(filterList);
        }

        if(restaurant.getQuality() != 0) {
            // filterum út það sem passar ekki við gæði sem notandi leitaði að
            filterList = (ArrayList<Restaurants>) restaurantRep.findByQuality(restaurant.getQuality());
            rList.retainAll(filterList);
        }

        // filterum út það sem passar ekki við matseðil sem notandi leitaði að
/*        String menu = "";
        ArrayList<String> menuList = restaurant.getMenuType();
        for (int i=0; i < menuList.size(); i++) {
            menu += "" + menuList.get(i) + " ";
        }
        filterList = (ArrayList<Restaurants>) restaurantRep.findByMenuType(menu);
        rList.retainAll(filterList);
*/
        return rList;
    }

    @Override
    public boolean erALifi() {
        return true;
    }
}
