/**
 * Class Realestate
 * @version 0.1 2021-11-15
 * @Author Katarzyna Szlejter
 */

public class Realestate {

    private final int municipalityNumber;

    private final String municipalityName;

    private final int lotNumber;

    private final int sectionNumber;

    private final String name;

    private final double area;

    private final String ownerName;

    /**
     * Constructor for class Realestate
     * @param municipalityNumber
     * @param municipalityName
     * @param lotNumber
     * @param sectionNumber
     * @param name
     * @param area
     * @param ownerName
     */
    public Realestate(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String ownerName) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.ownerName = ownerName;
    }

    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Returns unique number consisting of municipality number, lot number and section number.
     * @return String in following format municipality number - lot number / section number
     */
    public String getUniqueID() {
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    @Override
    public String toString() {
        return "Realestate{" +
                "municipalityNumber=" + municipalityNumber +
                ", municipalityName='" + municipalityName + '\'' +
                ", lotNumber=" + lotNumber +
                ", sectionNumber=" + sectionNumber +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    /**
     * Jeg har valgt å ikke inkludere mutator-metodene fordi det skal ikke være mulig å endre på
     * realestate objektet i etterkant, de forskjellige parametere skal kun settes i konstruktøren.
     */
}
