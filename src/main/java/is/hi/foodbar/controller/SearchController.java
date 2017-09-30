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
     * Kallar á  chResturant(...) og setur niðurstöðurnar í lista.
     *
     * @param nafnVeitingastad Strengur sem inniheldur það sem notandi skrifaði í nafn gluggan
     * @param postCode Integer sem inniheldur það sem notandi valdi fyrir póstnúmer
     * @param address Strengur sem inniheldur það sem notandi skrifaði í address gluggan
     * @param quality Integer sem inniheldur það sem notandi valdi fyrir gæðastaðal
     * @param menuType Integer sem inniheldur það sem notandi valdi fyrir matseðil
     * @param openingTime Integer sem inniheldur það sem notandi valdi fyrir opnunartíma
     * @param closingTime Integer sem inniheldur það sem notandi valdi fyrir lokunartíma
     * @param model Modelið sem við notum
     * @return Strengur sem inniheldur slóð á síðuna sem á að birta
     */
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam(value="nafnVeitingastad", required=false) String nafnVeitingastad,
                         @RequestParam(value="postCode", required=false) Integer postCode,
                         @RequestParam(value="address", required=false) String address,
                         @RequestParam(value="quality", required=false) Integer quality,
                         @RequestParam(value="menuType", required=false) Integer menuType,
                         @RequestParam(value="openingTime", required=false) Integer openingTime,
                         @RequestParam(value="closingTime", required=false) Integer closingTime, ModelMap model){

        model.addAttribute("nafnVeitingastad", nafnVeitingastad);
        model.addAttribute("postCode", postCode);
        model.addAttribute("address", address);
        model.addAttribute("quality", quality);
        model.addAttribute("menuType", menuType);
        model.addAttribute("openingTime", openingTime);
        model.addAttribute("closingTime", closingTime);

        System.out.println(address);

        if(nafnVeitingastad == null) nafnVeitingastad = "";
        if(postCode == null) postCode = -1;
        if(address == null) address = "";
        if(quality == null) quality = -1;
        if(menuType == null) menuType = -1;
        if(openingTime == null) openingTime = -1;
        if(closingTime == null) closingTime = -1;

        ArrayList<Resturants> resultList = searchResturant(nafnVeitingastad, postCode, address, quality,
                                                            menuType, openingTime, closingTime);
        model.addAttribute("listi", resultList);
        return "view/searchPage";
    }

    /**
     * Hjálparfall til að athuga hvort það var leitað að einhverju af númerunum í listanum.
     *
     * @param rList listinn inniheldur Resturant object sem verið er að prófa á móti
     * @param i heiltala sem segir okkur hvar í listanum rList við erum komin
     * @param resultList listi af öllum Resturant sem passa við leitarskilyrðin
     * @param test heiltalan sem verið er að athuga hvort hún sé í listanum í Resturant objectinu
     * @return boolean gildi sem segir okkur hvort við fundum það sem var leitað að
     */
    private boolean testArrayListInt(ArrayList<Resturants>  rList, int i,
                                     ArrayList<Resturants> resultList, int test) {
        for (int j = 0; j < rList.get(i).getPostCode().size(); j++) {
            if (rList.get(i).getPostCode().get(j) == test) {    // virkar bara fyrir postCode í bili
                System.out.println("Ég er postCode prufa ");
                return true;
            }
        }
        return false;
    }

    /**
     * Hjálparfall til að athuga hvort það var leitað að einhverju af strengjunum í listanum.
     *
     * @param rList listinn inniheldur Resturant object sem verið er að prófa á móti
     * @param i heiltala sem segir okkur hvar í listanum rList við erum komin
     * @param resultList listi af öllum Resturant sem passa við leitarskilyrðin
     * @param test Strengurinn sem verið er að athuga hvort hún sé í listanum í Resturant objectinu
     * @return boolean gildi sem segir okkur hvort við fundum það sem var leitað að
     */
    private boolean testArrayListString(ArrayList<Resturants>  rList, int i,
                                        ArrayList<Resturants> resultList, String test) {
        for (int j = 0; j < rList.get(i).getPostCode().size(); j++) {
            if (rList.get(i).getAddress().get(j).equals(test)) {   // virkar bara fyrir address í bili
                System.out.println("Ég er postCode prufa ");
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
     * @param openingTime Integer sem inniheldur það sem notandi valdi fyrir opnunartíma
     * @param closingTime Integer sem inniheldur það sem notandi valdi fyrir lokunartíma
     * @return Listi af öllum Resturants sem passa við það sem notandi leitaði að
     */
    private ArrayList<Resturants> searchResturant(String nafnVeitingastad, int postCode, String address,
                                                  int quality, int menuType,
                                                  int openingTime, int closingTime) {
        ArrayList<Resturants> rList = resturantList(); // seinna kalla á gagnagrunn
        ArrayList<Resturants> resultList = new ArrayList<Resturants>();

        for (int i = 0; i < rList.size(); i++) {
            if(rList.get(i).getName().equals(nafnVeitingastad) ) {
                System.out.println(postCode);
                resultList.add(rList.get(i));
            }

            else if (testArrayListInt(rList, i, resultList, postCode)) {
                System.out.println("Ég er postCode prufa ");
                resultList.add(rList.get(i));
            }
            else if (testArrayListString(rList, i, resultList, address)) {
                System.out.println("Ég er addres prufa ");
                resultList.add(rList.get(i));
            }

            else if (rList.get(i).getQuality() == quality) {
                System.out.println("Ég er Quality  prufa ");
                resultList.add(rList.get(i));
            }

            else if (testArrayListInt(rList, i, resultList, menuType)) {
                System.out.println("Ég er menuType prufa ");
                resultList.add(rList.get(i));
            }

            else if (testArrayListInt(rList, i, resultList, openingTime)) {
                System.out.println("Ég er openingTime prufa ");
                resultList.add(rList.get(i));
            }

            else if (testArrayListInt(rList, i, resultList, closingTime)) {
                System.out.println("Ég er closingTime prufa ");
                resultList.add(rList.get(i));
            }
        }
        return resultList;
    }
}
