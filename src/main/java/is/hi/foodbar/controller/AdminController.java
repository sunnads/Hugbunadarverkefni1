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
 * Created by Lenovo on 13.11.2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @ModelAttribute("restaurant")
    public Restaurants defaultInstance() {
        Restaurants restaurant = new Restaurants();
        return restaurant;
    }

  /*  @RequestMapping
    public String index(Model model) {
        return "adminIndex";
    }*/

    @RequestMapping
    public String addRestaurant(Model model){
        Restaurants r = new Restaurants();
        model.addAttribute("addRestaurant", r);
        return "addRestaurantPage";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
