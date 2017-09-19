package is.hi.foodbar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun.
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @version 1.0
 */
@Controller
@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir
public class SearchController {

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

}
