package is.hi.foodbar.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * OpeningTimes geymir upplýsingar um opnunartíma veitingastaða
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date november 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@Entity
@Table(name = "restaurant_open")
public class OpeningTimes {

    // Skilgrein id sem auðkenni (e. identity)  hlutarins
    @Id
    @Column(name = "openId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mondayOpen = -1;
    private int mondayClosed = -1;
    private int tuesdayOpen = -1;
    private int tuesdayClosed = -1;
    private int wednesdayOpen = -1;
    private int wednesdayClosed = -1;
    private int thursdayOpen = -1;
    private int thursdayClosed = -1;
    private int fridayOpen = -1;
    private int fridayClosed = -1;
    private int saturdayOpen = -1;
    private int saturdayClosed = -1;
    private int sundayOpen = -1;
    private int sundayClosed = -1;

    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name = "restaurantId")
    private Restaurants restaurants;

    public OpeningTimes(){}

    public OpeningTimes(int mondayOpen, int mondayClosed, int tuesdayOpen, int tuesdayClosed, int wednesdayOpen,
                        int wednesdayClosed, int thursdayOpen, int thursdayClosed, int fridayOpen, int fridayClosed,
                        int saturdayOpen, int saturdayClosed, int sundayOpen, int sundayClosed,
                        Restaurants restaurants) {
        this.mondayOpen = mondayOpen;
        this.mondayClosed = mondayClosed;
        this.tuesdayOpen = tuesdayOpen;
        this.tuesdayClosed = tuesdayClosed;
        this.wednesdayOpen = wednesdayOpen;
        this.wednesdayClosed = wednesdayClosed;
        this.thursdayOpen = thursdayOpen;
        this.thursdayClosed = thursdayClosed;
        this.fridayOpen = fridayOpen;
        this.fridayClosed = fridayClosed;
        this.saturdayOpen = saturdayOpen;
        this.saturdayClosed = saturdayClosed;
        this.sundayOpen = sundayOpen;
        this.sundayClosed = sundayClosed;
        this.restaurants = restaurants;
    }

