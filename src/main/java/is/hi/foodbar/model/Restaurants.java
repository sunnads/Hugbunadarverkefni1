package is.hi.foodbar.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resturant geymir upplýsingar um veitingastaðinna
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @date september 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

@Entity
@Table (name="restaurants")
public class Restaurants {

    // Skilgrein id sem auðkenni (e. identity)  hlutarins
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // nafn á veitingastað
    private String address; // heimilisfang veitingarstaðar
    private int postCode; // póstnúmer á staðsetningu veitingastaðar
    private int phoneNumber; // síma númer veitingastaðar
    private int quality; // gæða staðall veitingastaðar
    private ArrayList<String> type; // tengund veitingastaðar
    private ArrayList<String> menuType; // morgun-, hádeigs-  og kvöldmatar seðill
    private int[] openingTime; // opnunartímar veitingastaðar
    private int[] closingTime; // lokunartímar veitingastaðar

    protected Restaurants(){}

    public Restaurants ( String name, int postCode, String address, int phoneNumber,
                        int quality, ArrayList<String> type, ArrayList<String> menuType, int[] openingTime,
                        int[] closingTime){

        this.name = name;
        this.postCode = postCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.quality = quality;
        this.type = type;
        this.menuType = menuType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() { return phoneNumber;}

    public int getQuality() {
        return quality;
    }

    public ArrayList<String> getType() {return type; }

    public ArrayList<String> getMenuType() {return menuType;}

    public int[] getOpeningTime() {
        return openingTime;
    }

    public int[] getClosingTime() {
        return closingTime;
    }

    @Override
    public String toString() {
        return String.format("<BR>" + "nafn: "+ name + "<BR>" +"heimilisfang: "+ address);
    }
}