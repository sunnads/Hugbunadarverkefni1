package is.hi.foodbar.services;

import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALLUR HÓPURINN
 * @date októmber 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 */
@Service
public class RestaurantsServiceImp implements RestaurantsService{

    // Tenging yfir í safn af veitingastöðum
    @Autowired
    RestaurantRepository restoRep;

    @Override
    public List<Restaurants> allRestaurants() {
        return restoRep.findAll();    // Notum findAll í staðinn fyrir getAll
    }


    @Override
    public List<Restaurants> findByName(String name) { return restoRep.findRestaurantsByName(name);
    }

    @Override
    public List<Restaurants> searchRestaurant(String nafnVeitingastad, int postCode, String address,
                                                    int quality, String menuType) {

        List<Restaurants> list = new ArrayList<Restaurants>();
        List<Restaurants> resultList = new ArrayList<Restaurants>();

        //list = findResturantsByName(nafnVeitingastad);

        return resultList;
    }
}