    /**
     * Athugar hvort að veitingastaðurinn er opinn núna
     *
     * @return boolean gildi sem er satt ef það er opið en ósatt ef lokað
     */
    public boolean isOpen() {
        // Make a new Date object. It will be initialized to the
        // current time.
        Date now = new Date();
        int currentTime = -2;

        SimpleDateFormat clock = new SimpleDateFormat("HHmm"); // time of day as 4 numbers e.g. 1030

        // Get the day of week as a number 1 is sunday
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(" clock " + clock.format(now));
        System.out.println(" day " + day);

        try {
            currentTime = Integer.parseInt(clock.format(now)); // get current time as 4 digit int
        } catch (NumberFormatException e) {
            System.out.println(" Whoops time broke?");
        }

        switch (day) {
            case 1: // sunday
                if(sundayOpen <= currentTime && sundayClosed >= currentTime)
                    return true;
                break;
            case 2: // monday
                if(mondayOpen <= currentTime && mondayClosed >= currentTime)
                    return true;
                break;
            case 3: // tuesday
                if(tuesdayOpen <= currentTime && tuesdayClosed >= currentTime)
                    return true;
                break;
            case 4: // wednesday
                if(wednesdayOpen <= currentTime && wednesdayClosed >= currentTime)
                    return true;
                break;
            case 5: // thursday
                if(thursdayOpen <= currentTime && thursdayClosed >= currentTime)
                    return true;
                break;
            case 6: // friday
                if(fridayOpen <= currentTime && fridayClosed >= currentTime)
                    return true;
                break;
            case 7: // saturday
                if(saturdayOpen <= currentTime && saturdayClosed >= currentTime)
                    return true;
                break;
            default:
                break;
        }

        return false;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getMondayOpen() {
        return mondayOpen;
    }

    public void setMondayOpen(int mondayOpen) {
        this.mondayOpen = mondayOpen;
    }

    public int getMondayClosed() {
        return mondayClosed;
    }

    public void setMondayClosed(int mondayClosed) {
        this.mondayClosed = mondayClosed;
    }

    public int getTuesdayOpen() {
        return tuesdayOpen;
    }

    public void setTuesdayOpen(int tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }

    public int getTuesdayClosed() {
        return tuesdayClosed;
    }

    public void setTuesdayClosed(int tuesdayClosed) {
        this.tuesdayClosed = tuesdayClosed;
    }

    public int getWednesdayOpen() {
        return wednesdayOpen;
    }

    public void setWednesdayOpen(int wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }

    public int getWednesdayClosed() {
        return wednesdayClosed;
    }

    public void setWednesdayClosed(int wednesdayClosed) {
        this.wednesdayClosed = wednesdayClosed;
    }

    public int getThursdayOpen() {
        return thursdayOpen;
    }

    public void setThursdayOpen(int thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }

    public int getThursdayClosed() {
        return thursdayClosed;
    }

    public void setThursdayClosed(int thursdayClosed) {
        this.thursdayClosed = thursdayClosed;
    }

    public int getFridayOpen() {
        return fridayOpen;
    }

    public void setFridayOpen(int fridayOpen) {
        this.fridayOpen = fridayOpen;
    }

    public int getFridayClosed() {
        return fridayClosed;
    }

    public void setFridayClosed(int fridayClosed) {
        this.fridayClosed = fridayClosed;
    }

    public int getSaturdayOpen() {
        return saturdayOpen;
    }

    public void setSaturdayOpen(int saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }

    public int getSaturdayClosed() {
        return saturdayClosed;
    }

    public void setSaturdayClosed(int saturdayClosed) {
        this.saturdayClosed = saturdayClosed;
    }

    public int getSundayOpen() {
        return sundayOpen;
    }

    public void setSundayOpen(int sundayOpen) {
        this.sundayOpen = sundayOpen;
    }

    public int getSundayClosed() {
        return sundayClosed;
    }

    public void setSundayClosed(int sundayClosed) {
        this.sundayClosed = sundayClosed;
    }

    public Restaurants getRestaurant() {
        return restaurants;
    }
    public void setRestaurant(Restaurants restaurant) {
        this.restaurants = restaurant;
    }

    /**
     * Aðferð til þess að breyta tímum úr 4 sæta (eða færri) tölu yfir á formið hh:mm
     * @param num tíminn sem 4 sæta (eða færri) tala
     * @return Strengur sem inniheldur tíma á forminu hh:mm
     */
    private String formatNum(int num) {
        String number = ""+num;
        String s = "";
        char[] digits = number.toCharArray();
        if(digits.length > 4) return s;
        if(digits.length == 4) {
            s = ""+digits[0]+digits[1]+":"+digits[2]+digits[3];
        } else if(digits.length == 3) {
            s = "0"+digits[0]+":"+digits[1]+digits[2];
        } else if(digits.length == 2) {
            s = "00:"+digits[0]+digits[1];
        } else {
            s = "00:0"+num;
        }
        return s;
    }

    @Override
    public String toString() {
        return "Mon: "+formatNum(mondayOpen)+"-"+formatNum(mondayClosed)+
                " Tue: "+formatNum(tuesdayOpen)+"-"+formatNum(tuesdayClosed)+
                " Wed: "+formatNum(wednesdayOpen)+"-"+formatNum(wednesdayClosed)+
                " Thu: "+formatNum(tuesdayOpen)+"-"+formatNum(thursdayClosed)+
                " Fri: "+formatNum(fridayOpen)+"-"+formatNum(fridayClosed)+
                " Sat: "+formatNum(saturdayOpen)+"-"+formatNum(saturdayClosed)+
                " Sun: "+formatNum(sundayOpen)+"-"+formatNum(sundayClosed);
    }
}
