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
     * Birtir infoPage.jsp í viðmótinu.
     * Þar eru sýndar upplýsingar um veitingastaðin sem notandi valdi
     *
     * @return slóðin á skránna infoPage.jsp
     *//*
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(@RequestParam(value = "name", required = true) String name, ModelMap model) {
        ArrayList<Restaurants> chosenRests;
        chosenRests = (ArrayList<Restaurants>) restaurantsService.findAllMatches(name);
        model.addAttribute("chosenRest", chosenRest);
    }
*/
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String search(@Valid @ModelAttribute(name="restaurant")
                         Restaurants restaurant,
                         BindingResult err,
                         ModelMap model) {
        System.out.println(restaurant);

        if (!err.hasErrors()) {
            ArrayList<Restaurants> chosenRest;
            chosenRest = (ArrayList<Restaurants>) restaurantsService.findAllMatches(restaurant);
            model.addAttribute("chosenRest", chosenRest);
        }

        return (err.hasErrors() ) ? "searchResults": "infoPage";
    }

}
