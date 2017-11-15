package is.hi.foodbar.controller;

import is.hi.foodbar.model.Restaurants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun sem tengist admin login.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Controller
public class LoginController {

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
     * Birtir login.html sem er síða til að skrá sig inn á admin
     * síðuna þar sem hægt er að bæta við veitingstöðum
     *
     * @return login sem er síða með formi til að skrá sig inn
     */
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * Birtir index.html
     * Síða til að sjá skilaboð í keyslu hver er skráður inn
     *
     * @return vefsíða sem hefur upphafsviðmótið
     */
    @RequestMapping("/dev")
    public String dev(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return "index";
    }
}
