
package is.hi.foodbar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import is.hi.foodbar.model.MenuType;
import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.model.Type;
import is.hi.foodbar.repository.MenuTypeRepository;
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

    // Tenging yfir í safn af tegundum matseðla fyrir veitingastaði
    @Autowired
    private MenuTypeRepository menuTypeRep;

    @Transactional
    @Override
    public void addRestaurant(Restaurants r) {
        restaurantRep.save(r);    // Notum save en ekki add
    }

    @Transactional
    @Override
    public void addType(Type t, Restaurants r) {
        // Athugum hvort veitingastaðurinn hefur nú þegar þessa tegund
        Set<Type> types = r.getType();
        for (Type ty: types) {
            if(ty.getName().equals(t.getName())) return; // ef svo er hættum
        }
        // ef ekki bætum henni við veitingastaðinn.
        r.addType(t);
        Set<Type> h =  r.getType();
        typeRep.save(t);
    }

    @Transactional
    @Override
    public void addMenuType(MenuType m, Restaurants r) {
        // Athugum hvort veitingastaðurinn hefur nú þegar þessa tegund matseðils
        Set<MenuType> menus = r.getMenuType();
        for (MenuType mt: menus) {
            if(mt.getName().equals(m.getName())) return; // ef svo er hættum
        }
        // ef ekki bætum henni við veitingastaðinn.
        r.addMenuType(m);
        Set<Type> h =  r.getType();
        menuTypeRep.save(m);
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

        // Búum til lista og fyllum hann af öllum veitingastöðum sem hafa það sem notandi leitaði að í nafninu
        ArrayList<Restaurants> rList, addList;
        rList = (ArrayList<Restaurants>) restaurantRep.findByNameMatch(find);

        // bætum við öllum veitingastöðum sem hafa það sem notandi leitaði að í heimilisfanginu
        addList = (ArrayList<Restaurants>) restaurantRep.findByAddress(find);
        for (int i = 0; i < addList.size(); i++) {
            if(!rList.contains(addList.get(i))) {
                rList.add(addList.get(i));
            }
        }

        // Athugum hvort notandi sló inn tölu
        try {
            int findNumber = Integer.parseInt(find);

            // bætum við öllum veitingastöðum sem hafa það sem notandi leitaði að sem póst númer
            addList = (ArrayList<Restaurants>) restaurantRep.findByPostCode(findNumber);
            for (int i = 0; i < addList.size(); i++) {
                if(!rList.contains(addList.get(i))) {
                    rList.add(addList.get(i));
                }
            }

        } catch (NumberFormatException e) { }

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

        // filterum út það sem passar ekki við tegund sem notandi leitaði að
        if(restaurant.getType().iterator().hasNext() && !restaurant.getType().iterator().next().getName().equals("0")) {
            filterList = (ArrayList<Restaurants>) restaurantRep.findByType(restaurant.getType().iterator().next().getName());
            rList.retainAll(filterList);
        }

        // filterum út það sem passar ekki við matseðil sem notandi leitaði að
        if(restaurant.getMenuType().iterator().hasNext() && !restaurant.getMenuType().iterator().next().getName().equals("0")) {
            filterList = (ArrayList<Restaurants>) restaurantRep.findByMenuType(restaurant.getMenuType().iterator().next().getName());
            rList.retainAll(filterList);
        }

        return rList;
    }

    @Override
    public boolean erALifi() {
        return true;
    }
}
