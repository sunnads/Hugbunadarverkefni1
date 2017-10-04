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

    // Tenging yfir í safn af kennurum
    @Autowired
    RestaurantRepository restoRep;

    @Override
    public List<Restaurants> allRestaurants() {
        return restoRep.findAll();    // Notum findAll í staðinn fyrir getAll
    }


    @Override
    public List<Restaurants> findByName() { return restoRep.findResturantsByName("name");
    }

    @Override
    public ArrayList<Restaurants> searchRestaurant(String nafnVeitingastad, int postCode, String address,
                                                    int quality, String menuType) {

        ArrayList<Restaurants> list = new ArrayList<Restaurants>();
        ArrayList<Restaurants> resultList = new ArrayList<Restaurants>();

        //list = findResturantsByName(nafnVeitingastad);

        return resultList;
    }
}