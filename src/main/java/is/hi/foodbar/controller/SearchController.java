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

    /**
     * Fake gagnagrunnur
     *
     * @return listi af Resturants objectum
     */
    private ArrayList<Resturants> resturantList() {
        ArrayList<Resturants> rList = new ArrayList<Resturants>();

        Resturants dominos = new Resturants( "Dominos", 101,"Skeifan", 5812345,
                1, new ArrayList<String>(Arrays.asList("Pizzastaður","Skyndibiti")),
                new ArrayList<String>(Arrays.asList("Kvöldmatur", "Hádeigismatur")),
                new int[] {1100,1100,1100, 1100, 1000, 1300, 1300 }, new int[] {2200,2200,2200,2200,2400,2400,2200});

        rList.add(dominos);

        Resturants hornid = new Resturants( "Hornið",101,
                "Niðr í bæ " , 5854327,
                3, new ArrayList<String>(Arrays.asList("Pizzastaður","Pastastaður")),
                new ArrayList<String>(Arrays.asList("Kvöldmatur", "Hádeigismatur","Kaffi og kökur")),
                new int[] {1000,1000,1000,1000,900,800,800}, new int[] {2000,2000,2000,2200,130,130,2100});

        rList.add(hornid);

        Resturants tokyoSushi = new Resturants( "Tokyo Sushi",200,
                "Nýbílavegur" , 5935748,
                1, new ArrayList<String>(Arrays.asList("Sushi","Skyndibiti")),
                new ArrayList<String>(Arrays.asList("Kvöldmatur", "Hádeigismatur")),
                new int[] {1100,1100,1100,1100,1300,1400,1400}, new int[] {2100,2100,2100,2100,2130,2330,2330});

        rList.add(tokyoSushi);
/*
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
*/
        return rList;
    }


    /**
     * Birtir demo.jsp í viðmótinu.
     * Þar er textinn "Sýnidæmi" birtur.
     *
     * @return slóðin á skránna demo.jsp
     */
    /*
    // Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/page"
    @RequestMapping("/page")
    public String demoPage(){
        return "demo/demo"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/demo.jsp
        // skoðið application.properties til að sjá hvernig slóðin er sett
    }
    */

    /**
     * Birtir synaNotandi.jsp í viðmótinu.
     * Þar er textinn "Góðan daginn notandi" birtur.
     *
     * @param model modelið sem er notað til að færa gögnin frá controller til viðmóts
     * @return slóðin á skránna synaNotandi.jsp
     */
    /*
    @RequestMapping("/notandi")
    public String notandi(Model model){
        model.addAttribute("nafn", "notandi");
        return "demo/synaNotandi";
    }
    */

    /**
     * Birtir hvadaNotandi.jsp í viðmótinu.
     * Þar er notandi beðinn um að sla inn nafnið sitt.
     *
     * @return slóðin á skránna hvadaNotandi.jsp
     */
    /*
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi(){
        return "demo/hvadaNotandi";
    }
    */

    /**
     * Notar POST til að setja nafnið úr hvadaNotandi í synaNotandi.
     *
     * @param nafn strengurinn sem inniheldur það sem notandi sló inn í spyrjaNotanda forminu
     * @param model modelið sem er notað til að færa gögnin milli controller og viðmóts
     * @return slóðin á skránna synaNotandi.jsp
     */
    /*
    @RequestMapping(value="/hver", method=RequestMethod.POST)
    public String hver(@RequestParam(value="nafn", required=false) String nafn, ModelMap model){
        model.addAttribute("nafn", nafn);
        return "demo/synaNotandi";
    }
    */


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
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggan
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

        ArrayList<Resturants> resultList = searchResturant(nafnVeitingastad, postCode, address, quality, menuType);
        model.addAttribute("listi", resultList);
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
    private boolean testArrayListMenuType(ArrayList<Resturants> rList, int i, String test) {
        for (int j = 0; j < rList.get(i).getMenuType().size(); j++) {
            if (rList.get(i).getMenuType().get(j).equals(test)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Fallið ber saman það sem notandi valdi/skrifaði inn í gluggan og það sem er í Resturants objectunum okkar,
     * þ.e. leitar að því sem notandi vildi finna.
     *
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggan
     * @param postCode Integer sem inniheldur það sem notandi valdi fyrir póstnúmer
     * @param address Strengur sem inniheldur það sem notandi skrifaði í address gluggan
     * @param quality Integer sem inniheldur það sem notandi valdi fyrir gæðastaðal
     * @param menuType Integer sem inniheldur það sem notandi valdi fyrir matseðil
     * @return Listi af öllum Resturants sem passa við það sem notandi leitaði að
     */
    private ArrayList<Resturants> searchResturant(String nafnVeitingastad, int postCode, String address,
                                                  int quality, String menuType) {
        ArrayList<Resturants> rList = resturantList(); // seinna kalla á gagnagrunn
        ArrayList<Resturants> resultList = new ArrayList<Resturants>();

        for (int i = 0; i < rList.size(); i++) {
            if(rList.get(i).getName().equals(nafnVeitingastad) ) {
                resultList.add(rList.get(i));
            }

            else if (rList.get(i).getPostCode() == postCode) {
                resultList.add(rList.get(i));
            }
            else if (rList.get(i).getAddress().equals(address)) {
                resultList.add(rList.get(i));
            }

            else if (rList.get(i).getQuality() == quality) {
                resultList.add(rList.get(i));
            }

            else if (testArrayListMenuType(rList, i, menuType)) {
                resultList.add(rList.get(i));
            }
        }
        return resultList;
    }
}