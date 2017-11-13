package is.hi.foodbar.model;

import javax.persistence.*;
import java.util.ArrayList;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User geymir upplýsingar um notendurnar (adminana)
 * og setur það í tölfu í gagnagrunni
 *
 * @author Sunna Dröfn Sigfúsdóttir, sds21@hi.is
 * @date nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

@Entity
@Table(name = "FoodbarUser")
public class User {
    /**
     * pimary key of user
     */
    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 8, message = "Lykilorðið verður að vera að minstakosti {min} stafir.")
    private @SQLInjectionSafe String password; // user password string that holds the password

    @NotNull
    @Column(unique = true)
    @Size(min = 1, message = "Notendanafn má ekki vera tómt")
    private @SQLInjectionSafe String username; // user name e.g. ebba12

    public User(){}

    /**
     *
     * @param password
     * @param username
     */
    public User(String password, String username){
        this.password = password;
        this.username = username;
    }

    public User(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int uid) {
        this.id = uid;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "username",unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}