package is.hi.foodbar.controller;

import is.hi.foodbar.model.Restaurants;
import is.hi.foodbar.services.RestaurantsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Autowired
    RestaurantsService restaurantsService;

    /**
     * Birtir indexPage.jsp í viðmótinu.
     * Þar er leitin fyrir veitingastaði birt
     *
     * @return vefsíða sem hefur upphafsviðmótið
     */
    // Þar sem klasinn hefur enga slóð, er þessi slóð "/index"
    @RequestMapping("/index")
    public String index(){
        return "index"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
    }
    // bara test til að sjá mythmleaf keyra
    @RequestMapping("/test")
    public String test(){
        return "test"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
    }
    // færa allt af index yfir á þessa síðu til að finna villu hví hún keyrir ekki í thymleaf
    @RequestMapping("/indexto")
    public String indexto(){
        return "indexto"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
    }

    @RequestMapping("/head")
    public String head(){
        return "head"; // skilar .html skrá sem er /resources//templates/WEB-INF/head.html
    }

    /**
     * Notar POST til að ná í upplýsingar frá notanda og setja þær í model.
     * Sýnir niðurstöður leitarinnar á searchPage.
     *
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggann
     * @param postCode Integer sem inniheldur það sem notandi valdi fyrir póstnúmer
     * @param address Strengur sem inniheldur það sem notandi skrifaði í address gluggan
     * @param quality Integer sem inniheldur það sem notandi valdi fyrir gæðastaðal
     * @param menuType Integer sem inniheldur það sem notandi valdi fyrir matseðil
     * @param model Modelið sem við notum
     * @return vefsíða sem birtir leitarniðurstöður
     */
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam(value="nafnVeitingastad", required=false) String nafnVeitingastad,
                         @RequestParam(value="postCode", required=false) Integer postCode,
                         @RequestParam(value="address", required=false) String address,
                         @RequestParam(value="quality", required=false) Integer quality,
                         @RequestParam(value="menuType", required=false) String menuType, ModelMap model){

        model.addAttribute("nafnVeitingastad", nafnVeitingastad);
        model.addAttribute("postCode", postCode);
        model.addAttribute("address", address);
        model.addAttribute("quality", quality);
        model.addAttribute("menuType", menuType);

        // Passa að við fáum ekki null error
        if(nafnVeitingastad == null) nafnVeitingastad = "";
        if(postCode == null) postCode = -1;
        if(address == null) address = "";
        if(quality == null) quality = -1;
        if(menuType == null) menuType = "";

        // Setjum niðurstöður leitarinnar í lista og setjum hann í model
        //
        ArrayList<Restaurants> listi;
        listi = (ArrayList<Restaurants>) restaurantsService.findAllMatches(nafnVeitingastad, postCode, address, quality, menuType);
        model.addAttribute("listi", listi);


        // Sýna leitarniðurstöður á searchPage (í vinnslu)
        //ArrayList<Restaurants> nameList;
        //nameList = (ArrayList <Restaurants>) restaurantsService.findByName("%" + nafnVeitingastad + "%");

        //model.addAttribute("listi", nameList);

        return "searchResults";
    }
}