package is.hi.foodbar.controller;

import is.hi.foodbar.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import is.hi.foodbar.model.Restaurants;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

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
        chosenRest = (ArrayList<Restaurants>) restaurantsService.findAllMatches(name);
        model.addAttribute("chosenRest", chosenRest);
        return "infoPage";
    }
/*
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String search(@Valid @ModelAttribute(name="restaurant")
                         Restaurants restaurant,
                         BindingResult err,
                         ModelMap model) {
        System.out.println(restaurant);

        if (!err.hasErrors()) {
            ArrayList<Restaurants> chosenRest;
            chosenRest = (ArrayList<Restaurants>) restaurantsService.findFilteredMatches(restaurant);
            model.addAttribute("chosenRest", chosenRest);
        }

        return (err.hasErrors() ) ? "searchResults": "infoPage";
    }

*/
}
