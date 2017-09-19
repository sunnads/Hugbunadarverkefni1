package is.hi.foodbar.model;

/**
 * Resturant classi sem geymir upplýsingar um veitingastaðinna
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @author Karítas Sif Halldórsdóttir, ksh18@hi.is
 * @date september 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
public class Resturants {


    private String name; // nafn á veitingastað
    private int[] postCode; // póstnúmer á staðsetningu veitingastaðar
    private String[] address; // heimilisfang veitingarstaðar
    private int phoneNumber; // síma númer veitingastaðar
    private int quality; // gæða staðall veitingastaðar
    private String[] type; // tengund veitingastaðar
    private String[] menuType; // morgun-, hádeigs-  og kvöldmatar seðill
    private int[] openingTime; // opnunartímar veitingastaðar
    private int[] closingTime; // lokunartímar veitingastaðar

    public Resturants ( String name, int[] postCode, String[] address, int phoneNumber,
                        int quality, String[] type, String[] menuType, int[] openingTime,
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

    public int[] getPostCode() {
        return postCode;
    }

    public String[] getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getQuality() {
        return quality;
    }

    public String[] getType() {
        return type;
    }

    public String[] getMenuType() {
        return menuType;
    }

    public int[] getOpeningTime() {
        return openingTime;
    }

    public int[] getClosingTime() {
        return closingTime;
    }
}
