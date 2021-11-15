/**
 * Realestate klassen som inneholder eiendom og all detaljene
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
     * Konstruktør for Realestate klassen.
     * Lager ny eiendom.
     * @param municipalityNumber Kommunenummer
     * @param municipalityName Kommunenavn
     * @param lotNumber Gårdsnummer
     * @param sectionNumber Bruksnummer
     * @param name Bruksnavn (valgfritt), hvis eiendommen ikke har navn, blir denne satt til en tom string
     * @param area Areal i m2
     * @param ownerName Navn på eier
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

    @Override
    public String toString() {
        return "----Eiendom---- \n" +
                "Kommunenummer: " + municipalityNumber + "\n" +
                "Kommunenavn: " + municipalityName + "\n" +
                "Gårdsnummer: " + lotNumber + "\n" +
                "Bruksnummer: " + sectionNumber  + "\n" +
                "Bruksnavn: " + name + "\n" +
                "Areal i m2: " + area + "\n" +
                "Navn på eier: " + ownerName + "\n";
    }

    /**
     * Jeg har valgt å ikke inkludere mutator-metodene fordi det skal ikke være mulig å endre på
     * realestate objektet i etterkant, de forskjellige parametere skal kun settes i konstruktøren.
     */
}
