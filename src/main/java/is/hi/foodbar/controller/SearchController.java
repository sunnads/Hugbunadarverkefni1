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
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun.
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date september 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Controller
//@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir
public class SearchController {

    @Autowired
    RestaurantsService restaurantsService;

    /**
     * Birtir indexPage.jsp í viðmótinu.
     * Þar er leitin fyrir veitingastaði birt
     *
     * @return slóðin á skránna indexPage.jsp
     */
    // Þar sem klasinn hefur enga slóð, er þessi slóð "/index"
    @RequestMapping("/index")
    public String indexPage(){
        return "view/indexPage"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/view/indexPage.jsp
        // skoðið application.properties til að sjá hvernig slóðin er sett
    }

    /**
     * Notar POST til að ná í upplýsingar frá notanda og setja þær í model.
     * Kallar á searchResturant(...) og setur niðurstöðurnar í lista.
     *
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggann
     * @param postCode Integer sem inniheldur það sem notandi valdi fyrir póstnúmer
     * @param address Strengur sem inniheldur það sem notandi skrifaði í address gluggan
     * @param quality Integer sem inniheldur það sem notandi valdi fyrir gæðastaðal
     * @param menuType Integer sem inniheldur það sem notandi valdi fyrir matseðil
     * @param model Modelið sem við notum
     * @return Strengur sem inniheldur slóð á síðuna sem á að birta
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

        System.out.println(address);

        if(nafnVeitingastad == null) nafnVeitingastad = "";
        if(postCode == null) postCode = -1;
        if(address == null) address = "";
        if(quality == null) quality = -1;
        if(menuType == null) menuType = "";



        ArrayList<Restaurants> nameList;
        nameList = (ArrayList <Restaurants>) restaurantsService.findByName("%" + nafnVeitingastad + "%");

        model.addAttribute("listi", nameList);

       // ArrayList<Restaurants> resultList = restaurantsService.searchRestaurant(nafnVeitingastad, postCode, address, quality, menuType);
      //  model.addAttribute("listi", resultList);
        return "view/searchPage";
    }

    /**
     * Hjálparfall til að athuga hvort það var leitað að einhverju af týpunum í listanum.
     *
     * @param rList listinn inniheldur Resturant object sem verið er að prófa á móti
     * @param i heiltala sem segir okkur hvar í listanum rList við erum komin
     * @param test menu type sem verið er að athuga hvort hún sé í listanum í Resturant objectinu
     * @return boolean gildi sem segir okkur hvort við fundum það sem var leitað að
     */
    /*
    private boolean testArrayListMenuType(ArrayList<Resturants> rList, int i, String test) {
        for (int j = 0; j < rList.get(i).getMenuType().size(); j++) {
            if (rList.get(i).getMenuType().get(j).equals(test)) {
                return true;
            }
        }
        return false;
    }
*/

}