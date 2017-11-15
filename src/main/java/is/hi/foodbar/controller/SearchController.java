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
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;


/**
 * Controller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun sem tengist leitinni.
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

    // Geymir síðustu leitarniðurstöður
    private ArrayList<Restaurants> lastSearch = new ArrayList<Restaurants>();

    @Autowired
    private RestaurantsService restaurantsService;

    /**
     * Setur upp nýan restaurant object sem search aðferðin getur breytt
     * eftir því hvað notandi leitaði að.
     * Header leitin þarf að hafa tilbúið Restaurant tilvik til að nota
     * í @ModelAttribute.
     *
     * @return Restaurant object sem er tómt
     */
    @ModelAttribute("restaurant")
    public Restaurants defaultInstance() {
        Restaurants restaurant = new Restaurants();
        return restaurant;
    }

    /**
     * Birtir indexPage í viðmótinu.
     * Þar er leitin fyrir veitingastaði birt
     *
     * @return vefsíða sem hefur upphafsviðmótið
     */
    // Þar sem klasinn hefur enga slóð, er þessi slóð "/index"
    @RequestMapping("/index")
    public String index(Model model){
        return "index"; // skilar .html skrá sem er /resources/templates/WEB-INF/index.html
    }

    /**
     * Leit fyrir leitargluggan í headernum.
     * Þessi leit notar leitarorðið (find) til að leita í gegnum nöfn, heimilisföng
     * póstnúmer og fleira og bætir öllum niðurstöðunum í lista
     *
     * @param find Strengur sem á að leita að
     * @param model Módel með attributum
     * @return Síða með leitarniðurstöðum
     */
    @RequestMapping(value = "/searchbar", method = RequestMethod.POST)
    public String searchbar(@RequestParam("find") String find, ModelMap model) {
        ArrayList<Restaurants> restaurantList;
        restaurantList = (ArrayList<Restaurants>) restaurantsService.findAllMatches(find);
        lastSearch = restaurantList;
        model.addAttribute("restaurantList", restaurantList);
        return "searchResults";
    }

    /**
     * Leit fyrir dropdown leitina í headernum.
     * Þessi leit tekur allt sem notandi setur inn í dropdown menuinu og
     * finnur allt sem passar við allt sem notandi setti inn.
     *
     * @param restaurant Restaurants tilvik sem inniheldur allt sem notandi afmarkaði leitina við
     * @param err BindingResult villur sem koma upp
     * @param model Módel með attributum
     * @return Síða með leitarniðurstöðum
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@Valid @ModelAttribute(name="restaurant")
                               Restaurants restaurant,
                               BindingResult err,
                               ModelMap model) {

        if (!err.hasErrors()) {
            ArrayList<Restaurants> restaurantList;
            restaurantList = (ArrayList<Restaurants>) restaurantsService.findFilteredMatches(restaurant);
            lastSearch = restaurantList;
            model.addAttribute("restaurantList", restaurantList);
        }

        return (err.hasErrors() ) ? "index": "searchResults";
    }

    /**
     * Aðferð til þess að fara aftur í seinustu leitaniðurstöður
     * án þess að þurfa að leita aftur
     *
     * @param model Módel með attributum
     * @return Síða með leitarniðurstöðum
     */
    @RequestMapping("/backToSearch")
    public String backToSearch(Model model){
        model.addAttribute("restaurantList", lastSearch);
        return "searchResults";
    }
}