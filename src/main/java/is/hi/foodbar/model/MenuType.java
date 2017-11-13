package is.hi.foodbar.model;


import javax.persistence.*;

/**
 * MenuType geymir upplýsingar um matseðil veitingastaðar
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date november 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Entity
@Table(name = "restaurant_menus")
public class MenuType {

    // Skilgrein id sem auðkenni (e. identity)  hlutarins
    @Id
    @Column(name = "menuId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name = "restaurantId")
    private Restaurants restaurants;

    public MenuType(){}

    public MenuType(String name, Restaurants restaurant) {
        this.name = name;
        this.restaurants = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurants getRestaurant() {
        return restaurants;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurants = restaurant;
    }

    @Override
    public String toString() {
        return name;
    }
}
