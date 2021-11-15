import java.util.ArrayList;

/**
 * Klasse som inneholder oversikt over alle eiendommene og metoder for å finne/fjerne/legge til ny eiendom.
 */
public class RealestateRegister {

    //Liste over eiendommer. Jeg har valgt å bruke ArrayList fordi da trenger man ikke å spesifisere størrelsen på tabellen på forhånd. Den blir satt dynamisk.
    private ArrayList<Realestate> realestates;

    /**
     * Opprett en ny tom liste av eiendommer
     */
    public RealestateRegister() {
        realestates = new ArrayList<Realestate>();
    }

    /**
     * Metode for å registrere ny eiendom.
     * @param municipalityNumber kommunenummer
     * @param municipalityName kommunenavn
     * @param lotNumber gårdsnummer
     * @param sectionNumber bruksnummer
     * @param name navn på eiendommmen
     * @param area Areal i m2
     * @param ownerName navn på eieren
     * @return info om eiendommen
     */
    public String register(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String ownerName) {

        Realestate Realestate = new Realestate(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, ownerName);
        realestates.add(Realestate);

        return Realestate.toString();
    }

    /**
     * Fjerner eiendommen fra eiendomtabellen basert på den unike kombinasjonen av kommunenummeret, gårdsnummeret og bruksnummeret
     * @param municipalityNumber kommunenummer
     * @param lotNumber gårdsnummer
     * @param sectionNumber bruksnummer
     * @return returnerer true på vellyket fjerning, false hvis det ikke har blitt funnet eiendom med gitt informasjon
     */
    public boolean remove(int municipalityNumber, int lotNumber, int sectionNumber) {
        if (!realestates.isEmpty()) {
            for (int i = 0; i < realestates.size(); i++) {
                if (realestates.get(i).getMunicipalityNumber() == municipalityNumber && realestates.get(i).getLotNumber() == lotNumber && realestates.get(i).getSectionNumber() == sectionNumber) {
                    realestates.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Finn antall eiendommer
     * @return antall eiendommer
     */
    public int getTotalCount() {
        return realestates.size();
    }

    /**
     * Hent alle eiendommene
     * @return alle eiendommene i string format
     */
    public String getAll() {
        if (!realestates.isEmpty()) {
            String allRealestates = "";
            for (int i = 0; i < realestates.size(); i++) {
                    allRealestates += realestates.get(i).toString() + "\n";
            }

            return allRealestates;
        }

        return null;
    }

    /**
     * Finn en spesifikk eiendom basert på kommunenummeret, gårdsnummeret og bruksnummeret.
     * @return eiendom hvis funnet, null hvis ikke
     */
    public String find(int municipalityNumber, int lotNumber, int sectionNumber) {
        if (!realestates.isEmpty()) {
            for (int i = 0; i < realestates.size(); i++) {
                if (realestates.get(i).getMunicipalityNumber() == municipalityNumber && realestates.get(i).getLotNumber() == lotNumber && realestates.get(i).getSectionNumber() == sectionNumber) {
                    return realestates.get(i).toString();
                }
            }
        }
        return null;
    }

    public double calculateAverageArea() {
        double averageArea = 0.0;
        double totalArea = 0.0;
        if (!realestates.isEmpty()) {
            for (int i = 0; i < realestates.size(); i++) {
                totalArea += realestates.get(i).getArea();
            }
            averageArea = totalArea / realestates.size();
        }

        return averageArea;
    }


}
