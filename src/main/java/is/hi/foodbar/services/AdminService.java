package is.hi.foodbar.services;

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
import org.springframework.stereotype.Service;

/**
 *
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Service
public class AdminService {

    /**
     * add user/admin
     */
    User addAdmin(String username, String password);

    /**
     * Skilar true ef það er í repository, annars false
     *
     * @param admin
     * @param password
     * @return true or false
     */
    boolean isUserInDatabase(String username, String password);

    /**
     * Skilar admin útfrá admin og lykilorði
     *
     * @param admin
     * @param password
     * @return
     */
    User getUser(String username, Sting password);

    /**
     * nær í notanda útfrá nafni
     *
     * @param admin
     * @return
     */
    User getUserByName(Sting username);

    /**
     * checks if username already exists, returns true or false
     * @param username
     * @return true if username exists, else false
     */
    boolean isUsernameFree(String username);

}
