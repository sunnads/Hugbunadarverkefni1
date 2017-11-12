package is.hi.foodbar.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Resturant geymir upplýsingar um veitingastaðinna
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @author Brynja Pálína Sigurgeirsdóttir, bps5@hi.is
 * @date september 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */

@Entity
@Table (name="restaurants")
public class Restaurants {

    // Skilgrein id sem auðkenni (e. identity)  hlutarins
    @Id
    @Column(name = "restaurantsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull(message = "Settu inn nafn veitingarstaðs")
    //@Size(min=1, max=100, message="Settu inn nafn veitingarstaðs")
    private String name; // nafn á veitingastað

    //@NotNull(message = "Settu inn heimilisfang veitingarstaðs")
    //@Size(min=1, max=100, message="Settu inn heimilisfang veitingarstaðs")
    private String address; // heimilisfang veitingarstaðar

    //@Min(value=100, message = "Póstnúmer verður að vera þrír stafir ")
    //@Max(value=999, message = "Póstnúmer verður að vera þrír stafir ")
    private int postCode; // póstnúmer á staðsetningu veitingastaðar

    //@Min(value=1000000, message = "Símanúmer verður að vera sjö stafir ")
    //@Max(value=9999999, message = "Símanúmer verður að vera sjö stafir ")
    private int phoneNumber; // síma númer veitingastaðar

    private int quality; // gæða staðall veitingastaðar

    @OneToMany(mappedBy = "restaurants", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Type> type = new HashSet<Type>(); // tengund veitingastaðar

    @OneToMany(mappedBy = "restaurants", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuType> menuType = new HashSet<MenuType>(); // morgun-, hádeigs-  og kvöldmatar seðill
    private String openingTime; // opnunartímar veitingastaðar
    private String closingTime; // lokunartímar veitingastaðar

    public Restaurants(){}

    public Restaurants ( String name, int postCode, String address, int phoneNumber,
                        int quality, Set<Type> type, Set<MenuType> menuType, String openingTime,
                         String closingTime){

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
    public void setName(String name) { this.name = name; }

    public int getPostCode() {
        return postCode;
    }
    public void setPostCode(int postCode) { this.postCode = postCode; }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) { this.address = address; }

    public int getPhoneNumber() { return phoneNumber;}
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getQuality() {
        return quality;
    }
    public void setQuality(int quality) { this.quality = quality; }

    public Set<Type> getType() {
        return type;
    }

    public void setType(String typeName) {
        Type ty = new Type(typeName,this);
        addType(ty);
    }

    /**
     * Bætir tegund við vetingastaðinn
     *
     * @param t tegundin sem á að bæta við
     */
    public void addType(Type t) {
        t.setRestaurant(this);
        type.add(t);
    }

    public Set<MenuType> getMenuType() {return menuType;}
    public void setMenuType(String menuName) {
        MenuType menu = new MenuType(menuName,this);
        addMenuType(menu);
    }

    /**
     * Bætir matseðli við vetingastaðinn
     *
     * @param m matseðillinn sem á að bæta við
     */
    public void addMenuType(MenuType m) {
        m.setRestaurant(this);
        menuType.add(m);
    }

    public String getOpeningTime() {
        return openingTime;
    }
    public void setOpeningTime(String openingTime) { this.openingTime = openingTime; }

    public String getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(String closingTime) { this.closingTime = closingTime; }

    @Override
    public String toString() {
        return String.format("<BR>" + "nafn: "+ name + "<BR>" +"heimilisfang: "+ address);
    }
}