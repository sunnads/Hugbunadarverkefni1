package is.hi.foodbar.controller;

import org.springframework.stereotype.Controller;
import is.hi.foodbar.model.Restaurants;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class InfoController {

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
    @RequestMapping(value="/info", method=RequestMethod.POST)
    public String infoPage(@RequestParam(value="item", required=false) Restaurants item, ModelMap model){
        model.addAttribute("item", item);
        return "view/infoPage"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/infoPage.jsp
    }

}
