package is.hi.foodbar.controller;

import is.hi.foodbar.model.MenuType;
import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.model.Type;
import java.util.ArrayList;
import is.hi.foodbar.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Tekur við skipunum frá vefviðmóti til að skrá nýjan veitingastað og birta lista af
 * veitingastöðum.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @date Október 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Controller
public class AddRestController {

    // Tenging yfir í þjónustu klasa fyrir forritið
    @Autowired
    private RestaurantsService restaurantService;

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
     * Bætir við veitingastað með upplýsingum sem admin skrifaði inn.
     *
     * @param addRestaurant Restaurants objectið sem verður bætt í gagnagrunnin
     * @param err BindingResult villur sem koma upp
     * @param model Módel með attributum
     * @return vefsíðu sem birtir upplýsingar um veitingastað sem bætt var við
     */
    @RequestMapping(value = "/addedRest", method = RequestMethod.POST)
    public String addRestaurant(@Valid @ModelAttribute(name="addRestaurant")
                         Restaurants addRestaurant,
                         BindingResult err,
                         ModelMap model) {

        if (!err.hasErrors()) {
            model.addAttribute("restaurants", addRestaurant);
            restaurantService.addRestaurant(addRestaurant);
        }

        return (err.hasErrors() ) ? "addRestaurant": "addedRestPage";
    }

    /**
     * Birtir síðu sem hefur töflu sem sýnir alla veitingastaði í gagnagrunninum og
     * upplýsingar um þá.
     *
     * @param model Módel með attributum
     * @return vefsíðu sem birtir upplýsingar um alla veitingastaði
     */
    @RequestMapping("/restList")
    public String restaurantList(Model model){
        ArrayList<Restaurants> listi;
        listi = (ArrayList<Restaurants>) restaurantService.allRestaurants();
        model.addAttribute("restaurantList", listi);
        return "restaurantListPage";
    }

    /**
     * Birtir admin innskráningu
     *
     * @return síða fyrir admin innskráningu
     */
    /*
    @RequestMapping("/admin")
    public String admin(){
        return "adminPage";
    }
    */

    /**
     * Birtir síðu þar sem hægt er að slá inn upplýsingar fyrir veitingastað
     * og bæta honum í gagnagrunn.
     *
     * @param model Módel með attributum
     * @return síða þar sem hægt er að bæta við veitingastað
     */
    @RequestMapping("/addRestaurant")
    public String addRestaurant(Model model){
        Restaurants r = new Restaurants();
        model.addAttribute("addRestaurant", r);
        return "addRestaurantPage";
    }

    /**
     * Birtir síðu til að bæta tegund við veitingastað
     *
     * @return síða til að bæta tegund við veitingastað
     */
    @RequestMapping("/addTypes")
    public String addTypes(){
        return "addTypePage";
    }

    /**
     * Býr til tegund (type) og bætir henni við veitingastaðinn (name)
     * @param typeName tegund á veitingastað
     * @param restName nafn á veitingastað
     * @return Birtir síðu til að bæta við fleiri tegundum,
     * og sýnir veitingastaðinn sem tegundinni var bætt við ef það heppnaðist
     */
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public String addType(@RequestParam("type") String typeName,
                          @RequestParam("name") String restName, ModelMap model) {
        Type type = new Type();
        type.setName(typeName);
        Restaurants r = restaurantService.findRestaurant(restName);
        if (r != null && !typeName.equals("0")) {
            restaurantService.addType(type, r);
            model.addAttribute("restaurants", r);
        }
        return "addTypePage";
    }

    /**
     * Birtir síðu til að bæta matseðilstegund við veitingastað
     *
     * @return síða til að bæta matseðilstegund við veitingastað
     */
    @RequestMapping("/addMenuTypes")
    public String addMenuTypes(){
        return "addMenuTypePage";
    }

    /**
     * Býr til matseðilstegund (menuType) og bætir henni við veitingastaðinn (name)
     * @param menuTypeName tegund matseðils fyrir veitingastað
     * @param restName nafn á veitingastað
     * @return Birtir síðu til að bæta við fleiri matseðilstegundum,
     * og sýnir veitingastaðinn sem matseðilstegundinni var bætt við ef það heppnaðist
     */
    @RequestMapping(value = "/addMenuType", method = RequestMethod.POST)
    public String addMenuType(@RequestParam("menuType") String menuTypeName,
                          @RequestParam("name") String restName, ModelMap model) {
        MenuType menuType = new MenuType();
        menuType.setName(menuTypeName);
        Restaurants r = restaurantService.findRestaurant(restName);
        if (r != null && !menuTypeName.equals("0")) {
            restaurantService.addMenuType(menuType, r);
            model.addAttribute("restaurants", r);
        }
        return "addMenuTypePage";
    }

    /**
     * Dæmi til að sýna prófanir með kalli á service klasa
     *
     * @param model Módel með attributum
     * @return skilar indexPage.jsp ef þjónustan "er á lífi" annars restaurantListPage
     */
    @RequestMapping (value = "/lifir", method=RequestMethod.GET)
    public String lifir(Model model) {
        Restaurants r = new Restaurants();
        model.addAttribute("restaurants", r);
        if(restaurantService.erALifi())
            return "view/indexPage";
        else
            return "view/restaurantListPage";
    }
}