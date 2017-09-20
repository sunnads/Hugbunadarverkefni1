package is.hi.foodbar.controller;

import is.hi.foodbar.model.Resturants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayList<Resturants> resturantList() {
        ArrayList<Resturants> rList = new ArrayList<Resturants>();

        Resturants dominos = new Resturants( "Dominos", new ArrayList<Integer>(Arrays.asList(101,107,105)),
                new ArrayList<String>(Arrays.asList("Skúlagata", "Hjarðarhaga", "Skeifan")) , 5812345,
                1, new ArrayList<String>(Arrays.asList("Pizzastaður","Skyndibiti")), new String[] {"Kvöldmatur", "Hádeigismatur"},
                new int[] {1100,1100,1100, 1100, 1000, 1300, 1300 }, new int[] {2200,2200,2200,2200,2400,2400,2200});

        rList.add(dominos);

        Resturants hornid = new Resturants( "Hornið", new ArrayList<Integer>(Arrays.asList(101)),
                new ArrayList<String>(Arrays.asList("Niðr í bæ ")) , 5854327,
                3, new ArrayList<String>(Arrays.asList("Pizzastaður","Pastastaður")), new String[] {"Kvöldmatur", "Hádeigismatur","Kaffi og kökur"},
                new int[] {1000,1000,1000,1000,900,800,800}, new int[] {2000,2000,2000,2200,130,130,2100});

        rList.add(hornid);

        Resturants tokyoSushi = new Resturants( "Tokyo Sushi", new ArrayList<Integer>(Arrays.asList(200)),
                new ArrayList<String>(Arrays.asList("Nýbílavegur")) , 5935748,
                1, new ArrayList<String>(Arrays.asList("Sushi","Skyndibiti")), new String[] {"Kvöldmatur", "Hádeigismatur"},
                new int[] {1100,1100,1100,1100,1300,1400,1400}, new int[] {2100,2100,2100,2100,2130,2330,2330});

        rList.add(tokyoSushi);

        Resturants gamlaKaffihusid = new Resturants( "Gamla Kaffihúsið", new ArrayList<Integer>(Arrays.asList(111)),
                new ArrayList<String>(Arrays.asList("Drafnarfell 18")) , 5111180,
                3, new ArrayList<String>(Arrays.asList("Margréttað", " Hamborgarar", "Taka með")),
                new String[] {"Morgunmatur", "Kvöldmatur", "Hádeigismatur","Kaffi og kökur"},
                new int[] {1000,1000,1000,1000,1000,1200,1200}, new int[] {2200,2200,2200,2200,2200,2200,2100});

        rList.add(gamlaKaffihusid);

        Resturants caruso = new Resturants( "Caruso", new ArrayList<Integer>(Arrays.asList(101)),
                new ArrayList<String>(Arrays.asList("Austurstræti 22")) , 5627335,
                5, new ArrayList<String>(Arrays.asList("Pizzastaður","Skyndibiti")), new String[] {"Kvöldmatur", "Hádeigismatur"},
                new int[] {1130,1130,1130,1130,1130,1200,1700}, new int[] {2230,2230,2230,2230,2230,2230,2200});

        rList.add(caruso);

        return rList;
    }


    /**
     * Birtir demo.jsp í viðmótinu.
     * Þar er textinn "Sýnidæmi" birtur.
     *
     * @return slóðin á skránna demo.jsp
     */
    // Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/page"
    @RequestMapping("/page")
    public String demoPage(){
        return "demo/demo"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/demo.jsp
        // skoðið application.properties til að sjá hvernig slóðin er sett
    }

    /**
     * Birtir synaNotandi.jsp í viðmótinu.
     * Þar er textinn "Góðan daginn notandi" birtur.
     *
     * @param model modelið sem er notað til að færa gögnin frá controller til viðmóts
     * @return slóðin á skránna synaNotandi.jsp
     */
    @RequestMapping("/notandi")
    public String notandi(Model model){
        model.addAttribute("nafn", "notandi");
        return "demo/synaNotandi";
    }

    /**
     * Birtir hvadaNotandi.jsp í viðmótinu.
     * Þar er notandi beðinn um að sla inn nafnið sitt.
     *
     * @return slóðin á skránna hvadaNotandi.jsp
     */
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi(){
        return "demo/hvadaNotandi";
    }

    /**
     * Notar POST til að setja nafnið úr hvadaNotandi í synaNotandi.
     *
     * @param nafn strengurinn sem inniheldur það sem notandi sló inn í spyrjaNotanda forminu
     * @param model modelið sem er notað til að færa gögnin milli controller og viðmóts
     * @return slóðin á skránna synaNotandi.jsp
     */
    @RequestMapping(value="/hver", method=RequestMethod.POST)
    public String hver(@RequestParam(value="nafn", required=false) String nafn, ModelMap model){
        model.addAttribute("nafn", nafn);
        return "demo/synaNotandi";
    }


    /**
     * Birtir indexPage.jsp í viðmótinu.
     * Þar er leitin fyrir veitingastaði birt
     *
     * @return slóðin á skránna indexPage.jsp
     */
    // Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/page"
    @RequestMapping("/index")
    public String indexPage(){
        return "view/indexPage"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/demo.jsp
        // skoðið application.properties til að sjá hvernig slóðin er sett
    }

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam(value="nafnVeitingastad", required=false) String nafnVeitingastad, ModelMap model){
        model.addAttribute("nafnVeitingastad", nafnVeitingastad);
        ArrayList<Resturants> resultList = searchResturant(nafnVeitingastad);
        model.addAttribute("listi", resultList);
        return "view/searchPage";
    }

    private ArrayList<Resturants> searchResturant(String nafnVeitingastad) {
        ArrayList<Resturants> rList = resturantList(); // seina kalla á gagnagrun
        ArrayList<Resturants> resultList = new ArrayList<Resturants>();

        for (int i = 0; i < rList.size(); i++) {
            if(rList.get(i).getName().equals(nafnVeitingastad) ) {
                System.out.println("Hallo virkar ég ? ");
                resultList.add(rList.get(i));
            }
        }
        return resultList;
    }
}
