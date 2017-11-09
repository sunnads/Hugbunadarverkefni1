package is.hi.foodbar.controller;

import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.services.RestaurantsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;


/**
 * Controller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date Október 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Controller
public class SearchController {

    //private ArrayList<Restaurants> restaurantList = new ArrayList<Restaurants>();

    @Autowired
    private RestaurantsService restaurantsService;

    /**
     * Setur upp nýan restaurant object sem search aðferðin getur breytt
     * eftir því hvað notandi leitaði að
     *
     * @return Restaurant object sem er tómt
     */
    @ModelAttribute("restaurant")
    public Restaurants defaultInstance() {
        Restaurants restaurant = new Restaurants();
        return restaurant;
    }

    /**
     * Birtir indexPage.jsp í viðmótinu.
     * Þar er leitin fyrir veitingastaði birt
     *
     * @return vefsíða sem hefur upphafsviðmótið
     */
    // Þar sem klasinn hefur enga slóð, er þessi slóð "/index"
    @RequestMapping("/index")
    public String index(Model model){
        //Restaurants r = new Restaurants();
        //model.addAttribute("restaurant", r);
        return "index"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
    }
    // bara test til að sjá mythmleaf keyra
    @RequestMapping("/test")
    public String test(){
        return "test"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
    }
    // færa allt af index yfir á þessa síðu til að finna villu hví hún keyrir ekki í thymleaf


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@Valid @ModelAttribute(name="restaurant")
                               Restaurants restaurant,
                               BindingResult err,
                               ModelMap model) {

        if (!err.hasErrors()) {
            ArrayList<Restaurants> restaurantList;
            restaurantList = (ArrayList<Restaurants>) restaurantsService.findAllMatches(restaurant);
            //restaurantList.add(restaurant);
            model.addAttribute("restaurantList", restaurantList);
        }

        return (err.hasErrors() ) ? "index": "searchResults";
    }
}