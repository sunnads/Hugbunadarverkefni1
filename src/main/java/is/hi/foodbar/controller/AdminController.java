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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Response;

/**
 * Birtir admin síðuna til að logga inn og gerir hana örugga
 *
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

@Controller
public class AdminController {

    // Tenging yfir í þjónustu klasa fyrir forritið
    @Autowired
    AdminServiceImp adminService;

    /**
     * Birtir admin innskráningu
     *
     * @return þú ert búin að logga þig inn
     */

    @RequestMapping(value = "signout", method = RequestMethod.GET)
    public String signOut(HttpSession session,Model model){
        session.setAttribute("user",null);
        return "index";
    }

    /**
     *
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String adminForm(HttpSession session, HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (adminService.isUserInDatabase(username, password)) {
            User user = adminService.getUser(username, password);
            //If login successful set the current user
            session.setAttribute("user", user);

            return "adminPage";
        } else {
            throw new Exception("Innskráning vitlaus");
        }
    }

    /**
     * athugar ef loginið er rétt
     *
     * @return boolean gild
     */
    public Boolean isLoginCorrect(String username, String password){
        if(adminService.isUserInDatabase(username, password)){return true;}
        return false;
    }


}