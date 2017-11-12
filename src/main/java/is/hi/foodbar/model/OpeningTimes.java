package is.hi.foodbar.model;


import javax.persistence.*;

/**
 * Type geymir upplýsingar um tegundir af veitingastöðum
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date november 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Entity
@Table(name = "restaurant_types")
public class OpeningTimes {

    // Skilgrein id sem auðkenni (e. identity)  hlutarins
    @Id
    @Column(name = "typeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name = "restaurantId")
    private Restaurants restaurants;

    public OpeningTimes(){}

    public OpeningTimes(String name, Restaurants restaurant) {
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
