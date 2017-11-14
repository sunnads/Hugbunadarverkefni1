package is.hi.foodbar.controller;

import is.hi.foodbar.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import is.hi.foodbar.model.Restaurants;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

/**
 * Controller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun sem hefur eitthvað með upplýsingarnar fyrir veitingastaðina
 * og birtingu þeirra að gera.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date Október 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Controller
public class InfoController {


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
     * Birtir infoPage.jsp í viðmótinu.
     * Þar eru sýndar upplýsingar um veitingastaðin sem notandi valdi
     *
     * @return slóðin á skránna infoPage.jsp
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String info(@RequestParam(value = "name", required = true) String name, ModelMap model) {
        ArrayList<Restaurants> chosenRest;
        chosenRest = (ArrayList<Restaurants>) restaurantsService.findAllWithName(name);
        model.addAttribute("chosenRest", chosenRest);
        return "infoPage";
    }
}
