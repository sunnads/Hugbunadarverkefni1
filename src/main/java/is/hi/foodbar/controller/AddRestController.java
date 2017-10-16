package is.hi.foodbar.controller;

import is.hi.foodbar.model.Restaurants;
import java.util.ArrayList;
import is.hi.foodbar.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    RestaurantsService restaurantService;

    /**
     * Tekur við nafni, postcode, heimilisfangi, símanúmeri, gæðakröfu, tegund, matseðli,
     * opnunar- og lokunartímum og bætir við veitingastað með þessum upplýsingum.
     *
     * @param name Nafn á veitingastað
     * @param postCode Póstnúmer veitingastaðs
     * @param address Heimilisfang veitingastaðs
     * @param phoneNumber Símanúmer veitingastaðs
     * @param quality Gæðiskrafa veitingastaðs
     * @param type Tegund veitingastaðs
     * @param menuType Matseðill veitingastaðs
     * @param open Opnunartími veitingastaðs
     * @param closed Lokunartími veitingastaðs
     * @param model Módel með attributum
     * @return vefsíðu sem birtir upplýsingar um veitingastað sem bætt var við
     */
    @RequestMapping("/addedRest")
    public String addRestaurant(@RequestParam(value="addNameRest", required=false) String name,
                                @RequestParam(value="addPostCode", required=false) Integer postCode,
                                @RequestParam(value="addAddress", required=false) String address,
                                @RequestParam(value="addNumber", required=false) Integer phoneNumber,
                                @RequestParam(value="addQuality", required=false) Integer quality,
                                @RequestParam(value="addType", required=false) ArrayList<String> type,
                                @RequestParam(value="addMenuType", required=false) ArrayList<String> menuType,
                                @RequestParam(value="addOpenMon", required=false) int[] open,
                                @RequestParam(value="addCloseMon", required=false) int[] closed,
                                ModelMap model){
        Restaurants r = new Restaurants(name, postCode, address, phoneNumber, quality, type, menuType, open, closed);
        model.addAttribute("restaurants", r);
        restaurantService.addRestaurant(r);

        return "view/addedRestPage";
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
        return "view/restaurantListPage";
    }

    /**
     * Birtir admin innskráningu
     *
     * @return síða fyrir admin innskráningu
     */
    @RequestMapping("/admin")
    public String admin(){
        return "view/adminPage";
    }

    /**
     * Birtir síðu þar sem hægt er að slá inn upplýsingar fyrir veitingastað
     * og bæta honum í gagnagrunn.
     *
     * @return síða þar sem hægt er að bæta við veitingastað
     */
    @RequestMapping("/addRestaurant")
    public String addRestaurant(){
        return "view/addRestaurantPage";
    }

//
//    /**
//     * Býður sama notandanum góðan daginn
//     *
//     * @param model
//     * @return vefsíðu sem býður notanda góðan daginn
//     */
//    @RequestMapping("/notandi")
//    public String notandi(Model model) {
//        model.addAttribute("nafn", "Ebba Þóra");
//        return "demo/synaNotandi";
//    }
//
//    /**
//     * Spyr hvað notandinn heitir
//     *
//     * @return vefsíða með spurningu
//     */
//    @RequestMapping("/spyrjaNotanda")
//    public String spyrjaNotandi() {
//        return "demo/hvadaNotandi";
//    }
//
//    /**
//     * Tekur við nafni frá notanda og birtir Góðan daginn nafn ef nafnið er á
//     * réttu sniði annars birtir það villumeldingu
//     *
//     * @param nafn Nafn á notanda
//     * @param heimilisfang Heimilisfang notanda
//     * @param model Módel með attributum
//     * @return vefsíðu sem birtir góðan daginn nafn
//     */
//    @RequestMapping(value = "/hver", method = RequestMethod.POST)
//    public String hver(@RequestParam(value = "nafn", required = false) String nafn,
//                       @RequestParam(value = "heimilisfang", required = false) String heimilisfang,
//                       ModelMap model) {
//
//        if (daginnService.erNafnRett(nafn)) {
//            Kennari k = new Kennari(nafn, heimilisfang);
//            model.addAttribute("kennari", k);
//            daginnService.addKennari(k);
//            return "demo/synaKennari";
//        } else {
//            return "demo/rangtNafn";
//        }
//    }
//
//
//    /**
//     * Tekur við nafni frá notanda og birtir Góðan daginn nafn ef nafnið er á
//     * réttu sniði annars birtir það villumeldingu
//     *
//     * @param nafn Nafn á notanda
//     * @param heimilisfang Heimilisfang notanda
//     * @param model Módel með attributum
//     * @return vefsíðu sem birtir góðan daginn nafn
//     */
//    @RequestMapping(value = "/hverKennari", method = RequestMethod.POST)
//    public String hverKennari(@ModelAttribute("kennari") Kennari k,
//                              ModelMap model) {
//
//        if (daginnService.erNafnRett(k.getNafn())) {
//            model.addAttribute("kennari", k);
//            daginnService.addKennari(k);
//            return "demo/synaKennari";
//        } else {
//            return "demo/rangtNafn";
//        }
//    }
//    /**
//     * Birtir lista af kennurum
//     *
//     * @param model módel fyrir samskipti við viðmót
//     * @return vefsíðu með lista af kennurum
//     */
//    @RequestMapping(value = "/listiKennara", method = RequestMethod.GET)
//    public String listiKennara(Model model) {
//        ArrayList<Kennari> listi;
//        listi = (ArrayList<Kennari>) daginnService.allirKennarar();
//        model.addAttribute("kennarar", listi);
//        return "demo/allirKennarar";
//    }
//
//    /**
//     * Birtir lista af kennurum með nafn lengra en 3 stafir
//     *
//     * @param model módel fyrir samskipti við viðmót
//     * @return vefsíðu með lista af kennurum
//     */
//    @RequestMapping(value = "/listiKennara3", method = RequestMethod.GET)
//    public String listiKennara3Nafn(Model model) {
//        ArrayList<Kennari> listi;
//        listi = (ArrayList<Kennari>) daginnService.finnaAlla3Stafi();
//        model.addAttribute("kennarar", listi);
//        return "demo/allirKennarar";
//    }
}
